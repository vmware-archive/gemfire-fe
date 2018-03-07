#!/usr/bin/env bash

if [ -z $LOCATOR_COUNT ]; then
    echo "Missing required environment variable LOCATOR_COUNT"
    exit 1
fi

HOST=`hostname -s`
echo "HOST = $HOST"

if [[ $HOST =~ (.*)-([0-9]+)$ ]]; then
    NAME=${BASH_REMATCH[1]}
else
    echo "Hostname $HOST does not contain ordinal"
    exit 1
fi
echo "NAME = $NAME"

DOMAIN=`hostname -d`
echo "DOMAIN = $DOMAIN"

declare -a LOCATOR_LIST

for ((i=0; i<$LOCATOR_COUNT; i++)); do
    LOCATOR_LIST[i]=$NAME-$i.$DOMAIN[10334]
done

LOCATOR_SPEC=$(IFS=, ; echo "${LOCATOR_LIST[*]}")
echo "LOCATOR_SPEC = $LOCATOR_SPEC"

cat << EOF > /opt/gemfire/bin/run.sh
cd /data
/opt/gemfire/bin/gfsh start locator --name=$HOST-locator --locators=$LOCATOR_SPEC
tail -f /data/$HOST-locator/$HOST-locator.log
EOF

chmod +x /opt/gemfire/bin/run.sh