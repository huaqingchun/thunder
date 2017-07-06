package com.microservice.thunder.config;

public class RegistryConfig extends AbstractConfig {

    private static final long serialVersionUID = -8448246284801781686L;

    private String address;

    private int zookeeper_session_timeout;

    private int zookeeper_connect_timeout;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZookeeper_session_timeout() {
        return zookeeper_session_timeout;
    }

    public void setZookeeper_session_timeout(int zookeeper_session_timeout) {
        this.zookeeper_session_timeout = zookeeper_session_timeout;
    }

    public int getZookeeper_connect_timeout() {
        return zookeeper_connect_timeout;
    }

    public void setZookeeper_connect_timeout(int zookeeper_connect_timeout) {
        this.zookeeper_connect_timeout = zookeeper_connect_timeout;
    }

}
