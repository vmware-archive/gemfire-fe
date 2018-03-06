FROM gemfire-base:9.3.0

EXPOSE 10334 1099 7070

ENTRYPOINT /opt/gemfire/bin/gfsh start locator --name=$HOSTNAME-locator && \
    tail -f /data/$HOSTNAME-locator/$HOSTNAME-locator.log