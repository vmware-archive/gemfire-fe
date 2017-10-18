package io.pivotal.bds.gemfire.drools.server.loader;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;

public class KieFileSystemCacheLoader implements CacheLoader<ReleaseId, KieFileSystem> {

    private KieServices services;

    private static final Logger LOG = LoggerFactory.getLogger(KieFileSystemCacheLoader.class);

    public KieFileSystemCacheLoader(KieServices services) {
        this.services = services;
    }

    @Override
    public void close() {
    }

    @Override
    public KieFileSystem load(LoaderHelper<ReleaseId, KieFileSystem> helper) throws CacheLoaderException {
        ReleaseId relId = helper.getKey();
        LOG.info("load: releaseId={}", relId);
        KieFileSystem fs = services.newKieFileSystem();
        fs.generateAndWritePomXML(relId);
        return fs;
    }
}
