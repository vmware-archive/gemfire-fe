#!/bin/bash

dir=/Users/tdalsing/projects/gemfire-fe/gemfire-examples/gemfire-geo
cp=$dir/src/main/resources:$dir/target/classes

for i in `ls $dir/target/dependency/*.jar`; do
   cp=$cp:$i
done 

args="-Dgemfire.locators=localhost[10334] -Dgemfire.cache-xml-file=$dir/src/main/resources/server-cache.xml -Dlog4j.configurationFile=$dir/src/main/resources/log4j2.xml"

pushd $dir/server
java -cp $cp -Xmx2g $args com.gemstone.gemfire.distributed.ServerLauncher start server
popd