#!/usr/bin/env bash

if [ -z $LOCATOR_SPEC ]; then
    echo "Missing required environment variable $LOCATOR_SPEC"
    exit 1
fi

echo "$LOCATOR_SPEC = $$LOCATOR_SPEC"

HOST=`hostname -s`
echo "HOST = $HOST"

cat << EOF > /opt/gemfire/bin/run.sh
cd /data
rm -Rf /data/*
/opt/gemfire/bin/gfsh start server --name=$HOST-server --locators=$LOCATOR_SPEC
tail -f /data/$HOST-server/$HOST-server.log
EOF

chmod +x /opt/gemfire/bin/run.sh