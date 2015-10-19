# Gemfire Drools
---
## Overview
This component is an example of how [Drools](http://www.drools.org) rules can be deployed to and executed on Gemfire server nodes.  Rule files are uploaded to a replicate Gemfire region.  The key to the region includes the name of the rule file and the RepositoryId for the ruleset (per the standard identification and versioning technique used by Drools, which is based on Maven group/artifact/version tuple).
## Design
Rule files are stored in a replicate region.  The key is a RuleKey, which includes the RepositoryId and the rule name.  The value is Rule, which contains the rule as a string.

A CacheListener registered on the rule region compiles the rule and adds it the virtual file system maintained by Drools.  The virtual file system is a local region which is not persisted, since the Drools virtual file system object is not serializable.

A Function is used to execute the ruleset.  The Function is expected to be called via onRegion so that the rule execution can be distributed across the cluster.  The arguments from the FunctionContext and the filter from the RegionFunctionContext are inserted into the Drools session.  The rules are then executed.

The arguments to the Function are contained in the RuleExecutionContext.  The result from the rule execution is the RuleExecutionResult.