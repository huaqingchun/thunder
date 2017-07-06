package com.microservice.thunder.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.microservice.thunder.bean.ServiceBean;
import com.microservice.thunder.exception.ThunderException;
import com.microservice.thunder.util.StringUtil;

public class ServiceBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final int TIMEOUT_DEFAULT = 15000;
    private static final int WEIGHT_DEFAULT = 10;
    private static final String PROXY_DEFAULT = "jdk";
    private static final int EXECUTES_DEFAULT = -1;
    private static final int DELAY_DEFAULT = -1;

    protected Class<?> getBeanClass(Element element) {
        return ServiceBean.class;
    }

    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        builder.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);

        String interfaceName = element.getAttribute("interface");
        if (StringUtil.isEmpty(interfaceName)) {
            throw new ThunderException("<thunder:service> attribute 'interface' is needed");
        }
        builder.addPropertyValue("interfaceName", interfaceName);

        String ref = element.getAttribute("ref");
        if (StringUtil.isEmpty(ref)) {
            throw new ThunderException("<thunder:service> attribute 'ref' is needed");
        }
        builder.addPropertyValue("ref", new RuntimeBeanReference(ref));

        String timeout = element.getAttribute("timeout");
        if (StringUtil.isEmpty(timeout)) {
            timeout = String.valueOf(TIMEOUT_DEFAULT);
        }
        builder.addPropertyValue("timeout", Integer.valueOf(timeout));

        String version = element.getAttribute("version");
        if (!StringUtil.isEmpty(version)) {
            builder.addPropertyValue("version", version);
        }

        String weight = element.getAttribute("weight");
        if (StringUtil.isEmpty(version)) {
            weight = String.valueOf(WEIGHT_DEFAULT);
        }
        builder.addPropertyValue("weight", Integer.valueOf(weight));

        String proxy = element.getAttribute("proxy");
        if (StringUtil.isEmpty(proxy)) {
            proxy = String.valueOf(PROXY_DEFAULT);
        }
        builder.addPropertyValue("proxy", Integer.valueOf(proxy));

        String executes = element.getAttribute("executes");
        if (StringUtil.isEmpty(executes)) {
            executes = String.valueOf(EXECUTES_DEFAULT);
        }
        builder.addPropertyValue("executes", Integer.valueOf(executes));

        String delay = element.getAttribute("delay");
        if (StringUtil.isEmpty(delay)) {
            delay = String.valueOf(DELAY_DEFAULT);
        }
        builder.addPropertyValue("delay", Integer.valueOf(delay));

        String provider = element.getAttribute("provider");
        if (!StringUtil.isEmpty(provider)) {
            builder.addPropertyValue("provider", new RuntimeBeanReference(provider));
        }

    }
}
