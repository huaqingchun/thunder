package com.microservice.thunder.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import com.microservice.thunder.bean.ProviderBean;
import com.microservice.thunder.exception.ThunderException;
import com.microservice.thunder.util.StringUtil;

public class ProviderBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final String THREAD_POOL_FIXED = "fixed";
    private static final String THREAD_POOL_CACHED = "cached";
    private static final int POOL_SIZE = 200;
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAXIMUM_POOL_SIZE = 200;
    private static final int QUEUES = 100;

    protected Class<?> getBeanClass(Element element) {
        return ProviderBean.class;
    }

    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        builder.setScope(ConfigurableBeanFactory.SCOPE_PROTOTYPE);

        String threadpool = element.getAttribute("threadpool");
        if (StringUtil.isEmpty(threadpool)) {
            threadpool = THREAD_POOL_FIXED;
        } else {
            if (!THREAD_POOL_FIXED.equals(threadpool) && !THREAD_POOL_CACHED.equals(threadpool)) {
                throw new ThunderException("<thunder:provider> attribute 'threadpool' must be fixed or cached");
            }
        }
        builder.addPropertyValue("threadpool", threadpool);

        if (THREAD_POOL_FIXED.equals(threadpool)) {
            String poolsize = element.getAttribute("poolsize");
            if (StringUtil.isEmpty(poolsize)) {
                poolsize = String.valueOf(POOL_SIZE);
            }
            builder.addPropertyValue("poolsize", Integer.valueOf(poolsize));
        } else {
            String corepoolsize = element.getAttribute("corepoolsize");
            if (StringUtil.isEmpty(corepoolsize)) {
                corepoolsize = String.valueOf(CORE_POOL_SIZE);
            }
            builder.addPropertyValue("corepoolsize", Integer.valueOf(corepoolsize));

            String maximumpoolsize = element.getAttribute("maximumpoolsize");
            if (StringUtil.isEmpty(maximumpoolsize)) {
                maximumpoolsize = String.valueOf(MAXIMUM_POOL_SIZE);
            }
            builder.addPropertyValue("maximumpoolsize", Integer.valueOf(maximumpoolsize));
        }

        String queues = element.getAttribute("queues");
        if (StringUtil.isEmpty(queues)) {
            queues = String.valueOf(QUEUES);
        }
        builder.addPropertyValue("queues", Integer.valueOf(queues));

        String idDefault = element.getAttribute("default");
        if (StringUtil.isEmpty(idDefault)) {
            idDefault = String.valueOf(true);
        }
        builder.addPropertyValue("idDefault", Integer.valueOf(idDefault));

    }
}
