package com.microservice.thunder.config;

public class ProviderConfig extends AbstractConfig {

    private static final long serialVersionUID = -1287759388716814400L;

    private String threadpool;

    private int poolsize;

    private int corepoolsize;

    private int maximumpoolsize;

    private int queues;

    private boolean isDefault;

    private ApplicationConfig applicationConfig;

    private RegistryConfig registryConfig;

    public String getThreadpool() {
        return threadpool;
    }

    public void setThreadpool(String threadpool) {
        this.threadpool = threadpool;
    }

    public int getPoolsize() {
        return poolsize;
    }

    public void setPoolsize(int poolsize) {
        this.poolsize = poolsize;
    }

    public int getCorepoolsize() {
        return corepoolsize;
    }

    public void setCorepoolsize(int corepoolsize) {
        this.corepoolsize = corepoolsize;
    }

    public int getMaximumpoolsize() {
        return maximumpoolsize;
    }

    public void setMaximumpoolsize(int maximumpoolsize) {
        this.maximumpoolsize = maximumpoolsize;
    }

    public int getQueues() {
        return queues;
    }

    public void setQueues(int queues) {
        this.queues = queues;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public ApplicationConfig getApplicationConfig() {
        return applicationConfig;
    }

    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public RegistryConfig getRegistryConfig() {
        return registryConfig;
    }

    public void setRegistryConfig(RegistryConfig registryConfig) {
        this.registryConfig = registryConfig;
    }
}
