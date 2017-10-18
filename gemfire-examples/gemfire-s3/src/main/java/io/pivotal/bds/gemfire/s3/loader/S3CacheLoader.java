package io.pivotal.bds.gemfire.s3.loader;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.pdx.PdxInstance;
import org.apache.geode.pdx.internal.PdxInputStream;

import io.pivotal.bds.metrics.timer.Timer;

public class S3CacheLoader implements CacheLoader<String, PdxInstance>, Declarable {

    private AmazonS3 client;
    private String bucketName;
    private static final Timer timer = new Timer("S3CacheLoader");

    private static final Logger LOG = LoggerFactory.getLogger(S3CacheLoader.class);

    @Override
    public PdxInstance load(LoaderHelper<String, PdxInstance> helper) throws CacheLoaderException {
        String key = helper.getKey();
        String regionName = helper.getRegion().getName();
        LOG.debug("load: key={}, regionName={}", key, regionName);
        
        String path = regionName+"/"+key;

        try {
            timer.start();
            S3Object s3Object = client.getObject(bucketName, path);
            timer.end();

            LOG.debug("load: key={}, regionName={}, s3Object={}", key, regionName, s3Object);

            if (s3Object == null) {
                return null;
            }

            int size = (int) s3Object.getObjectMetadata().getContentLength();
            LOG.debug("load: key={}, regionName={}, size={}", key, regionName, size);

            InputStream is = s3Object.getObjectContent();

            try {
                byte[] bb = new byte[size];
                is.read(bb);

                PdxInputStream pdxIs = new PdxInputStream(bb);

                try {
                    PdxInstance inst = (PdxInstance) pdxIs.readObject();
                    LOG.debug("load: key={}, regionName={}, inst={}", key, regionName, inst);

                    return inst;
                } finally {
                    pdxIs.close();
                }
            } finally {
                is.close();
            }
        } catch (Exception x) {
            LOG.error("load: key={}, regionName={}, x={}", key, regionName, x.toString(), x);
            throw new CacheLoaderException(x.toString(), x);
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
