package org.jcollectd.agent.api;

abstract class AbstractPacket<T> implements Packet<T> {
    private Identifier identifier;
    private long interval;

    AbstractPacket(Identifier identifier) {
        if (identifier == null) {
            throw new IllegalArgumentException("Identifier should not be null");
        }
        this.identifier = identifier;
    }

    @Override
    public void setInterval(long interval) {
        this.interval = interval;
    }

    @Override
    public long getInterval() {
        return this.interval;
    }

    @Override
    public long getTime() {
        return identifier.getTime();
    }

    @Override
    public String getHost() {
        return identifier.getHost();
    }

    @Override
    public String getPlugin() {
        return identifier.getPlugin();
    }

    @Override
    public String getPluginInstance() {
        return identifier.getPluginInstance();
    }

    @Override
    public String getType() {
        return identifier.getType();
    }

    @Override
    public String getTypeInstance() {
        return identifier.getTypeInstance();
    }

    @Override
    public String getSource() {
        return identifier.getSource();
    }

    @Override
    public boolean defined(String instance) {
        return (instance != null) && (instance.length() > 0);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [identifier=" + identifier + ", interval=" + interval + "]";
    }
}
