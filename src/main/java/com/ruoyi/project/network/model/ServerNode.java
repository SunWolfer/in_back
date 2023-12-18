package com.ruoyi.project.network.model;

import java.nio.charset.Charset;

/**
 * server节点
 */
public class ServerNode {

    private String id;
    private String host;
    private Integer port;
    private DataType readType;
    private DataType writeType;
    private Charset charset;
    private String dataTypeHandler;


    public ServerNode() {
        this.readType = DataType.HEX;
        this.writeType = DataType.HEX;
        this.charset =  Charset.forName("UTF-8");
    }

    public ServerNode(String host, Integer port) {
        this.host = host;
        this.port = port;
        this.readType = DataType.HEX;
        this.writeType = DataType.HEX;
        this.charset =  Charset.forName("UTF-8");
    }

    public ServerNode(String id, String host, Integer port) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.readType = DataType.HEX;
        this.writeType = DataType.HEX;
        this.charset =  Charset.forName("UTF-8");
    }

    public ServerNode(String id, String host, Integer port, DataType readType, DataType writeType) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.readType = readType;
        this.writeType = writeType;
        this.charset = Charset.forName("UTF-8");
    }

    public ServerNode(String id, String host, Integer port, DataType readType, DataType writeType, Charset charset) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.readType = readType;
        this.writeType = writeType;
        this.charset = charset;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public DataType getReadType() {
        return readType;
    }

    public void setReadType(DataType readType) {
        this.readType = readType;
    }

    public DataType getWriteType() {
        return writeType;
    }

    public void setWriteType(DataType writeType) {
        this.writeType = writeType;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public String getDataTypeHandler() {
        return dataTypeHandler;
    }

    public void setDataTypeHandler(String dataTypeHandler) {
        this.dataTypeHandler = dataTypeHandler;
    }
}
