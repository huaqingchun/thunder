package com.microservice.thunder.config;

public class ApplicationConfig extends AbstractConfig {

    private static final long serialVersionUID = 4195695263942810426L;

    private String appName;
    private String host;
    private int port;
    private String group;
    private boolean monitor;
    private int max_message_size;
    private int send_buffer_size;
    private int recived_buffer_size;
    private int connect_timeout_millis;
    private int write_timeout;
    private int read_timeout;
    private int so_backlog;
    private int write_idle_time;
    private int read_idle_time;
    private int all_idle_time;
    private int reconnect_attempt_delay;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        checkName("appName", appName);
        this.appName = appName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        checkName("group", group);
        this.group = group;
    }

    public boolean isMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    public int getMax_message_size() {
        return max_message_size;
    }

    public void setMax_message_size(int max_message_size) {
        this.max_message_size = max_message_size;
    }

    public int getSend_buffer_size() {
        return send_buffer_size;
    }

    public void setSend_buffer_size(int send_buffer_size) {
        this.send_buffer_size = send_buffer_size;
    }

    public int getRecived_buffer_size() {
        return recived_buffer_size;
    }

    public void setRecived_buffer_size(int recived_buffer_size) {
        this.recived_buffer_size = recived_buffer_size;
    }

    public int getConnect_timeout_millis() {
        return connect_timeout_millis;
    }

    public void setConnect_timeout_millis(int connect_timeout_millis) {
        this.connect_timeout_millis = connect_timeout_millis;
    }

    public int getWrite_timeout() {
        return write_timeout;
    }

    public void setWrite_timeout(int write_timeout) {
        this.write_timeout = write_timeout;
    }

    public int getRead_timeout() {
        return read_timeout;
    }

    public void setRead_timeout(int read_timeout) {
        this.read_timeout = read_timeout;
    }

    public int getSo_backlog() {
        return so_backlog;
    }

    public void setSo_backlog(int so_backlog) {
        this.so_backlog = so_backlog;
    }

    public int getWrite_idle_time() {
        return write_idle_time;
    }

    public void setWrite_idle_time(int write_idle_time) {
        this.write_idle_time = write_idle_time;
    }

    public int getRead_idle_time() {
        return read_idle_time;
    }

    public void setRead_idle_time(int read_idle_time) {
        this.read_idle_time = read_idle_time;
    }

    public int getAll_idle_time() {
        return all_idle_time;
    }

    public void setAll_idle_time(int all_idle_time) {
        this.all_idle_time = all_idle_time;
    }

    public int getReconnect_attempt_delay() {
        return reconnect_attempt_delay;
    }

    public void setReconnect_attempt_delay(int reconnect_attempt_delay) {
        this.reconnect_attempt_delay = reconnect_attempt_delay;
    }

}
