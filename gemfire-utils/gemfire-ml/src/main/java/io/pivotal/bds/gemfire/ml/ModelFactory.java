package io.pivotal.bds.gemfire.ml;

import java.util.Properties;

public interface ModelFactory {

    String[] getPropertyNames();

    Model create(String name, String attributeName, Properties properties);
}
