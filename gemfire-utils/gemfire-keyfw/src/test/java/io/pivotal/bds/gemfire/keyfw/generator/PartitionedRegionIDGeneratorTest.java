package io.pivotal.bds.gemfire.keyfw.generator;

import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.ResultCollector;
import io.pivotal.bds.gemfire.mock.MockRegion;
import io.pivotal.bds.gemfire.util.FunctionServiceHelper;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class PartitionedRegionIDGeneratorTest {

    @Mock Execution execution;
    @Mock FunctionServiceHelper functionServiceHelper;
    @Mock ResultCollector<?,?> resultCollector;
    PartitionedRegionIDGenerator idGenerator;
    Collection<long[]> collection;

    @BeforeClass
    void beforeClass() {
        MockitoAnnotations.initMocks(this);

        collection = Arrays.asList(new long[]{0L,3L});
        when(functionServiceHelper.onRegion(any())).thenReturn(execution);
        when(execution.withArgs(any())).thenReturn(execution);
        when(execution.withFilter(any())).thenReturn(execution);
        doReturn(resultCollector).when(execution).execute(anyString());
        doReturn(collection).when(resultCollector).getResult();
        idGenerator = new PartitionedRegionIDGenerator(new MockRegion<>("id"), functionServiceHelper);
    }

    @Test
    void getId() {
        assertEquals((long)idGenerator.generate("test"), 0L);
        assertEquals((long)idGenerator.generate("test"), 1L);
        assertEquals((long)idGenerator.generate("test"), 2L);
        assertEquals((long)idGenerator.generate("test"), 3L);
    }
}
