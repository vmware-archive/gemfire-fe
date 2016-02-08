package io.pivotal.bds.gemfire.kite;

import org.apache.avro.generic.GenericRecord;
import org.kitesdk.data.Dataset;
import org.kitesdk.data.DatasetReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.LoaderHelper;
import com.gemstone.gemfire.cache.Region;

public class GenericRecordMultiLoader<K> implements CacheLoader<K, GenericRecord> {

	public static interface RangeGenerator<K> {
		public DatasetReader<GenericRecord> apply(K key, String keyName, Dataset<GenericRecord> dataset);
	}

	private Region<K, GenericRecord> region;
	private Dataset<GenericRecord> dataset;
	private String keyName;
	private RangeGenerator<K> generator;

	private static final Logger LOG = LoggerFactory.getLogger(GenericRecordCacheLoader.class);

	public GenericRecordMultiLoader(Region<K, GenericRecord> region, Dataset<GenericRecord> dataset,
			String keyName, RangeGenerator<K> generator) {
		this.region = region;
		this.dataset = dataset;
		this.keyName = keyName;
		this.generator = generator;
	}

	@Override
	public GenericRecord load(LoaderHelper<K, GenericRecord> helper) throws CacheLoaderException {
		K key = helper.getKey();
		LOG.debug("key={}", key);

		GenericRecord rec = null;
		int count = 0;
		DatasetReader<GenericRecord> reader = generator.apply(key, keyName, dataset);

		try {
			while (reader.hasNext()) {
				++count;

				GenericRecord gr = reader.next();
				@SuppressWarnings("unchecked")
				K k = (K)gr.get(keyName);

				region.put(k, gr);

				if (k.equals(key)) {
					rec = gr;
				}
			}
		} finally {
			reader.close();
		}

		LOG.debug("key={}, count={}, rec={}", key, count, rec);
		return rec;
	}

	@Override
	public void close() {
	}

}
