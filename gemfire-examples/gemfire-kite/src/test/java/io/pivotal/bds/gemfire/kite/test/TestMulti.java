package io.pivotal.bds.gemfire.kite.test;

import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetReader;
import org.kitesdk.data.Datasets;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;

import io.pivotal.bds.gemfire.kite.loader.GenericRecordMultiLoader;
import io.pivotal.bds.gemfire.kite.loader.GenericRecordMultiLoader.RangeGenerator;

public class TestMulti {

	private static final String URI = "dataset:hdfs://localhost:8020/datasets/default/test";

	public static void main(String[] args) throws Exception {
		RangeGenerator<Long> gen = new RangeGenerator<Long>() {

			@Override
			public DatasetReader<GenericRecord> apply(Long key, String keyName, Dataset<GenericRecord> dataset) {
				return dataset.from(keyName, key).to(keyName, key + 10).newReader();
			}
		};

		Dataset<GenericRecord> ds = Datasets.load(URI);

		Cache c = new CacheFactory().create();
		RegionFactory<Long, GenericRecord> rf = c.createRegionFactory(RegionShortcut.LOCAL);
		Region<Long, GenericRecord> r = rf.create("ds");
		GenericRecordMultiLoader<Long> l = new GenericRecordMultiLoader<Long>(r, ds, "ts", gen);
		r.getAttributesMutator().setCacheLoader(l);

		for (long i = 0; i < 100; ++i) {
			GenericRecord gr = r.get(i);
			System.out.println(gr);
		}
	}
}
