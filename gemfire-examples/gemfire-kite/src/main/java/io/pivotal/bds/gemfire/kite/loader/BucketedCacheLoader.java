package io.pivotal.bds.gemfire.kite.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.kite.util.AvroHelper;
import io.pivotal.bds.gemfire.kite.util.DatasetHelper;

public class BucketedCacheLoader<K> implements CacheLoader<Integer, List<PdxInstance>>, Declarable {

    private String bucketNumberFieldName;

    private static final Logger LOG = LoggerFactory.getLogger(BucketedCacheLoader.class);

    @Override
    public List<PdxInstance> load(LoaderHelper<Integer, List<PdxInstance>> helper) throws CacheLoaderException {
        String regionName = (String) helper.getArgument();
        Integer bucketNumber = helper.getKey();
        LOG.debug("load: regionName={}, bucketNumber={}", regionName, bucketNumber);

        try {
            Dataset<GenericRecord> dataset = DatasetHelper.getDataset(regionName);

            List<PdxInstance> list = new ArrayList<>();
            DatasetReader<GenericRecord> reader = dataset.from(bucketNumberFieldName, bucketNumber)
                    .to(bucketNumberFieldName, bucketNumber).newReader();

            try {
                while (reader.hasNext()) {
                    GenericRecord rec = reader.next();
                    PdxInstance inst = AvroHelper.convertToPdx(rec);
                    list.add(inst);
                }
            } finally {
                reader.close();
            }

            LOG.debug("load: regionName={}, bucketNumber={}, list={}", regionName, bucketNumber, list);
            return list;
        } catch (Exception x) {
            LOG.error("load: regionName={}, bucketNumber={}, x={}", regionName, bucketNumber, x.toString(), x);
            throw new CacheLoaderException(x.toString(), x);
        }
    }

    @Override
    public void init(Properties props) {
        bucketNumberFieldName = props.getProperty("bucketNumberFieldName", "bucketNumber");
        LOG.info("init: bucketNumberFieldName={}", bucketNumberFieldName);
    }

    @Override
    public void close() {
    }
}
