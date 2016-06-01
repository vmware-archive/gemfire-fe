#!/bin/bash

dir=`pwd`
hn=`hostname`

cp=$dir/target/classes

for i in `ls $dir/target/dependency`; do
   cp=$cp:$dir/target/dependency/$i
done

java -cp "$cp" io.pivotal.bds.gemfire.r.shell.R $1