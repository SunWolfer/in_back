package com.ruoyi.project.network.model;

public class SensorAddress {

    private byte[] header = new byte[3];

    private byte[] deviceAddress = new byte[2];

    public byte[] getHeader() {
        return header;
    }

    public void setHeader(byte[] header) {
        this.header = header;
    }

    public byte[] getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(byte[] deviceAddress) {
        this.deviceAddress = deviceAddress;
    }
}
