package io.pivotal.bds.gemfire.jdbc.util;

public class ConnectionConfiguration {

    private Class<?> driverClass;
    private String url;
    private String username;
    private String password;
    private int minimumPoolSize;
    private int maximumPoolSize;

    public ConnectionConfiguration() {
    }

    public Class<?> getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(Class<?> driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMinimumPoolSize() {
        return minimumPoolSize;
    }

    public void setMinimumPoolSize(int minimumPoolSize) {
        this.minimumPoolSize = minimumPoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConnectionConfiguration other = (ConnectionConfiguration) obj;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ConnectionConfiguration [driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password="
                + password + ", minimumPoolSize=" + minimumPoolSize + ", maximumPoolSize=" + maximumPoolSize + "]";
    }

}
