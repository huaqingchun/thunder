package com.microservice.thunder.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microservice.thunder.parser.ApplicationBeanDefinitionParser;

import io.netty.util.internal.SocketUtils;

public class NetUtil {
    private static final Logger log = LoggerFactory.getLogger(ApplicationBeanDefinitionParser.class);

    private static String hostAddr = "127.0.0.1";

    static {
        try {
            loop: for (Enumeration<NetworkInterface> i = NetworkInterface.getNetworkInterfaces(); i
                    .hasMoreElements();) {
                NetworkInterface iface = i.nextElement();
                for (Enumeration<InetAddress> iterator = SocketUtils.addressesFromNetworkInterface(iface); iterator
                        .hasMoreElements();) {
                    InetAddress addr = iterator.nextElement();
                    if ((!addr.isLoopbackAddress()) && (addr.isSiteLocalAddress())
                            && (addr.getHostAddress().indexOf(":") == -1)) {
                        hostAddr = addr.getHostAddress();
                        break loop;
                    }
                }
            }
        } catch (SocketException e) {
            log.warn("Failed to retrieve the list of available network interface", e);
        }
    }

    public static String getHostAddr() {
        return hostAddr;
    }
}
