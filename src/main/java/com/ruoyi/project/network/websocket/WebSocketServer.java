package com.ruoyi.project.network.websocket;

import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/WebSocketServer/{clientId}")
@Component
public class WebSocketServer {

    private Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<WebSocketServer,String> webSocketMapReverse = new ConcurrentHashMap<>();
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    // 客户端id
    private String clientId = "";

    // * 连接建立成功调用的方法*
    @OnOpen
    public void onOpen(Session session, @PathParam("clientId") String clientId) {
        this.session = session;
        webSocketMap.put(clientId, this); // 加入map中
        webSocketMapReverse.put(this, clientId);
        addOnlineCount(); // 在线数加1
        logger.info("有新窗口开始监听:" + clientId + ",当前在线人数为" + getOnlineCount());
        this.clientId = clientId;
        /*try {
            sendMessage("连接成功");
        } catch (IOException e) {
            logger.error("websocket IO异常");
        }*/
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        String clientId = webSocketMapReverse.get(this);
        if(StringUtils.isNotBlank(clientId)){
            webSocketMap.remove(clientId); //删除
            webSocketMapReverse.remove(this);
        }
        subOnlineCount(); // 在线数减1
        logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("收到来自窗口" + clientId + "的信息:" + message);

    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        logger.info("服务器消息推送："+message);
        this.session.getBasicRemote().sendText(message);
    }


    public static void sendMessageToClient(String clientKey, String message){
        ConcurrentHashMap<String, WebSocketServer> webSocketMap = WebSocketServer.getWebSocketMap();
        for (String key : webSocketMap.keySet()) {
            if (StringUtils.isNotBlank(key)) {
                if (key.indexOf(clientKey) != -1) {
                    WebSocketServer webSocketServer = webSocketMap.get(key);
                    if (webSocketServer != null) {
                        try {
                            webSocketServer.sendMessage(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public static ConcurrentHashMap<String, WebSocketServer> getWebSocketMap() {
        return webSocketMap;
    }

    public static ConcurrentHashMap<WebSocketServer, String> getWebSocketMapReverse() {
        return webSocketMapReverse;
    }
}
