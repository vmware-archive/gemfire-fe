package io.pivotal.bds.gemfire.kite.test;

import java.util.Calendar;
import java.util.List;

import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.Datasets;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.RegionFactory;
import com.gemstone.gemfire.cache.RegionShortcut;

import io.pivotal.bds.gemfire.kite.Key;
import io.pivotal.bds.gemfire.kite.loader.ListGenericRecordCacheLoader;

public class Test {

	private static final String URI = "dataset:hdfs://localhost:8020/datasets/default/test";

	public static void main(String[] args) throws Exception {
		Dataset<GenericRecord> ds = Datasets.load(URI);

		Cache c = new CacheFactory().create();
		RegionFactory<Key, List<GenericRecord>> rf = c.createRegionFactory(RegionShortcut.LOCAL);
		rf.setCacheLoader(new ListGenericRecordCacheLoader(ds));
		Region<Key, List<GenericRecord>> r = rf.create("ds");

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		for (int i = 0; i < 10; ++i) {
			long start = cal.getTimeInMillis();
			cal.add(Calendar.MINUTE, 10);
			long end = cal.getTimeInMillis();

			Key k = new Key(start, end);
			List<GenericRecord> ret = r.get(k);
			System.out.println(ret);
		}
	}
}
