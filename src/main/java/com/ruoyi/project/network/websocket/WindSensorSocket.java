package com.ruoyi.project.network.websocket;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 将风速传感器读数socket放到静态变量缓存中，进行一次连接避免重复连接
 * @author wujiyang
 */
public class WindSensorSocket {

    /**
     * 存放风速传感器读数的socket客户端，其中key的组成为 ip-port-code
     */
    public static Map<String, Socket> windSensorSockets = new HashMap<>();

}
