package com.ruoyi.project.network.controller;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.network.model.MsgVo;
import com.ruoyi.project.network.net.TcpManyClient;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetController {

    @Autowired
    private TcpManyClient tcpManyClient;

    /**
     * 发送信息到服务端
     * @param msgVo
     * @return
     * @throws Exception
     */
    @PostMapping("/sendMsg")
    public AjaxResult sendMsg(@RequestBody MsgVo msgVo) throws Exception {
        if(msgVo!=null){
            Channel channel = tcpManyClient.channels.get(msgVo.getId());
            if(channel!=null && channel.isActive()){
                tcpManyClient.sendMsg(channel, msgVo.getContent());
                return AjaxResult.success();
            } else {
                return AjaxResult.error();
            }
        } else {
            return AjaxResult.error();
        }
    }

    @PostMapping("/test")
    public AjaxResult test(@RequestBody String content){
        System.out.println("===============>" + content);
        return AjaxResult.success(content);
    }
}
