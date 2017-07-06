package com.microservice.thunder.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.microservice.thunder.bean.ApplicationBean;
import com.microservice.thunder.exception.ThunderException;
import com.microservice.thunder.util.NetUtil;
import com.microservice.thunder.util.StringUtil;

public class ApplicationBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Class<?> getBeanClass(Element element) {
        return ApplicationBean.class;
    }

    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        builder.setScope(ConfigurableBeanFactory.SCOPE_SINGLETON);

        String appName = element.getAttribute("appName");
        if (StringUtil.isEmpty(appName)) {
            throw new ThunderException("<thunder:application> attribute 'appName' is needed");
        }
        builder.addPropertyValue("appName", appName);

        String group = element.getAttribute("group");
        if (StringUtil.isEmpty(group)) {
            throw new ThunderException("<thunder:application> attribute 'group' is needed");
        }
        builder.addPropertyValue("group", group);

        String monitor = element.getAttribute("monitor");
        if (StringUtil.isEmpty(monitor)) {
            monitor = System.getProperty("ThunderMonitor");
            if (StringUtil.isEmpty(monitor)) {
                monitor = String.valueOf(false);
            }
        }
        builder.addPropertyValue("monitor", Boolean.valueOf(monitor));

        String port = element.getAttribute("port");
        if (StringUtil.isEmpty(port)) {
            port = System.getProperty("ThunderPort");
            if (StringUtil.isEmpty(port)) {
                port = String.valueOf(2080);
                log.info("Use the default port,{}", port);
            }
        }
        builder.addPropertyValue("port", Integer.valueOf(port));

        String host = element.getAttribute("host");
        if (StringUtil.isEmpty(host)) {
            host = System.getProperty("ThunderHost");
            if (StringUtil.isEmpty(host)) {
                host = NetUtil.getHostAddr();
            }
        }
        builder.addPropertyValue("host", host);

        String max_message_size = element.getAttribute("max_message_size");
        if (StringUtil.isEmpty(max_message_size)) {
            max_message_size = String.valueOf(1048576);
        }
        builder.addPropertyValue("max_message_size", Integer.valueOf(max_message_size));

        String send_buffer_size = element.getAttribute("send_buffer_size");
        if (StringUtil.isEmpty(send_buffer_size)) {
            send_buffer_size = String.valueOf(65536);
        }
        builder.addPropertyValue("send_buffer_size", Integer.valueOf(send_buffer_size));

        String recived_buffer_size = element.getAttribute("recived_buffer_size");
        if (StringUtil.isEmpty(recived_buffer_size)) {
            recived_buffer_size = String.valueOf(65536);
        }
        builder.addPropertyValue("recived_buffer_size", Integer.valueOf(recived_buffer_size));

        String connect_timeout_millis = element.getAttribute("connect_timeout_millis");
        if (StringUtil.isEmpty(connect_timeout_millis)) {
            connect_timeout_millis = String.valueOf(3000);
        }
        builder.addPropertyValue("connect_timeout_millis", Integer.valueOf(connect_timeout_millis));

        String write_timeout = element.getAttribute("write_timeout");
        if (StringUtil.isEmpty(write_timeout)) {
            write_timeout = String.valueOf(5000);
        }
        builder.addPropertyValue("write_timeout", Integer.valueOf(write_timeout));

        String read_timeout = element.getAttribute("read_timeout");
        if (StringUtil.isEmpty(read_timeout)) {
            read_timeout = String.valueOf(5000);
        }
        builder.addPropertyValue("read_timeout", Integer.valueOf(read_timeout));

        String so_backlog = element.getAttribute("so_backlog");
        if (StringUtil.isEmpty(so_backlog)) {
            so_backlog = String.valueOf(128);
        }
        builder.addPropertyValue("so_backlog", Integer.valueOf(so_backlog));

        String write_idle_time = element.getAttribute("write_idle_time");
        if (StringUtil.isEmpty(write_idle_time)) {
            write_idle_time = String.valueOf(120000);
        }
        builder.addPropertyValue("write_idle_time", Integer.valueOf(write_idle_time));

        String read_idle_time = element.getAttribute("read_idle_time");
        if (StringUtil.isEmpty(read_idle_time)) {
            read_idle_time = String.valueOf(90000);
        }
        builder.addPropertyValue("read_idle_time", Integer.valueOf(read_idle_time));

        String all_idle_time = element.getAttribute("all_idle_time");
        if (StringUtil.isEmpty(all_idle_time)) {
            all_idle_time = String.valueOf(60000);
        }
        builder.addPropertyValue("all_idle_time", Integer.valueOf(all_idle_time));

        String reconnect_attempt_delay = element.getAttribute("reconnect_attempt_delay");
        if (StringUtil.isEmpty(reconnect_attempt_delay)) {
            reconnect_attempt_delay = String.valueOf(3000);
        }
        builder.addPropertyValue("reconnect_attempt_delay", Integer.valueOf(reconnect_attempt_delay));

    }
}
