package io.pivotal.bds.gemfire.util;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import static org.testng.Assert.*;

public class ReflectionBasedDataSerializerTest {

    public static class TestObject {

        private int intValue;
        private Integer integerWrapperValue;
        private long longValue;
        private Long longWrapperValue;
        private double doubleValue;
        private Double doubleWrapperValue;
        private transient int transientInt;
        private static int staticInt = 0;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public Integer getIntegerWrapperValue() {
            return integerWrapperValue;
        }

        public void setIntegerWrapperValue(Integer integerWrapperValue) {
            this.integerWrapperValue = integerWrapperValue;
        }

        public long getLongValue() {
            return longValue;
        }

        public void setLongValue(long longValue) {
            this.longValue = longValue;
        }

        public Long getLongWrapperValue() {
            return longWrapperValue;
        }

        public void setLongWrapperValue(Long longWrapperValue) {
            this.longWrapperValue = longWrapperValue;
        }

        public double getDoubleValue() {
            return doubleValue;
        }

        public void setDoubleValue(double doubleValue) {
            this.doubleValue = doubleValue;
        }

        public Double getDoubleWrapperValue() {
            return doubleWrapperValue;
        }

        public void setDoubleWrapperValue(Double doubleWrapperValue) {
            this.doubleWrapperValue = doubleWrapperValue;
        }

        public int getTransientInt() {
            return transientInt;
        }

        public void setTransientInt(int transientInt) {
            this.transientInt = transientInt;
        }

        public static int getStaticInt() {
            return staticInt;
        }

        public static void setStaticInt(int staticInt) {
            TestObject.staticInt = staticInt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TestObject that = (TestObject) o;

            if (intValue != that.intValue) return false;
            if (longValue != that.longValue) return false;
            if (Double.compare(that.doubleValue, doubleValue) != 0) return false;
            if (transientInt != that.transientInt) return false;
            if (integerWrapperValue != null ? !integerWrapperValue.equals(that.integerWrapperValue) : that.integerWrapperValue != null)
                return false;
            if (longWrapperValue != null ? !longWrapperValue.equals(that.longWrapperValue) : that.longWrapperValue != null)
                return false;
            return doubleWrapperValue != null ? doubleWrapperValue.equals(that.doubleWrapperValue) : that.doubleWrapperValue == null;
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "intValue=" + intValue +
                    ", integerWrapperValue=" + integerWrapperValue +
                    ", longValue=" + longValue +
                    ", longWrapperValue=" + longWrapperValue +
                    ", doubleValue=" + doubleValue +
                    ", doubleWrapperValue=" + doubleWrapperValue +
                    ", transientInt=" + transientInt +
                    '}';
        }
    }

    ReflectionBasedDataSerializer serializer;

    @BeforeTest
    void before() {
        serializer = new ReflectionBasedDataSerializer(1001, TestObject.class);
    }

    @Test
    void serializeDeserialize() throws Exception {
        TestObject obj = new PodamFactoryImpl().manufacturePojoWithFullData(TestObject.class);
        System.out.println(obj);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        serializer.toData(obj, dataOutputStream);

        byte[] data = byteArrayOutputStream.toByteArray();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        TestObject obj2 = (TestObject) serializer.fromData(dataInputStream);

        assertEquals(obj,obj2);
    }
}
