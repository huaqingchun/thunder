package com.microservice.thunder.config;

import java.util.List;

public class ServiceConfig extends AbstractConfig {

    private static final long serialVersionUID = -6950166364008599723L;

    // 接口类型
    private String interfaceName;

    private Class<?> interfaceClass;

    // 接口实现类引用
    private Object ref;

    // 方法配置
    private List<MethodConfig> methods;

    // 服务名称
    private String path;

    private ProviderConfig provider;

    private int timeout;

    private String version;

    private int weight;

    private String proxy;

    private int executes;

    private int delay;

    public Object getRef() {
        return ref;
    }

    public void setRef(Object ref) {
        this.ref = ref;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        checkName("proxy", proxy);
        this.proxy = proxy;
    }

    public int getExecutes() {
        return executes;
    }

    public void setExecutes(int executes) {
        this.executes = executes;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        checkName("interfaceName", interfaceName);
        this.interfaceName = interfaceName;
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public List<MethodConfig> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodConfig> methods) {
        this.methods = methods;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        checkPathName("path", path);
        this.path = path;
    }

    public ProviderConfig getProvider() {
        return provider;
    }

    public void setProvider(ProviderConfig provider) {
        this.provider = provider;
    }

}
