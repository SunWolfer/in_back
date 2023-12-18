package com.ruoyi.project.network.handler;

import com.ruoyi.project.network.model.WindowProtocol;
import com.ruoyi.project.network.util.DataFormatUtil;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 上位机发送读取设备信息后控制器返回结果的处理类
 */
@Slf4j
@Component
public class WindowReadDeviceDataHandler implements IDataHandler {

    @Override
    public void handle(WindowProtocol data, ChannelHandlerContext ctx) {
        try {
            byte[] content = data.getContent();
            byte[] snBytes = data.getSn();

            if(content != null && content.length == 16){

                byte deviceType = content[0];//设备类型
                byte hardWareVersion = content[1];//硬件版本
                byte softWareVersion = content[2];//软件版本
                byte protocolVersion = content[3];//协议版本
                //业务处理  读取设备信息后的操作

            } else {
                String snStr = DataFormatUtil.bytesToHex(snBytes);
                log.error(snStr + "读取设备信息回复的报文有误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
