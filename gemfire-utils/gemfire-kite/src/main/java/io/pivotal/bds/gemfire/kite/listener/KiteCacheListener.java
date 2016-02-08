package io.pivotal.bds.gemfire.kite;

import org.apache.avro.generic.GenericRecord;

import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

public class KiteCacheListener extends CacheListenerAdapter<Key, GenericRecord> {

}
