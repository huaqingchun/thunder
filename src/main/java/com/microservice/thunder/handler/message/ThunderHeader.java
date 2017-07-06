package com.microservice.thunder.handler.message;

import java.io.Serializable;

public class ThunderHeader implements Serializable {

    private static final long serialVersionUID = 6484308786120344845L;

    private boolean async;
    private boolean heartbeat;
    private String messageId;
    private long timestamp;

    public boolean isAsync() {
        return async;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }

    public boolean isHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(boolean heartbeat) {
        this.heartbeat = heartbeat;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
