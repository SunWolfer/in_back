package com.ruoyi.project.network.net.handler;

import com.ruoyi.project.network.model.WindowProtocol;
import com.ruoyi.project.network.util.ConvertCode;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EncodeHandler extends MessageToByteEncoder<WindowProtocol> {


    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, WindowProtocol windowProtocol, ByteBuf out) throws Exception {
        out.writeBytes(ConvertCode.intToBytes(windowProtocol.getHeadData(),1));
        out.writeBytes(windowProtocol.getSn());
        out.writeBytes(ConvertCode.intToBytes(windowProtocol.getMiddleData(),1));
        out.writeBytes(windowProtocol.getOrder());
        out.writeBytes(windowProtocol.getLen());
        out.writeBytes(windowProtocol.getRes());
        byte[] content = windowProtocol.getContent();
        if(content!=null && content.length>0){
            out.writeBytes(content);
        }
        out.writeBytes(windowProtocol.getCrc());
        out.writeBytes(ConvertCode.intToBytes(windowProtocol.getTailData(),1));
    }
}




