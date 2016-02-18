# Gemfire Utilities
---
## Overview
This is a suite of utility components for Gemfire.  They provide features and facilities that are commonly used in applications built upon Gemfire.

The components include:

* **gemfire-key**.  Base classes for keys used in Gemfire regions.  Can be used with gemfire-keyfw.
* **gemfire-keyfw**.  A framework for generating unique distributed IDs and keys extended from the classes in gemfire-key.  Provides support for colocation within Gemfire partition regions.
* **gemfire-dao**.  A Data Access Object framework.
* **gemfire-util**.  Utility classes.
* **gemfire-security**.  Improved versions of Gemfire templates security classes.
* **gemfire-spark**.  A Spark Receiver implementation that uses a CacheListener.
* **gemfire-ml**.  Gemfire classes for performing Machine Learning.
* **gemfire-federated**.  A framework for federating multiple Gemfire clusters into a single logical cluster.