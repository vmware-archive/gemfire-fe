package io.pivotal.bds.gemfire.s3.writer;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.gemstone.gemfire.cache.CacheWriter;
import com.gemstone.gemfire.cache.CacheWriterException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Operation;
import com.gemstone.gemfire.cache.RegionEvent;
import com.gemstone.gemfire.cache.SerializedCacheValue;
import com.gemstone.gemfire.pdx.PdxInstance;

public class S3CacheWriter implements CacheWriter<String, PdxInstance>, Declarable {

    private AmazonS3 client;
    private String bucketName;

    private static final Logger LOG = LoggerFactory.getLogger(S3CacheWriter.class);

    @Override
    public void beforeCreate(EntryEvent<String, PdxInstance> evt) throws CacheWriterException {
        LOG.debug("beforeCreate: evt={}", evt);
        doPut(evt);
    }

    @Override
    public void beforeDestroy(EntryEvent<String, PdxInstance> evt) throws CacheWriterException {
        LOG.debug("beforeDestroy: evt={}", evt);
        Operation op = evt.getOperation();

        if (!op.isEviction() && !op.isExpiration()) {
            String key = evt.getKey();
            LOG.debug("beforeDestroy: key={}", key);
            client.deleteObject(bucketName, key);
        }
    }

    @Override
    public void beforeRegionClear(RegionEvent<String, PdxInstance> evt) throws CacheWriterException {
    }

    @Override
    public void beforeRegionDestroy(RegionEvent<String, PdxInstance> evt) throws CacheWriterException {
    }

    @Override
    public void beforeUpdate(EntryEvent<String, PdxInstance> evt) throws CacheWriterException {
        LOG.debug("beforeUpdate: evt={}", evt);
        doPut(evt);
    }

    private void doPut(EntryEvent<String, PdxInstance> evt) throws CacheWriterException {
        String key = evt.getKey();
        LOG.debug("doPut: key={}", key);

        try {
            SerializedCacheValue<PdxInstance> scv = evt.getSerializedNewValue();
            byte[] value = scv.getSerializedValue();
            int len = value.length;
            LOG.debug("doPut: key={}, len={}", key, len);

            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(len);
            meta.setContentType("application/octet-stream");

            ByteArrayInputStream bis = new ByteArrayInputStream(value);

            client.putObject(bucketName, key, bis, meta);
        } catch (Exception x) {
            LOG.error("doPut: key={}, x={}", key, x.toString(), x);
            throw new CacheWriterException(x.toString(), x);
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
