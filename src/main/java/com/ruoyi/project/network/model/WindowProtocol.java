package com.ruoyi.project.network.model;

import com.ruoyi.project.network.util.ConvertCode;
import com.ruoyi.project.network.util.DataFormatUtil;
import lombok.Data;


@Data
public class WindowProtocol {

    /**
     * 消息的开头的信息标志
     */
    private int headData = ProtocolConstant.HEAD_DATA;

    /**
     * 地址编号
     */
    private byte[] sn;

    /**
     * 消息中间的标志
     */
    private int middleData = ProtocolConstant.MIDDLE_DATA;

    /**
     * 命令码
     */
    private byte[] order;

    /**
     * 消息内容的长度
     */
    private byte[] len;


    private byte[] res;

    private byte[] content;

    /**
     * 校验码
     */
    private byte[] crc;

    /**
     * 消息的结尾的信息标志
     */
    private int tailData = ProtocolConstant.TAIL_DATA;


    private boolean haveContent = false;


    public boolean getHaveContent() {
        return haveContent;
    }

    public void setHaveContent(boolean haveContent) {
        this.haveContent = haveContent;
    }

    @Override
    public String toString() {
        String s =  ConvertCode.intToHexString(headData,1) + " " +
                DataFormatUtil.bytesToHex(sn) + " " +
                ConvertCode.intToHexString(middleData,1) + " " +
                DataFormatUtil.bytesToHex(order) + " " +
                DataFormatUtil.bytesToHex(len) + " " +
                DataFormatUtil.bytesToHex(res) + " " +
                DataFormatUtil.bytesToHex(content) + " " +
                DataFormatUtil.bytesToHex(crc) + " " +
                ConvertCode.intToHexString(tailData,1);
        return s.toUpperCase();
    }
}
