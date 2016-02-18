# Gemfire Key Framework
This component provides additional support for generating IDs and key instances that builds on the gemfire-key component.  Included in this component:
* Abstract implmentations of BaseKey and BaseColocationKey that implement PdxSerializable.
* A PartitionResolver implementation that works with any class that implements ColocationID from gemfire-key.
* A framework for generically generating unique IDs across the cluster.

The id generation framework has several different implementations:
* A distributed long generator that uses local, persistent regions to store the next ID.  Uniqueness across multiple servers is achieved by using a prefix that is different for each server that is left shifted to the highest byte of the initial long value.
* A long generator that uses a partition region and a function that allows synchronization when obtaining the next ID.
* A string generator that uses UUID.