package com.microservice.thunder.bean;

import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.PriorityOrdered;

import com.microservice.thunder.config.ProviderConfig;
import com.microservice.thunder.config.ServiceConfig;
import com.microservice.thunder.exception.ThunderException;

public class ServiceBean extends ServiceConfig implements InitializingBean, DisposableBean, ApplicationContextAware,
        PriorityOrdered, ApplicationListener<ApplicationEvent> {

    private static final long serialVersionUID = 8510087907809356051L;

    private ApplicationContext ctx;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StringBuilder sb = new StringBuilder(THUNDER_PATH_PREFIX).append(THUNDER_PATH_SEPARATOR)
                .append(getInterfaceName()).append(THUNDER_PATH_SEPARATOR).append("providers");
        setPath(sb.toString());

        try {
            setInterfaceClass(Class.forName(getInterfaceName()));
        } catch (ClassNotFoundException e) {
            throw new ThunderException("can not load class: " + getInterfaceName());
        }
        if (getProvider() == null) {
            Map<String, ProviderBean> providers = ctx.getBeansOfType(ProviderBean.class);
            for (ProviderBean providerBean : providers.values()) {
                if (providerBean.isDefault()) {
                    setProvider(providerBean);
                    break;
                }
            }
        }
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
