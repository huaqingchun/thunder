package com.microservice.thunder.config;

public class ReferenceConfig extends AbstractConfig {

    private static final long serialVersionUID = -6415071738986650995L;

    private String interfaze;

    private int timeout;

    private String version;

    private String loadbalance;

    private String proxy;

    private boolean sent;

    private int executes;

    public String getInterfaze() {
        return interfaze;
    }

    public void setInterfaze(String interfaze) {
        checkName("interfaze", interfaze);
        this.interfaze = interfaze;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        checkName("version", version);
        this.version = version;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        this.loadbalance = loadbalance;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public int getExecutes() {
        return executes;
    }

    public void setExecutes(int executes) {
        this.executes = executes;
    }

}
