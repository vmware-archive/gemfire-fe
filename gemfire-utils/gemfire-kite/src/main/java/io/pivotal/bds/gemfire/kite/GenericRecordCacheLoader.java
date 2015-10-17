package io.pivotal.bds.gemfire.kite;

import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;

public class GenericRecordCacheLoader<T> implements CacheLoader<Comparable<T>, GenericRecord> {

	private Dataset<GenericRecord> dataset;
	private String keyName;

	private static final Logger LOG = LoggerFactory.getLogger(GenericRecordCacheLoader.class);

	public GenericRecordCacheLoader(Dataset<GenericRecord> dataset, String keyName) {
		this.dataset = dataset;
		this.keyName = keyName;
	}

	@Override
	public GenericRecord load(LoaderHelper<Comparable<T>, GenericRecord> helper) throws CacheLoaderException {
		Comparable<T> k = helper.getKey();
		LOG.debug("k={}", k);

		DatasetReader<GenericRecord> reader = dataset.from(keyName, k).to(keyName, k).newReader();

		try {
			if (reader.hasNext()) {
				GenericRecord rec = reader.next();
				LOG.debug("k={}, rec={}", k, rec);
				return rec;
			} else {
				LOG.debug("k={}: no record found", k);
				return null;
			}
		} finally {
			reader.close();
		}
	}

	@Override
	public void close() {
	}

}
