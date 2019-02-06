package io.pivotal.bds.gemfire.spark;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;

public class GemfireReceiverTest {

    private static final Logger LOG = LoggerFactory.getLogger(GemfireReceiverTest.class);

    public static void main(String[] args) throws Exception {
        LOG.info("Creating context");
        SparkConf conf = new SparkConf().setAppName("GemfireReceiverTest").setMaster("local[3]");
        JavaStreamingContext ctx = new JavaStreamingContext(conf, Durations.seconds(10L));

        LOG.info("Creating cache");
        Cache cache = new CacheFactory().create();
        RegionFactory<String, String> regionFactory = cache.createRegionFactory(RegionShortcut.REPLICATE);
        Region<String, String> region = regionFactory.create("test");

        LOG.info("Creating root");
        JavaDStream<String> root = ctx
                .receiverStream(new GemfireReceiver<String, String>(StorageLevel.MEMORY_ONLY(), "test"));

        LOG.info("Executing foreach");
        root.foreachRDD(
                new VoidFunction<JavaRDD<String>>() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void call(JavaRDD<String> v1) throws Exception {
                        LOG.error("v1={}", v1);
                        List<String> l = v1.collect();
                        for (String s : l) {
                            LOG.error(" s={}", s);
                        }
                    }
                });

        LOG.info("Starting");
        ctx.start();
        ctx.awaitTermination();
    }
}
