package com.ruoyi.project.network.handler;

import com.ruoyi.project.network.model.WindowProtocol;
import com.ruoyi.project.network.util.DataFormatUtil;
import com.ruoyi.project.network.util.XorUtil;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WindowCmdHandler {
    //回复命令码处理类
    public void handle(WindowProtocol data, ChannelHandlerContext ctx, String receiveCmdHex) {
        log.info("回复命令码处理类");
        WindowProtocol responseData = new WindowProtocol();
        responseData.setHeadData(data.getHeadData());
        responseData.setSn(data.getSn());
        responseData.setMiddleData(data.getMiddleData());
        responseData.setOrder(data.getOrder());
        byte[] lenBytes = DataFormatUtil.hexToBytes("03 00");
        responseData.setLen(lenBytes);
        byte[] resBytes = DataFormatUtil.hexToBytes("00 00");
        responseData.setRes(resBytes);
        byte[] contentBytes = DataFormatUtil.hexToBytes(receiveCmdHex);
        responseData.setContent(contentBytes);
        byte[] checkDataBytes = DataFormatUtil.mergeByteArray(resBytes, contentBytes);
        byte[] crcLowHigh = XorUtil.getCRC(checkDataBytes);
        responseData.setCrc(crcLowHigh);
        responseData.setTailData(data.getTailData());
        ctx.channel().writeAndFlush(responseData);
        log.info("回复命令码:" + responseData.toString());
    }
}
