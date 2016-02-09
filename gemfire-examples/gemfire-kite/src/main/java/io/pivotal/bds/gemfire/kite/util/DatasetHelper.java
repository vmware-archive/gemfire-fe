package io.pivotal.bds.gemfire.kite.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.CompressionType;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetDescriptor;
import org.kitesdk.data.DatasetNotFoundException;
import org.kitesdk.data.Datasets;
import org.kitesdk.data.Formats;
import org.kitesdk.data.PartitionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class DatasetHelper {

    private static String base;
    private static String defaultHashFieldName;
    private static int hashBucketCount;
    private static final Map<String, Dataset<GenericRecord>> datasets = new HashMap<>();
    private static final Map<String, Schema> schemas = new HashMap<>();

    private static final Logger LOG = LoggerFactory.getLogger(DatasetHelper.class);

    static {
        base = System.getProperty("base", "hdfs://node2.dev:8020/datasets/default");
        defaultHashFieldName = System.getProperty("defaultHashFieldName", "bucketNumber");
        String hashBucketCountString = System.getProperty("hashBucketCount", "1000");

        LOG.info("init: base={}, defaultHashFieldName={}, hashBucketCount={}", base, defaultHashFieldName, hashBucketCountString);

        Assert.hasText(base, "Missing property 'base'");
        Assert.hasText(defaultHashFieldName, "Missing property 'defaultHashFieldName'");

        if (base.endsWith("/")) {
            base = base.substring(0, base.length() - 1);
        }

        hashBucketCount = Integer.parseInt(hashBucketCountString);
    }

    public static int getHashBucketCount() {
        return hashBucketCount;
    }

    public static synchronized Schema getSchema(String name) {
        Schema s = schemas.get(name);

        if (s == null) {
            String schemaFile = name + ".avsc";

            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(schemaFile);
            Assert.notNull(is, "File not found: " + schemaFile);

            Schema schema = null;
            try {
                schema = new Schema.Parser().parse(is);
            } catch (IOException x2) {
                throw new IllegalArgumentException(x2.toString(), x2);
            }

            s = schema;
            schemas.put(name, schema);
        }

        return s;
    }

    public static Dataset<GenericRecord> getDataset(String name) {
        return getDataset(name, defaultHashFieldName);
    }

    public static synchronized Dataset<GenericRecord> getDataset(String name, String hashField) {
        LOG.debug("getDataset: name={}", name);

        Dataset<GenericRecord> ds = datasets.get(name);

        if (ds == null) {
            String dsBase = base + "/" + name;
            String dsUri = "dataset:" + dsBase;

            try {
                ds = Datasets.load(dsUri);
                LOG.debug("getDataset: found dataset: name={}, dsBase={}, dsUri={}", name, dsBase, dsUri);
            } catch (DatasetNotFoundException x) {
                LOG.info("getDataset: creating dataset: name={}, dsBase={}, dsUri={}", name, dsBase, dsUri);
                String dsLoc = dsBase + "/data";
                Schema schema = getSchema(name);

                PartitionStrategy ps = new PartitionStrategy.Builder().hash(hashField, hashBucketCount).build();

                DatasetDescriptor desc = new DatasetDescriptor.Builder().format(Formats.PARQUET).schema(schema).location(dsLoc)
                        .compressionType(CompressionType.Uncompressed).partitionStrategy(ps).build();

                ds = Datasets.create(dsUri, desc);
            }

            datasets.put(name, ds);
        }

        return ds;
    }
}
