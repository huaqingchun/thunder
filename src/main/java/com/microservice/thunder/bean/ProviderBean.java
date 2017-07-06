package com.microservice.thunder.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.PriorityOrdered;
import com.microservice.thunder.config.ProviderConfig;

public class ProviderBean extends ProviderConfig
        implements ApplicationContextAware, InitializingBean, DisposableBean, PriorityOrdered {

    private static final long serialVersionUID = 2650015862784727161L;

    private ApplicationContext ctx;

    @Override
    public void afterPropertiesSet() throws Exception {
        setApplicationConfig(ctx.getBean(ApplicationBean.class));
        setRegistryConfig(ctx.getBean(RegistryBean.class));
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public int getOrder() {
        return -1;
    }

}
