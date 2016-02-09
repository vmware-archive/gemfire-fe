package io.pivotal.bds.gemfire.util.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gemstone.gemfire.cache.EntryOperation;
import com.gemstone.gemfire.internal.cache.EntryOperationImpl;

import io.pivotal.bds.gemfire.util.EncodedStringPartitionResolver;

public class PartitionResolverTest {

    @Test
    public void testPostfix() throws Exception {
        Properties props = new Properties();

        EncodedStringPartitionResolver<String> postfixResolver = new EncodedStringPartitionResolver<>();
        postfixResolver.init(props);

        check(postfixResolver, "prefix:postfix", "postfix");

        try {
            check(postfixResolver, "prefix:", "postfix");
            Assert.fail();
        } catch (Exception x) {
            // no-op
        }
    }

    @Test
    public void testPrefix() throws Exception {
        Properties props = new Properties();
        props.setProperty("location", "prefix");

        EncodedStringPartitionResolver<String> prefixResolver = new EncodedStringPartitionResolver<>();
        prefixResolver.init(props);

        check(prefixResolver, "prefix:postfix", "prefix");

        try {
            check(prefixResolver, ":postfix", "postfix");
            Assert.fail();
        } catch (Exception x) {
            // no-op
        }
    }

    @SuppressWarnings("unchecked")
    private static void check(EncodedStringPartitionResolver<String> resolver, String key, String exp) {
        EntryOperation<String, String> op = new EntryOperationImpl(null, null, key, null, null);
        Object ro = resolver.getRoutingObject(op);
        Assert.assertEquals(ro, exp);
    }
}
