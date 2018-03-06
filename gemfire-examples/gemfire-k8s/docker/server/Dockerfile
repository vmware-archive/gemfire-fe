FROM gemfire-base:9.3.0

ENV server_port=40404
ENV locators=localhost[10334]
EXPOSE $server_port

ENTRYPOINT echo server_port=$server_port \
    && echo locators=$locators \
    && /opt/gemfire/bin/gfsh start server \
        --name=$HOSTNAME-server \
        --server-port=$server_port \
        --locators=$locators \
    && tail -f /data/$HOSTNAME-server/$HOSTNAME-server.log