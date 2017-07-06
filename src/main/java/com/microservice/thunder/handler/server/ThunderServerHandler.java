package com.microservice.thunder.handler.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microservice.thunder.handler.message.ThunderRequest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ThunderServerHandler extends SimpleChannelInboundHandler<ThunderRequest> {
    private static final Logger log = LoggerFactory.getLogger(ThunderServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ThunderRequest msg) throws Exception {
        log.info(msg.getInterfaceName() + ":" + msg.getMethodName() + ":" + msg.getParameters());
    }

}
