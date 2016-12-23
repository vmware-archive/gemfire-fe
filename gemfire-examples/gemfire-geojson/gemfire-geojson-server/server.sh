#!/bin/bash

opts="-Xms16g -Xmx16g"
opts="$opts -XX:NewSize=4g -XX:MaxNewSize=4g"
opts="$opts -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=60"
opts="$opts -XX:+DisableExplicitGC"
opts="$opts -Dgemfire.name=`hostname`"

cd server
nohup java $opts -XX:OnOutOfMemoryError="kill -KILL %p" -jar ../gemfire-geojson-server-0.0.1-SNAPSHOT.jar --locators=10.138.0.3[10334] 1>server.out 2>server.err &