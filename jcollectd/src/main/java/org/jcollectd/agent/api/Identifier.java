package org.jcollectd.agent.api;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: andrus
 * Date: 6/20/12
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Identifier {
    long getTime();

    String getHost();

    String getPlugin();

    String getPluginInstance();

    String getType();

    String getTypeInstance();

    String getSource();

    String toString();

    boolean defined(String instance);

    public static class Builder {
        private long time;
        private String host;
        private String plugin;
        private String pluginInstance;
        private String type;
        private String typeInstance;

        public Builder() {
        }

        public Builder(Identifier identifier) {
            time = identifier.getTime();
            host = identifier.getHost();
            plugin = identifier.getPlugin();
            pluginInstance = identifier.getPlugin();
            type = identifier.getPlugin();
            typeInstance = identifier.getType();
        }

        public Builder time(long time) {
            this.time = time;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder plugin(String plugin) {
            this.plugin = strip(plugin);
            return this;
        }

        public Builder pluginInstance(String pluginInstance) {
            this.pluginInstance = strip(pluginInstance);
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder typeInstance(String typeInstance) {
            this.typeInstance = typeInstance;
            return this;
        }

        public Identifier build() {
            IdentifierImpl identifier = new IdentifierImpl();
            identifier.time = time;
            identifier.host = host;
            identifier.plugin = plugin;
            identifier.pluginInstance = pluginInstance;
            identifier.type = type;
            identifier.typeInstance = typeInstance;
            return identifier;
        }

        private String strip(String string) {
            if (string != null)
                string = string.replaceAll("[\\s\"]+", "_");
            return string;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static Builder builder(Identifier identifier) {
            return new Builder(identifier);
        }

    }

    static class IdentifierImpl implements Identifier {

        private long time;
        private String host;
        private String plugin;
        private String pluginInstance;
        private String type;
        private String typeInstance;

        IdentifierImpl() {
        }

        @Override
        public long getTime() {
            return time;
        }

        @Override
        public String getHost() {
            return host;
        }

        @Override
        public String getPlugin() {
            return plugin;
        }

        @Override
        public String getPluginInstance() {
            return pluginInstance;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public String getTypeInstance() {
            return typeInstance;
        }

        @Override
        public String getSource() {
            StringBuffer sb = new StringBuffer();
            appendToSource(sb, host);
            appendToSource(sb, plugin);
            appendToSource(sb, pluginInstance);
            appendToSource(sb, type);
            appendToSource(sb, typeInstance);
            return sb.toString();
        }

        private void appendToSource(StringBuffer sb, String value) {
            if (defined(value)) {
                if (sb.length() != 0) {
                    sb.append('/');
                }
                sb.append(value);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[').append(new Date(time)).append("] ");
            sb.append(getSource());
            return sb.toString();
        }

        @Override
        public boolean defined(String instance) {
            return (instance != null) && (instance.length() > 0);
        }

    }
}
