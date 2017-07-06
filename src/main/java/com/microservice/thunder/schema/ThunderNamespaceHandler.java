package com.microservice.thunder.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.microservice.thunder.parser.ApplicationBeanDefinitionParser;
import com.microservice.thunder.parser.MethodBeanDefinitionParser;
import com.microservice.thunder.parser.MonitorBeanDefinitionParser;
import com.microservice.thunder.parser.ProviderBeanDefinitionParser;
import com.microservice.thunder.parser.ReferenceBeanDefinitionParser;
import com.microservice.thunder.parser.RegistryBeanDefinitionParser;
import com.microservice.thunder.parser.ServiceBeanDefinitionParser;

public class ThunderNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("application", new ApplicationBeanDefinitionParser());
        registerBeanDefinitionParser("registry", new RegistryBeanDefinitionParser());
        registerBeanDefinitionParser("service", new ServiceBeanDefinitionParser());
        registerBeanDefinitionParser("reference", new ReferenceBeanDefinitionParser());
        registerBeanDefinitionParser("method", new MethodBeanDefinitionParser());
        registerBeanDefinitionParser("provider", new ProviderBeanDefinitionParser());
        registerBeanDefinitionParser("monitor", new MonitorBeanDefinitionParser());
    }

}
