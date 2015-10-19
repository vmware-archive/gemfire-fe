package io.pivotal.bds.gemfire.drools.server.listener;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.builder.Message.Level;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.drools.common.Rule;
import io.pivotal.bds.gemfire.drools.common.RuleKey;

public class RuleCacheListener extends CacheListenerAdapter<RuleKey, Rule> {

    private KieServices services;
    private KieRepository repository;
    private Region<ReleaseId, KieFileSystem> fileSystemRegion;

    private static final Logger LOG = LoggerFactory.getLogger(RuleCacheListener.class);

    public RuleCacheListener(KieServices services, KieRepository repository, Region<ReleaseId, KieFileSystem> fileSystemRegion) {
        this.services = services;
        this.repository = repository;
        this.fileSystemRegion = fileSystemRegion;
    }

    @Override
    public void afterCreate(EntryEvent<RuleKey, Rule> event) {
        RuleKey key = event.getKey();
        Rule rule = event.getNewValue();
        LOG.info("afterCreate: key={}, rule={}", key, rule);

        String name = key.getName();
        ReleaseId rel = key.getReleaseId();
        String path = createPath(rel, name);

        KieFileSystem fs = fileSystemRegion.get(rel);
        fs.write(path, rule.getRule());

        build(fs, rel);
    }

    @Override
    public void afterDestroy(EntryEvent<RuleKey, Rule> event) {
        RuleKey key = event.getKey();
        LOG.info("afterDestroy: key={}", key);
        ReleaseId rel = key.getReleaseId();
        KieFileSystem fs = fileSystemRegion.get(rel);
        String path = createPath(rel, key.getName());
        fs.delete(path);
        build(fs, rel);
    }

    @Override
    public void afterUpdate(EntryEvent<RuleKey, Rule> event) {
        RuleKey key = event.getKey();
        Rule rule = event.getNewValue();
        LOG.info("afterUpdate: key={}, rule={}", key, rule);

        String name = key.getName();
        ReleaseId rel = key.getReleaseId();
        String path = createPath(rel, name);

        KieFileSystem fs = fileSystemRegion.get(rel);
        fs.write(path, rule.getRule());

        build(fs, rel);
    }

    private String createPath(ReleaseId relId, String name) {
        StringBuilder buf = new StringBuilder("src/main/resources/");
        String groupPath = relId.getGroupId().replace('.', '/');
        buf.append(groupPath).append('/');
        buf.append(relId.getArtifactId()).append('/');
        buf.append(relId.getVersion()).append('/');
        buf.append(name).append(".drl");
        String path = buf.toString();
        LOG.info("createPath: relId={}, name={}, path={}", relId, name, path);
        return path;
    }

    private void build(KieFileSystem fs, ReleaseId relId) {
        fs.generateAndWritePomXML(relId);

        KieBuilder kb = services.newKieBuilder(fs);
        kb.buildAll();

        Results results = kb.getResults();

        List<Message> msgs = results.getMessages();

        for (Message msg : results.getMessages()) {
            switch (msg.getLevel()) {
                case ERROR: {
                    LOG.error("message: line={}, column={}, path={}, text={}", msg.getLine(), msg.getColumn(), msg.getPath(),
                            msg.getText());
                    break;
                }
                case WARNING: {
                    LOG.warn("message: line={}, column={}, path={}, text={}", msg.getLine(), msg.getColumn(), msg.getPath(),
                            msg.getText());
                    break;
                }
                case INFO: {
                    LOG.info("message: line={}, column={}, path={}, text={}", msg.getLine(), msg.getColumn(), msg.getPath(),
                            msg.getText());
                    break;
                }
                default: {
                    LOG.error("message: level={}, line={}, column={}, path={}, text={}", msg.getLevel(), msg.getLine(),
                            msg.getColumn(), msg.getPath(), msg.getText());
                }
            }
        }

        msgs = results.getMessages(Level.ERROR);

        if (!msgs.isEmpty()) {
            StringBuilder buf = new StringBuilder("error(s) building rules: ");

            for (int i = 0; i < msgs.size(); ++i) {
                Message msg = msgs.get(i);

                if (i > 0) {
                    buf.append("; ");
                }

                buf.append("line=").append(msg.getLine());
                buf.append(", column=").append(msg.getColumn());
                buf.append(", path=").append(msg.getPath());
                buf.append(", text=").append(msg.getText());
            }

            String s = buf.toString();
            throw new IllegalArgumentException(s);
        }

        KieModule module = kb.getKieModule();
        repository.addKieModule(module);
    }
}
