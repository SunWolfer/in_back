package com.ruoyi.project.network.util;

public class XorUtil {

    public static byte getXor(byte[] datas){
        byte temp=datas[0];

        for (int i = 1; i <datas.length; i++) {
            temp ^=datas[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        /*String a = "AA 55 7F";
        String b = "AA 55 7F";

        byte[] bytes = DataFormatUtil.hexToBytes(a);
        byte[] bytesb = DataFormatUtil.hexToBytes(b);
        byte xor = getXor(bytes);
        byte xor1 = getXor(bytesb);
        System.out.println(xor == xor1);*/
        /*String x = "00 02";
        String[] s = x.split(" ");

        Integer integer = Integer.valueOf(x.replace(" ",""), 16);
        System.out.println(integer);*/
//        String a = "AA 55 7F 00 01 5A 03 02 10 01 00 1B 02 00 02 00 05 00 00 00 02 00 02 00 00 00 01 00 00 00 34 3A 5C 01 14 00 00 00 01 12 7F AA ED";
//        String b = "00 01 5A 03 02 10 01 00 1B 02 00 02 00 05 00 00 00 02 00 02 00 00 00 01 00 00 00 34 3A 5C 01 14 00 00 00 01";
//
//        byte[] bytes = DataFormatUtil.hexToBytes(b);
///*
//        Integer i = DataFormatUtil.byteToHL(bytes, 0);*/
//        byte xor = getXor(bytes);
//        byte[] bb = {xor};
//
//        String s = DataFormatUtil.bytesToHex(bb);
//        System.out.println(s);
        /*String a = "07 d0 01 02 00 35 00 40 cc ff b7 fe 9a 03 d2 ff b5 fe 95 03 d3 ff af fe 98 03 d2 ff ad fe 96 03 cd ff b4 fe 94 03 cd ff af fe 95 03 d0 ff a7 fe 94 03 d7 ff b2 fe 93 03 ca ff be fe 9a 03 c7 ff bb fe 9c 03 cb ff b3 fe";// C7 37 7F AA ED
        byte[] s = DataFormatUtil.hexToBytes(a);
        byte[] crc = getCRC(s);
        String s1 = DataFormatUtil.bytesToHex(crc);
        System.out.println(s1);*/
        //aa 55 7f 07 d0 01 02 00 16 00 40 21 fe 53 03 d3 ff 11 fe 55 03 d6 ff 13 fe 50 03 d8 ff 15 fe 57 03 d7 ff 1a fe 67 03 dd ff 1d fe 64 03 dd ff 1e fe 63 03 d9 ff 1b fe 67 03 d9 ff 19 fe 5c 03 d5 ff 1f fe 57 03 da ff 1f fe 5e 03 f3 1f 7f aa ed======================================={"msg":"操作成功","code":200}

        byte[] sbuf = XorUtil.getSendBuf("07 d0 01 02 00 16 00 40 21 fe 53 03 d3 ff 11 fe 55 03 d6 ff 13 fe 50 03 d8 ff 15 fe 57 03 d7 ff 1a fe 67 03 dd ff 1d fe 64 03 dd ff 1e fe 63 03 d9 ff 1b fe 67 03 d9 ff 19 fe 5c 03 d5 ff 1f fe 57 03 da ff 1f fe 5e 03".replaceAll(" ",""));
        String ss = XorUtil.getBufHexStr(sbuf);//将字节转成字符串
        String substring = ss.substring(ss.length() - 4);
        StringBuffer sb = new StringBuffer(substring);
        sb.insert(2, " ");
        byte[] bytes = DataFormatUtil.hexToBytes(sb.toString());
        String s = DataFormatUtil.bytesToHex(bytes);
        System.out.println(ss);
        System.out.println(substring);
        System.out.println(sb.toString());
        System.out.println(s);
    }


    /**
     * 计算CRC16校验码
     *
     * @param
     * @return
     */
    /*public static byte[] getCRC(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        //高低位转换，看情况使用（譬如本人这次对led彩屏的通讯开发就规定校验码高位在前低位在后，也就不需要转换高低位)
        CRC = ( (CRC & 0x0000FF00) >> 8) | ( (CRC & 0x000000FF ) << 8);
        String crc = Integer.toHexString(CRC);
        return DataFormatUtil.hexToBytes(crc);
    }*/


    /*public static byte[] getCRC(byte[] data) {
        byte[] buf = new byte[data.length];// 存储需要产生校验码的数据
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];
        }
        int len = buf.length;
        int crc = 0xFFFF;
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                crc ^= (int) buf[pos] + 256; // XOR byte into least sig. byte of
                // crc
            } else {
                crc ^= (int) buf[pos]; // XOR byte into least sig. byte of crc
            }
            for (int i = 8; i != 0; i--) { // Loop over each bit
                if ((crc & 0x0001) != 0) { // If the LSB is set
                    crc >>= 1; // Shift right and XOR 0xA001
                    crc ^= 0xA001;
                } else
                    // Else LSB is not set
                    crc >>= 1; // Just shift right
            }
        }
        String c = Integer.toHexString(crc);
        if (c.length() == 4) {
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 3) {
            c = "0" + c;
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 2) {
            c = "0" + c.substring(1, 2) + "0" + c.substring(0, 1);
        }
        return DataFormatUtil.hexToBytes(c);
    }*/

    /**
     * 高位在前 低位在后
     * @param data
     * @return
     */
    public static byte[] getCRC(byte[] data) {
        String checkData = DataFormatUtil.bytesToHex(data);
        byte[] sbuf = XorUtil.getSendBuf(checkData.replaceAll(" ",""));
        String ss = XorUtil.getBufHexStr(sbuf);//将字节转成字符串
        String substring = ss.substring(ss.length() - 4);
        StringBuffer sb = new StringBuffer(substring);
        sb.insert(2, " ");
        byte[] bytes = DataFormatUtil.hexToBytes(sb.toString());
        return bytes;
    }


    /**
     * 高位在前 低位在后
     * @param data
     * @return
     */
    public static byte[] getCRCLowHigh(byte[] data) {
        String checkData = DataFormatUtil.bytesToHex(data);
        byte[] sbuf = XorUtil.getSendBuf(checkData.replaceAll(" ",""));
        String ss = XorUtil.getBufHexStr(sbuf);//将字节转成字符串
        String substring = ss.substring(ss.length() - 4);
        StringBuffer sb = new StringBuffer(substring);
        sb.insert(2, " ");
        String crcStr = DataFormatUtil.highLowHex(sb.toString());
        byte[] bytes = DataFormatUtil.hexToBytes(crcStr);
        return bytes;
    }


    static final String HEXES = "0123456789ABCDEF";
    byte uchCRCHi = (byte) 0xFF;
    byte uchCRCLo = (byte) 0xFF;
    private static byte[] auchCRCHi = { 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0,
            (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01,
            (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1,
            (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01,
            (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0,
            (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0,
            (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1,
            (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80,
            (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01,
            (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1,
            (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1,
            (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80,
            (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x01,
            (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1,
            (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0,
            (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0,
            (byte) 0x80, (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80,
            (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00, (byte) 0xC1,
            (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80,
            (byte) 0x41, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x00, (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40, (byte) 0x01, (byte) 0xC0,
            (byte) 0x80, (byte) 0x41, (byte) 0x00, (byte) 0xC1, (byte) 0x81,
            (byte) 0x40, (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41,
            (byte) 0x01, (byte) 0xC0, (byte) 0x80, (byte) 0x41, (byte) 0x00,
            (byte) 0xC1, (byte) 0x81, (byte) 0x40 };

    private static byte[] auchCRCLo = { (byte) 0x00, (byte) 0xC0, (byte) 0xC1,
            (byte) 0x01, (byte) 0xC3, (byte) 0x03, (byte) 0x02, (byte) 0xC2,
            (byte) 0xC6, (byte) 0x06, (byte) 0x07, (byte) 0xC7, (byte) 0x05,
            (byte) 0xC5, (byte) 0xC4, (byte) 0x04, (byte) 0xCC, (byte) 0x0C,
            (byte) 0x0D, (byte) 0xCD, (byte) 0x0F, (byte) 0xCF, (byte) 0xCE,
            (byte) 0x0E, (byte) 0x0A, (byte) 0xCA, (byte) 0xCB, (byte) 0x0B,
            (byte) 0xC9, (byte) 0x09, (byte) 0x08, (byte) 0xC8, (byte) 0xD8,
            (byte) 0x18, (byte) 0x19, (byte) 0xD9, (byte) 0x1B, (byte) 0xDB,
            (byte) 0xDA, (byte) 0x1A, (byte) 0x1E, (byte) 0xDE, (byte) 0xDF,
            (byte) 0x1F, (byte) 0xDD, (byte) 0x1D, (byte) 0x1C, (byte) 0xDC,
            (byte) 0x14, (byte) 0xD4, (byte) 0xD5, (byte) 0x15, (byte) 0xD7,
            (byte) 0x17, (byte) 0x16, (byte) 0xD6, (byte) 0xD2, (byte) 0x12,
            (byte) 0x13, (byte) 0xD3, (byte) 0x11, (byte) 0xD1, (byte) 0xD0,
            (byte) 0x10, (byte) 0xF0, (byte) 0x30, (byte) 0x31, (byte) 0xF1,
            (byte) 0x33, (byte) 0xF3, (byte) 0xF2, (byte) 0x32, (byte) 0x36,
            (byte) 0xF6, (byte) 0xF7, (byte) 0x37, (byte) 0xF5, (byte) 0x35,
            (byte) 0x34, (byte) 0xF4, (byte) 0x3C, (byte) 0xFC, (byte) 0xFD,
            (byte) 0x3D, (byte) 0xFF, (byte) 0x3F, (byte) 0x3E, (byte) 0xFE,
            (byte) 0xFA, (byte) 0x3A, (byte) 0x3B, (byte) 0xFB, (byte) 0x39,
            (byte) 0xF9, (byte) 0xF8, (byte) 0x38, (byte) 0x28, (byte) 0xE8,
            (byte) 0xE9, (byte) 0x29, (byte) 0xEB, (byte) 0x2B, (byte) 0x2A,
            (byte) 0xEA, (byte) 0xEE, (byte) 0x2E, (byte) 0x2F, (byte) 0xEF,
            (byte) 0x2D, (byte) 0xED, (byte) 0xEC, (byte) 0x2C, (byte) 0xE4,
            (byte) 0x24, (byte) 0x25, (byte) 0xE5, (byte) 0x27, (byte) 0xE7,
            (byte) 0xE6, (byte) 0x26, (byte) 0x22, (byte) 0xE2, (byte) 0xE3,
            (byte) 0x23, (byte) 0xE1, (byte) 0x21, (byte) 0x20, (byte) 0xE0,
            (byte) 0xA0, (byte) 0x60, (byte) 0x61, (byte) 0xA1, (byte) 0x63,
            (byte) 0xA3, (byte) 0xA2, (byte) 0x62, (byte) 0x66, (byte) 0xA6,
            (byte) 0xA7, (byte) 0x67, (byte) 0xA5, (byte) 0x65, (byte) 0x64,
            (byte) 0xA4, (byte) 0x6C, (byte) 0xAC, (byte) 0xAD, (byte) 0x6D,
            (byte) 0xAF, (byte) 0x6F, (byte) 0x6E, (byte) 0xAE, (byte) 0xAA,
            (byte) 0x6A, (byte) 0x6B, (byte) 0xAB, (byte) 0x69, (byte) 0xA9,
            (byte) 0xA8, (byte) 0x68, (byte) 0x78, (byte) 0xB8, (byte) 0xB9,
            (byte) 0x79, (byte) 0xBB, (byte) 0x7B, (byte) 0x7A, (byte) 0xBA,
            (byte) 0xBE, (byte) 0x7E, (byte) 0x7F, (byte) 0xBF, (byte) 0x7D,
            (byte) 0xBD, (byte) 0xBC, (byte) 0x7C, (byte) 0xB4, (byte) 0x74,
            (byte) 0x75, (byte) 0xB5, (byte) 0x77, (byte) 0xB7, (byte) 0xB6,
            (byte) 0x76, (byte) 0x72, (byte) 0xB2, (byte) 0xB3, (byte) 0x73,
            (byte) 0xB1, (byte) 0x71, (byte) 0x70, (byte) 0xB0, (byte) 0x50,
            (byte) 0x90, (byte) 0x91, (byte) 0x51, (byte) 0x93, (byte) 0x53,
            (byte) 0x52, (byte) 0x92, (byte) 0x96, (byte) 0x56, (byte) 0x57,
            (byte) 0x97, (byte) 0x55, (byte) 0x95, (byte) 0x94, (byte) 0x54,
            (byte) 0x9C, (byte) 0x5C, (byte) 0x5D, (byte) 0x9D, (byte) 0x5F,
            (byte) 0x9F, (byte) 0x9E, (byte) 0x5E, (byte) 0x5A, (byte) 0x9A,
            (byte) 0x9B, (byte) 0x5B, (byte) 0x99, (byte) 0x59, (byte) 0x58,
            (byte) 0x98, (byte) 0x88, (byte) 0x48, (byte) 0x49, (byte) 0x89,
            (byte) 0x4B, (byte) 0x8B, (byte) 0x8A, (byte) 0x4A, (byte) 0x4E,
            (byte) 0x8E, (byte) 0x8F, (byte) 0x4F, (byte) 0x8D, (byte) 0x4D,
            (byte) 0x4C, (byte) 0x8C, (byte) 0x44, (byte) 0x84, (byte) 0x85,
            (byte) 0x45, (byte) 0x87, (byte) 0x47, (byte) 0x46, (byte) 0x86,
            (byte) 0x82, (byte) 0x42, (byte) 0x43, (byte) 0x83, (byte) 0x41,
            (byte) 0x81, (byte) 0x80, (byte) 0x40 };

    public int value;

    public XorUtil() {
        value = 0;

    }

    public void update(byte[] puchMsg, int usDataLen) {

        int uIndex;
        // int i = 0;
        for (int i = 0; i < usDataLen; i++) {
            uIndex = (uchCRCHi ^ puchMsg[i]) & 0xff;

            uchCRCHi = (byte) (uchCRCLo ^ auchCRCHi[uIndex]);
            uchCRCLo = auchCRCLo[uIndex];
        }
        value = ((((int) uchCRCHi) << 8 | (((int) uchCRCLo) & 0xff))) & 0xffff;

        return;
    }

    public void reset() {
        value = 0;
        uchCRCHi = (byte) 0xff;
        uchCRCLo = (byte) 0xff;
    }

    public int getValue() {
        return value;
    }

    private static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
                .byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
                .byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

    private static byte[] HexString2Buf(String src) {
        int len = src.length();
        byte[] ret = new byte[len / 2+2];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < len; i += 2) {
            ret[i / 2] = uniteBytes(tmp[i], tmp[i + 1]);
        }
        return ret;
    }

    public static byte[] getSendBuf(String toSend){
        byte[] bb = HexString2Buf(toSend);
        XorUtil crc16 = new XorUtil();
        crc16.update(bb, bb.length-2);
        int ri = crc16.getValue();
        bb[bb.length-1]=(byte) (0xff & ri);
        bb[bb.length-2]=(byte) ((0xff00 & ri) >> 8);
        return bb;
    }

    public static boolean checkBuf(byte[] bb){
        XorUtil crc16 = new XorUtil();
        crc16.update(bb, bb.length-2);
        int ri = crc16.getValue();
        if(bb[bb.length-1]==(byte)(ri&0xff)
                && bb[bb.length-2]==(byte) ((0xff00 & ri) >> 8))
            return true;
        return false;
    }

    public static String getBufHexStr(byte[] raw){
        if ( raw == null ) {
            return null;
        }
        final StringBuilder hex = new StringBuilder( 2 * raw.length );
        for ( final byte b : raw ) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }

}
