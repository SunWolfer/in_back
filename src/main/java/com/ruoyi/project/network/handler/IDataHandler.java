package com.ruoyi.project.network.handler;

import com.ruoyi.project.network.model.WindowProtocol;
import com.ruoyi.project.network.util.DataFormatUtil;
import com.ruoyi.project.network.util.XorUtil;
import io.netty.channel.ChannelHandlerContext;

/**
 * 获取数据处理接口
 */
public interface IDataHandler {

    /**
     * 校验数据合法性
     * @param data
     * @return
     */
    default boolean checkData(WindowProtocol data){
        try {
            byte[] checkData;
            byte[] res = data.getRes();
            boolean haveContent = data.getHaveContent();
            if(haveContent){
                byte[] content = data.getContent();
                checkData = DataFormatUtil.mergeByteArray(res, content);
            } else {
                checkData = res;
            }
            byte[] checkBit = data.getCrc();

            byte[] checkBytes = XorUtil.getCRC(checkData);
            String checkDataCheck = DataFormatUtil.bytesToHex(checkBytes);
            String checkBitStr = DataFormatUtil.bytesToHex(checkBit);
            if (checkDataCheck.equalsIgnoreCase(checkBitStr)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 处理接收的数据
     * @param data
     */
    void handle(WindowProtocol data, ChannelHandlerContext ctx);
}
