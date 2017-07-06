package com.microservice.thunder.config;

public class MethodConfig extends AbstractConfig {

    private static final long serialVersionUID = -4063856751757066325L;
    private String name;
    private String argsType;
    private int timeout;
    private boolean async;
    private String callback;
    private String loadbalance;
    private boolean sent;
    private int executes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkMethodName("name", name);
        this.name = name;
    }

    public String getArgsType() {
        return argsType;
    }

    public void setArgsType(String argsType) {
        checkMultiName("argsType", argsType);
        this.argsType = argsType;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        checkName("callback", callback);
        this.callback = callback;
    }

    public String getLoadbalance() {
        return loadbalance;
    }

    public void setLoadbalance(String loadbalance) {
        checkName("loadbalance", loadbalance);
        this.loadbalance = loadbalance;
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
