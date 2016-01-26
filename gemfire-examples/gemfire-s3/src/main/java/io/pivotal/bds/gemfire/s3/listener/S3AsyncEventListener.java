package io.pivotal.bds.gemfire.s3.listener;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEvent;
import com.gemstone.gemfire.cache.asyncqueue.AsyncEventListener;

import io.pivotal.bds.metrics.timer.Timer;

public class S3AsyncEventListener implements AsyncEventListener, Declarable {

    private AmazonS3 client;
    private String bucketName;
    private static final Timer putTimer = new Timer("S3AsyncEventListener-put");
    private static final Timer deleteTimer = new Timer("S3AsyncEventListener-delete");

    private static final Logger LOG = LoggerFactory.getLogger(S3AsyncEventListener.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("processEvents: events.size={}", events.size());
        }

        try {
            for (AsyncEvent evt : events) {
                LOG.debug("processEvents: evt={}", evt);
                Operation op = evt.getOperation();
                String regionName = evt.getRegion().getName();

                if ((op.isCreate() || op.isUpdate()) && !op.isLoad()) {
                    Object ok = evt.getKey();

                    if (ok.getClass() != String.class) {
                        throw new IllegalArgumentException("Only String keys are supported: " + ok);
                    }

                    String key = ok.toString();
                    String path = regionName+"/"+key;

                    byte[] value = evt.getSerializedValue();
                    int len = value.length;
                    LOG.debug("processEvents: put: key={}, len={}, regionName={}", key, len, regionName);

                    ObjectMetadata meta = new ObjectMetadata();
                    meta.setContentLength(len);
                    meta.setContentType("application/octet-stream");

                    ByteArrayInputStream bis = new ByteArrayInputStream(value);

                    putTimer.start();
                    client.putObject(bucketName, path, bis, meta);
                    putTimer.end();
                } else if (op.isDestroy() && !(op.isEviction() || op.isExpiration())) {
                    Object ok = evt.getKey();

                    if (ok.getClass() != String.class) {
                        throw new IllegalArgumentException("Only String keys are supported: " + ok);
                    }

                    String key = ok.toString();
                    String path = regionName+"/"+key;

                    LOG.debug("processEvents: delete: key={}, regionName={}", key, regionName);

                    deleteTimer.start();
                    client.deleteObject(bucketName, path);
                    deleteTimer.end();
                } else {
                    LOG.debug("processEvents: NOT a create, update, or destroy: evt={}", evt);
                }
            }

            return true;
        } catch (Exception x) {
            LOG.error("processEvents: x={}", x.toString(), x);
            return false;
        }
    }

    @Override
    public void init(Properties props) {
        String awsRegion = props.getProperty("awsRegion", Regions.US_WEST_2.name());
        bucketName = props.getProperty("bucketName", "tdalsing-test");
        LOG.info("init: awsRegion={}, bucketName={}", awsRegion, bucketName);

        Regions awsr = Regions.valueOf(awsRegion);
        client = new AmazonS3Client();
        client.setRegion(Region.getRegion(awsr));
    }

    @Override
    public void close() {
    }

}
