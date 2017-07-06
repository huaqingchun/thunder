package com.microservice.thunder.bean;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.PriorityOrdered;

import com.microservice.thunder.config.RegistryConfig;

public class RegistryBean extends RegistryConfig
        implements ApplicationContextAware, InitializingBean, DisposableBean, PriorityOrdered {

    private static final long serialVersionUID = -3291807238234051854L;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private ApplicationContext ctx;
    private CuratorFramework zkclient;

    @Override
    public void afterPropertiesSet() throws Exception {
        zkclient = CuratorFrameworkFactory.builder().connectString(getAddress())
                .sessionTimeoutMs(getZookeeper_connect_timeout()).connectionTimeoutMs(getZookeeper_connect_timeout())
                .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 3)).build();
        zkclient.start();
        log.info("Connect to zookeeper successful,address={}", getAddress());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                zkclient.close();
            }
        });
    }

    @Override
    public void destroy() throws Exception {
        zkclient.close();
        log.info("close zookeeper client successful,address={}", getAddress());
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

}
