# Gemfire Groovy
---
## Overview
This component demonstrates the use of the [GroovyScriptEngine](http://www.groovy-lang.org/integrating.html#_groovyscriptengine) within a Gemfire server node.  This technique allows complete applications written in [Groovy](http://www.groovy-lang.org) to be deployed and executed in a Gemfire cluster.

It is highly desirable to execute as much code inside the Gemfire server node as possible due the local availability of cache data.  This is one of the most important features of Gemfire.  However, deploying code to the Gemfire server presents a number of challenges.

There are 3 traditional ways to deploy code to the Gemfire server:

1. Deploy code using GFSH
2. Deploy the Gemfire server inside of a Spring application (normally using Spring Boot)
3. Put the code in a JAR on the Gemfire server classpath and reference the code in cache.xml

*Deploy via GFSH*

The native code deployment feature of Gemfire is somewhat simplistic and coarse-grained.  Code is deployed in JAR files via GFSH.  Even if a single method in a single class is changed the entire JAR file must be deployed.  This can complicate build and deploy processes and strategies.

*Deploy Spring Boot Application*

Deploying Gemfire server nodes embedded inside of a Spring Boot application provides considerable flexibility since all of the features of Spring are available.  Any Spring module can be used, including Spring Integration, Spring Batch, etc.  This is a useful technique when the applicaton is very complex and has many different components and services, especially where Spring DI can be used to wire together a large system.  However, this technique has a major disadvantage: the servers must be restarted when new or modified code must be deployed to the server.  If the server is managing a large amount of state restarting a server can be very expensive.  If the data is stored in a disk store it must be reloaded from disk.  If the data is not stored in a disk store it must be replicated to the server (for regions that are REPLICATE) or a rebalance must be used (for regions that are PARTITION).  These operations can be very time-consuming and affect the performance of the cluster.

*Deploy Code via Gemfire Server Classpath*

Deploying code in the Gemfire server classpath also requires the server to be restarted if the code is changed.

This component is intended to provide an alternative to these techniques.  Groovy code is compiled, so it doesn't suffer from the performance problems of other scripting techniques.  Individual Groovy classes can be uploaded, rather than entire JARs.  No data needs to be reloaded and the server node's operation is not affected since it is running while new or modified classes are deployed to the server.

Since Groovy is a dialect of Java, it is easy to transition from Java to Groovy.  Groovy can also call any Java classes, so any Spring module can be utilized.
## Design
The GroovyScriptEngine is a standard integration SPI in the Groovy toolkit.  It is intended for exactly this type of use case.

It expects the Groovy source files to be available via a URL, so a custom URLStreamHandler was created to read the URLConnection from a Gemfire region.  The script source is contained in a Gemfire replicate region.  A local Gemfire region contains the URLConnection.  The custom URLStreamHandler gets the URLConnection from the Gemfire region.  The custom URL is passed to the constructor of the GroovyScriptEngine when it is created.  When the engine needs a class it opens a URLConnection from the URL for the class, which in turn uses the custom URLStreamHandler to get the URLConnection from the Gemfire region.

The GroovyScriptEngine uses the lastModified flag of the URLConnection to determine if the source has changed.  If the lastModified value has changed the class is recompiled.  A CacheListener on the region that contains the Groovy source updates the lastModified value by creating a new URLConnection.

Execution of the Groovy code is accomplished via a Function.  The Function can be called via onRegion so that the execution can be distributed across the entire cluster.  The other methods in FunctionService are also supported.  The arguments to the Function and the filter (if onRegion is used) are bound to the script call so they can be used in the Groovy script.  The script can then call any Groovy or Java class using standard Groovy techniques. 