package org.jcollectd.agent.api;

public interface Packet<T> extends Identifier {
    void setInterval(long interval);
    long getInterval();
    T getData();
}
