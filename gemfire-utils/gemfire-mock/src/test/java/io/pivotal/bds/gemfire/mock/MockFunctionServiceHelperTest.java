package io.pivotal.bds.gemfire.mock;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class MockFunctionServiceHelperTest {

    @Test
    public void test() {
        TestFunction function = new TestFunction();
        MockRegion<Object, Object> mockRegion = new MockRegion<>("mock");
        MockFunctionServiceHelper helper = new MockFunctionServiceHelper(function);

        Object result = helper.onRegion(mockRegion).withArgs("args").withFilter(Collections.singleton("filter")).execute(function
                .getId()).getResult();

        assertNotNull(result);
        assertTrue(result instanceof List);

        List<Object> list = (List<Object>)result;

        assertFalse(list.isEmpty());

        assertEquals("args", list.get(0));
        assertEquals(function.getId(), list.get(1));
        assertTrue(list.get(2) == mockRegion);
        assertTrue(list.get(3) instanceof Set);

        Set<Object> filter = (Set<Object>) list.get(3);
        assertNotNull(filter);
        assertEquals(1,filter.size());
        assertEquals("filter",filter.iterator().next());

        assertTrue(list.get(4) instanceof Exception);
    }
}