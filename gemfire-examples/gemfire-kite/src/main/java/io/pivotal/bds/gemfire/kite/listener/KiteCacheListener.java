package io.pivotal.bds.gemfire.kite.listener;

import org.apache.avro.generic.GenericRecord;

import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.kite.Key;

public class KiteCacheListener extends CacheListenerAdapter<Key, GenericRecord> {

}
