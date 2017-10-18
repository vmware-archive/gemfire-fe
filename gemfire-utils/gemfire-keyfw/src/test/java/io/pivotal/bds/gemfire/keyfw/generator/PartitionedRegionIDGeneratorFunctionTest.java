package io.pivotal.bds.gemfire.keyfw.generator;

import org.apache.geode.cache.Region;
import io.pivotal.bds.gemfire.mock.MockFunctionServiceHelper;
import io.pivotal.bds.gemfire.mock.MockRegion;
import io.pivotal.bds.gemfire.util.FunctionServiceHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Collections;

import static org.testng.Assert.*;

public class PartitionedRegionIDGeneratorFunctionTest {

    private Region<String, Long> idRegion;
    private FunctionServiceHelper functionServiceHelper;

    @BeforeMethod
    void beforeMethod() {
        idRegion = new MockRegion<>("idRegion");
        functionServiceHelper = new MockFunctionServiceHelper(new PartitionedRegionIDGeneratorFunction(2, idRegion));
    }

    @Test
    void usingArgs() {
        Collection<long[]> coll = (Collection<long[]>) functionServiceHelper
                .onRegion(idRegion)
                .withArgs("test")
                .execute("PartitionedRegionIDGeneratorFunction")
                .getResult();

        assertEquals(coll.size(), 1);

        long[] ids = coll.iterator().next();
        assertEquals(ids.length, 2);

        assertEquals(ids[0], 0);
        assertEquals(ids[1], 1);
    }

    @Test
    void usingFilter() {
        Collection<long[]> coll = (Collection<long[]>) functionServiceHelper
                .onRegion(idRegion)
                .withFilter(Collections.singleton("domain"))
                .execute("PartitionedRegionIDGeneratorFunction")
                .getResult();

        assertEquals(coll.size(), 1);

        long[] ids = coll.iterator().next();
        assertEquals(ids.length, 2);

        assertEquals(ids[0], 0);
        assertEquals(ids[1],1);
    }

    @Test
    void usingArgsMultipleCalls() {
        Collection<long[]> coll1 = (Collection<long[]>) functionServiceHelper
                .onRegion(idRegion)
                .withArgs("test")
                .execute("PartitionedRegionIDGeneratorFunction")
                .getResult();

        assertEquals(coll1.size(), 1);

        long[] ids1 = coll1.iterator().next();
        assertEquals(ids1.length, 2);

        assertEquals(ids1[0], 0);
        assertEquals(ids1[1], 1);

        Collection<long[]> coll2 = (Collection<long[]>) functionServiceHelper
                .onRegion(idRegion)
                .withArgs("test")
                .execute("PartitionedRegionIDGeneratorFunction")
                .getResult();

        assertEquals(coll2.size(), 1);

        long[] ids2 = coll2.iterator().next();
        assertEquals(ids2.length, 2);

        assertEquals(ids2[0], 2);
        assertEquals(ids2[1], 3);
    }

}
