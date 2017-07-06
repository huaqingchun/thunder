package com.microservice.thunder.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.microservice.thunder.bean.RegistryBean;
import com.microservice.thunder.util.StringUtil;

public class RegistryBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Class<?> getBeanClass(Element element) {
        return RegistryBean.class;
    }

    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        builder.setScope(ConfigurableBeanFactory.SCOPE_SINGLETON);

        String address = element.getAttribute("address");
        if (StringUtil.isEmpty(address)) {
            address = System.getProperty("ThunderRegisterAddress");
            if (StringUtil.isEmpty(address)) {
                address = "zk01.99bill.com:2181";
            }
        }
        builder.addPropertyValue("address", address);
        log.info("Use the zookeeper address,{}", address);

        String zookeeper_session_timeout = element.getAttribute("zookeeper_session_timeout");
        if (StringUtil.isEmpty(zookeeper_session_timeout)) {
            zookeeper_session_timeout = String.valueOf(60000);
        }
        builder.addPropertyValue("zookeeper_session_timeout", Integer.valueOf(zookeeper_session_timeout));

        String zookeeper_connect_timeout = element.getAttribute("zookeeper_connect_timeout");
        if (StringUtil.isEmpty(zookeeper_connect_timeout)) {
            zookeeper_connect_timeout = String.valueOf(15000);
        }
        builder.addPropertyValue("zookeeper_connect_timeout", Integer.valueOf(zookeeper_connect_timeout));
    }
}
