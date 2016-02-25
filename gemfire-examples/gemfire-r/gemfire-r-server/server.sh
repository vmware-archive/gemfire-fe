#!/bin/bash

dir=`pwd`
hn=`hostname`

cp=$dir/target/classes:$dir/src/main/config

for i in `ls $dir/target/dependency`; do
   cp=$cp:$dir/target/dependency/$i
done

gfsh start server --name=server --cache-xml-file=$dir/src/main/config/server-cache.xml --classpath="$cp" --locators=$hn[10334]