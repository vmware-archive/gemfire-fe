package io.pivotal.bds.gemfire.kite.loader;

import java.util.ArrayList;
import java.util.List;

import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.kite.Key;

public class ListGenericRecordCacheLoader implements CacheLoader<Key, List<GenericRecord>> {

	private Dataset<GenericRecord> dataset;

	private static final Logger LOG = LoggerFactory.getLogger(ListGenericRecordCacheLoader.class);

	public ListGenericRecordCacheLoader(Dataset<GenericRecord> dataset) {
		this.dataset = dataset;
	}

	@Override
	public void close() {
	}

	@Override
	public List<GenericRecord> load(LoaderHelper<Key, List<GenericRecord>> helper) throws CacheLoaderException {
		Key k = helper.getKey();
		LOG.info("k={}", k);

		long start = k.getStart();
		long end = k.getEnd();

		List<GenericRecord> list = new ArrayList<>();
		DatasetReader<GenericRecord> reader = dataset.from("ts", start).to("ts", end).newReader();

		try {
			while (reader.hasNext()) {
				GenericRecord rec = reader.next();
				list.add(rec);
			}
		} finally {
			reader.close();
		}

		LOG.info("k={}, list={}", k, list);
		return list;
	}

}
