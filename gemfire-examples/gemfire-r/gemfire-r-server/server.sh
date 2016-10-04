#!/bin/bash

dir=`pwd`
hn=`hostname`

cp=$dir/target/classes:$dir/src/main/config

for i in `ls $dir/target/dependency`; do
   cp=$cp:$dir/target/dependency/$i
done

cd server
nohup java -cp $cp -Dgemfire.locators=$hn[10334] -Dgemfire.cache-xml-file=$dir/src/main/config/server-cache.xml com.gemstone.gemfire.distributed.ServerLauncher start server &

# gfsh start server --name=server --cache-xml-file=$dir/src/main/config/server-cache.xml --classpath="$cp" --locators=localhost[10334]
