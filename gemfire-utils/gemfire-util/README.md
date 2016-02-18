# Gemfire Utilities
This component provides some general helper and other useful classes, including:
* List, Map, and Set collections that implement DataSerializable.
* Collections that are highly concurrent via Java Locking.  These are much more efficient than the concurrent collections from the JDK.
* Additional compressors for GZIP and ZLIB.
* Helper classes for Regions, Locator strings, Assert w/formatted strings
* An abstract AsyncEventListener that does back-off for repeated errors (e.g., when a back-end system isn't reachable).
* A JSON/PDX converter that allows the PDX name to be specified so that domain classes can be used.