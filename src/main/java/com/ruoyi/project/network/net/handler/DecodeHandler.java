package com.ruoyi.project.network.net.handler;

import com.ruoyi.project.network.model.ProtocolConstant;
import com.ruoyi.project.network.model.WindowProtocol;
import com.ruoyi.project.network.util.DataFormatUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DecodeHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
//        System.out.println("index=======================>"+byteBuf.writerIndex());
//        list.add(byteBuf.readBytes(byteBuf.readableBytes()));
        //bytebuf gc出错怎么解决
        try {
            log.info("收到报文粘包半包解析");

            if(byteBuf == null){
                log.info("收到的报文为空");
                return;
            }
            //判断是否满足字节最小数目
            if(byteBuf.readableBytes() < ProtocolConstant.FRAME_SIZE_MIN){
                log.info("报文不够最小数目");
                return;
            }

            //防止socket字节流攻击
            if(byteBuf.readableBytes() > 2048){
                log.info("报文长度超长异常");
                byteBuf.skipBytes(byteBuf.readableBytes());
                return;
            }

            //记录包头开始的index
            int beginReader;
            //记录报文data长度
            int dataLength;
            while (true) {
                // 获取包头开始的index
                beginReader = byteBuf.readerIndex();
                // 标记包头开始的index
                byteBuf.markReaderIndex();
                // 读到了协议的开始标志，结束while循环
                if (byteBuf.readByte() == ProtocolConstant.HEAD_DATA) {//起始标志
                    //跳过地址编号
                    byteBuf.readBytes(6);
                    //读取中间标志
                    if (byteBuf.readByte() == ProtocolConstant.MIDDLE_DATA) {//起始中间标志
                        //跳过命令码
                        byteBuf.readBytes(1);
                        //读取len
                        byte[] lengthBytes1 = new byte[2];
                        lengthBytes1[0] = byteBuf.readByte();
                        lengthBytes1[1] = byteBuf.readByte();

                        String lengthHex1 = DataFormatUtil.bytesToHex(lengthBytes1);
                        //高低位转换 转10进制
                        String lengthStr1 = DataFormatUtil.formatUnsignedHex(lengthHex1);
                        int length1 = Integer.parseInt(lengthStr1);

                        if(byteBuf.readableBytes() < length1 + 3){//报文不够最小数目
                            log.info("报文不够最小数目3");
                            byteBuf.resetReaderIndex();
                            return;
                        }

                        byteBuf.readBytes(length1);//跳过数据区
                        byteBuf.readBytes(2);//跳过校验码
                        if(byteBuf.readByte() == ProtocolConstant.TAIL_DATA){//结尾标志
                            byteBuf.resetReaderIndex();//还原到包头位置
                            dataLength = 1 + 6 + 1 + 1 + 2 + length1 + 2 + 1;
                            //校验满足完整报文 跳出循环
                            break;
                        }
                    }
                }

                // 未读到包头，略过一个字节
                // 每次略过，一个字节，去读取，包头信息的开始标记
                byteBuf.resetReaderIndex();
                byteBuf.readByte();

                // 当略过，一个字节之后，
                // 数据包的长度，又变得不满足
                // 此时，应该结束。等待后面的数据到达
                if (byteBuf.readableBytes() < ProtocolConstant.FRAME_SIZE_MIN) {
                    log.info("剩余字节数小于帧最小满足数1");
                    return;
                }
            }

            log.info("报文粘包半包处理完毕");
            WindowProtocol windowProtocol = new WindowProtocol();
            byteBuf.readByte();
            //读取消息长度 两字节
            byte[] snBytes = new byte[6];
            byteBuf.readBytes(snBytes);
            windowProtocol.setSn(snBytes);

            byteBuf.readByte();

            byte[] orderBytes = new byte[1];
            byteBuf.readBytes(orderBytes);
            windowProtocol.setOrder(orderBytes);

            byte[] lenBytes = new byte[2];
            lenBytes[0] = byteBuf.readByte();
            lenBytes[1] = byteBuf.readByte();
            windowProtocol.setLen(lenBytes);

            String lengthHex1 = DataFormatUtil.bytesToHex(lenBytes);
            //高低位转换 转10进制
            String lengthStr1 = DataFormatUtil.formatUnsignedHex(lengthHex1);
            int len = Integer.parseInt(lengthStr1);

            byte[] resBytes = new byte[2];
            byteBuf.readBytes(resBytes);
            windowProtocol.setRes(resBytes);

            windowProtocol.setHaveContent(false);

            if(len > 2){
                byte[] dataBytes = new byte[len-2];
                byteBuf.readBytes(dataBytes);
                windowProtocol.setContent(dataBytes);
                windowProtocol.setHaveContent(true);
            }

            byte[] crcBytes = new byte[2];
            byteBuf.readBytes(crcBytes);
            windowProtocol.setCrc(crcBytes);

            byteBuf.readByte();

            list.add(windowProtocol);
//            list.add(byteBuf.readBytes(dataLength));

//            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




