package com.ruoyi.project.network.handler;

import com.ruoyi.project.network.model.WindowProtocol;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 上位机发送读取运行状态信息后控制器返回信息的处理类
 */
@Slf4j
@Component
public class WindowReadRunningDataHandler implements IDataHandler {

    @Autowired
    private WindowCmdHandler windowCmdHandler;

    @Override
    public void handle(WindowProtocol data, ChannelHandlerContext ctx) {
        //数据处理

        //回复数据
        windowCmdHandler.handle(data, ctx, "00");
    }
}
