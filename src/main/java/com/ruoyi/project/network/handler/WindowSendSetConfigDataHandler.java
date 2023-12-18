package com.ruoyi.project.network.handler;

import com.ruoyi.project.network.model.WindowProtocol;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 上位机下发配置信息后控制器返回结果的处理类
 */
@Slf4j
@Component
public class WindowSendSetConfigDataHandler implements IDataHandler {

    @Override
    public void handle(WindowProtocol data, ChannelHandlerContext ctx) {
        log.info("上位机下发配置指令返回报文" + data.toString());
    }
}
