# Gemfire Script
---
## Overview
This component demonstrates the use of the [ScriptEngine API](https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/prog_guide/api.html) of the JDK in a Gemfire server node.
## Design
The design is very simple.  A Function is used to execute the script.  The script is the argument to the Function.  Since the ScriptEngine doesn't compile the script the script is just sent to the server every time.

Due the lack of compilation this technique is only useful for small scripts that are not called repeatedly.  It is too slow and inefficient for high volume use.

The Spring ApplicationContext is a bound parameter to the script so any beans in the context are available to the script.

The most common use for this component is to provide cluster administration.  Any bean in the server node is available, including the Cache.