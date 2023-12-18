package com.ruoyi.project.network.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;

public class DataFormatUtil {
    private static final String[] BYTE_HEX = new String[256];
    private static final Map<String, Integer> map = new HashMap<>();
    private static final Map<String, String> map2 = new HashMap<>();

    static {
        for (int i = 0; i < 16; i++) {
            String str = "0" + Integer.toHexString(i);
            BYTE_HEX[i] = str;
            map.put(str, i);
            map2.put(str.toUpperCase(), str);
        }
        for (int i = 16; i < 256; i++) {
            String str = Integer.toHexString(i);
            BYTE_HEX[i] = str;
            map.put(str, i);
            map2.put(str.toUpperCase(), str);
        }
    }

    public static String strToHex(String str, Charset charset) {
        return bytesToHex(str.getBytes(charset));
    }

    public static String bytesToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (byte b : data) {
            int i = b & 0xff;
            if (buf.length() > 0) {
                buf.append(" ");
            }
            buf.append(BYTE_HEX[i]);
        }
        return buf.toString();
    }

    public static String hexToStr(String hex, Charset charset) {
        return new String(hexToBytes(hex), charset);
    }

    public static byte[] hexToBytes(String hex) {
        String str = hex.replaceAll("[ \r\n]", "");
        if ((str.length() & 1) != 0) {
            str = str.substring(0, str.length() - 1);
        }
        byte[] result = new byte[str.length() >> 1];
        for (int i = 0; i < str.length(); i += 2) {
            String s = str.substring(i, i + 2);
            String lowerCase = map2.get(s);
            s = lowerCase == null ? s : lowerCase;
            Integer val = map.get(s);
            if (val == null) {
                throw new RuntimeException("字符串[" + s + "]不是字节的16进制字符串");
            }
            result[i >> 1] = val.byteValue();
        }
        return result;
    }

    public static Integer byteToHL(byte[] b, int offset) {
        Integer result;
        result = ((((b[offset + 1]) << 8) & 0xff00 | b[offset] & 0x00ff));
        return result;
    }

    /**
     * 无符号位16进制转10进制
     * 16进制不带空格
     * @param b
     * @return
     */
    public static String HexToDecimal(String b){
        String decimal = new BigInteger(b, 16).toString();
        return decimal;
    }

    /**
     * 无符号位16进制转10进制
     * 16进制带空格
     * @param b
     * @return
     */
    public static String HexSpaceToDecimal(String b){
        String s = b.replaceAll(" ", "");
        String decimal = new BigInteger(s, 16).toString();
        return decimal;
    }

    //合并字节数组
    public static byte[] mergeByteArray(byte[]... bytes){
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            for(byte[] oneByte : bytes){
                os.write(oneByte);
            }
            byte[] mergeBytes = os.toByteArray();
            return mergeBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 有符号位16进制转10进制
     * 十六进制不带空格
     * @param strHex
     * @return
     */
    public static String symbolHexToDecimal(String strHex){
        String is =  String.valueOf((Integer.valueOf(strHex, 16).shortValue()));
        return is;
    }

    /**
     * 有符号位16进制转10进制
     * @param strHex 十六进制带空格
     * @return
     */
    public static String symbolSpaceHexToDecimal(String strHex){
        String is =  String.valueOf((Integer.valueOf(strHex.replaceAll(" ",""), 16).shortValue()));
        return is;
    }

    /**
     * 高低位转换
     * @param str
     * @return
     */
    public static String highLowHex(String str){

        if(str.trim().length()<=2) return str;

        List<String> list = Arrays.asList( str.split(" "));

        Collections.reverse(list);

        StringBuffer stringBuffer = new StringBuffer();

        for(String string:list){

            stringBuffer.append(string);

        }

        return stringBuffer.toString();

    }

    /**
     * 16进制数据加空格
     * @param str
     * @return
     */
    public static String spaceHex(String str){

        char[] array= str.toCharArray();

        if(str.length()<=2) return str;

        StringBuffer buffer =new StringBuffer();

        for(int i=0;i<array.length;i++){

            int start =i+1;

            if(start%2==0){

                buffer.append(array[i]).append(" ");

            }else{

                buffer.append(array[i]);

            }

        }

        return buffer.toString();

    }


    /**
     * 高低位转换 有符号位16进制转10进制
     * @param hexStr
     * @return
     */
    public static String formatValue(String hexStr){
        String s = DataFormatUtil.highLowHex(hexStr);
        String s1 = DataFormatUtil.symbolHexToDecimal(s);
        return s1;
    }

    /**
     * 高低位转换 无符号位16进制转10进制
     * @param hexStr
     * @return
     */
    public static String formatUnsignedHex(String hexStr){
        String s = DataFormatUtil.highLowHex(hexStr);
        String s1 = DataFormatUtil.HexToDecimal(s);
        return s1;
    }


    public static String intToHex(Double number) {
        Double d = new Double(number*100);
        int s = d.intValue();
        String hex = Integer.toHexString(s);
        String result = "";
        if(hex.length()>4){
            String hexResult  = hex.substring(hex.length() - 4);
            String after = hexResult.substring(2);
            String pre = hexResult.substring(0, 2);
            result = pre + " " + after;
        } else if(hex.length() == 4){
            String after = hex.substring(2);
            String pre = hex.substring(0, 2);
            result = pre + " " + after;
        } else if(hex.length() == 3){
            String after = hex.substring(1);
            String pre = hex.substring(0, 1);
            result = "0" + pre + " " + after;
        } else if(hex.length() == 2){
            result = "00 " + hex;
        } else if(hex.length() == 1){
            result = "00 0" + hex;
        }

        return result;
    }


    /**
     * 将字节byte转换为一个长度为8的byte数组，数组每个值代表bit，即8个bit,bit7 -> bit0
     * bit数组，bit7 -> bit0
     *
     */
    public static byte[] byteToBitArray(byte b) {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }

    /**
     * 把byte转为字符串的bit
     */
    public static String byteToBitStr(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }

    /**
     * Bit转Byte
     */
    public static byte bitToByte(String byteStr) {
        int re, len;
        if (null == byteStr) {
            return 0;
        }
        len = byteStr.length();
        if (len != 4 && len != 8) {
            return 0;
        }
        if (len == 8) {// 8 bit处理
            if (byteStr.charAt(0) == '0') {// 正数
                re = Integer.parseInt(byteStr, 2);
            } else {// 负数
                re = Integer.parseInt(byteStr, 2) - 256;
            }
        } else {//4 bit处理
            re = Integer.parseInt(byteStr, 2);
        }
        return (byte) re;
    }


    /**
     * 浮点数转换为16进制字符串
     * @param value
     * @return
     */
    public static String floatToHexStr(String value){
        if("0".equals(value) || "0.0".equals(value) || "0.00".equals(value)){
            return "00000000";
        }
        Float f = Float.parseFloat(value);
        String fhex = Integer.toHexString(Float.floatToIntBits(f));
        return fhex;
    }


    /**
     * 将 4字节的16进制字符串，转换为32位带符号的十进制浮点型
     * 十六进制不带空格
     * @param
     * @return
     */
    public  static  float hexToFloat(String hexStr){
        return  Float.intBitsToFloat(new BigInteger(hexStr.trim(), 16).intValue());
    }




    public static void main(String[] args) {
//      byte[] bytes = DataFormatUtil.hexToBytes("0 A 0 b \r \n");
//      System.out.println(bytesToHex(bytes));

        /*String s = DataFormatUtil.highLowHex("03 00");
        Integer integer = DataFormatUtil.byteToHL(DataFormatUtil.hexToBytes("8dff"), 0);
        System.out.println(integer);
        System.out.println(s);

        String s1 = DataFormatUtil.spaceHex(s);
        System.out.println(s1);*/
//        String a = "c1a4c000";
//        float v = DataFormatUtil.hexToFloat(a);
//        System.out.println(v);


        /*Double aDouble = DataFormatUtil.formatValue("ec6c");
        System.out.println(aDouble);*/

//      String regex = "[0-9|a-f|A-F ]*";
//      String str = "0123456789abcdef ";
//      System.out.println(str.matches(regex));

        /*ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putInt(151455494);
        buf.flip();
        byte[] bytes = buf.array();
        System.out.println(Arrays.toString(bytes));*/

//      SortedMap<String, Charset> map = Charset.availableCharsets();
//      for (Entry<String, Charset> entry : map.entrySet()) {
//          System.out.println("{\"" + entry.getKey() + "\", \"" + entry.getValue().name() + "\"},");
//      }
//        double number = -0.02;
//        String s = intToHex(number);
//        System.out.println(s);
//        String s = strToHex("1", Charset.forName("utf-8"));
//        System.out.println(s);

   /*     byte[] bytes = DataFormatUtil.hexToBytes("12");
        System.out.println(bytes.length);
        String s = byteToBitStr(bytes[0]);
        byte[] bytes1 = byteToBitArray(bytes[0]);
        String s1 = DataFormatUtil.bytesToHex(bytes1);
        System.out.println(s1);
        System.out.println(s);

        byte b = DataFormatUtil.bitToByte("00010010");
        byte[] b1 = new byte[1];
        b1[0] = b;
        String s2 = DataFormatUtil.bytesToHex(b1);
        System.out.println(s2);*/
//        System.out.println(s1);
//        byteToBitStr()
        System.out.println("<========================================================>");

/*        StringBuilder sb0 = new StringBuilder();

        sb0.append(0);
        sb0.insert(0, 0);
        sb0.insert(0, 0);
        sb0.insert(0, 1);
        sb0.insert(0, 1);
        sb0.insert(0, 1);
        sb0.insert(0, 1);
        sb0.insert(0, 0);
        byte dataBytes0 = DataFormatUtil.bitToByte(sb0.toString());

        StringBuilder sb1 = new StringBuilder();

        sb1.append(0);
        sb1.insert(0, 1);
        sb1.insert(0, 1);
        sb1.insert(0, 0);
        sb1.insert(0, 1);
        sb1.insert(0, 0);
        sb1.insert(0, 1);
        sb1.insert(0, 0);
        byte dataBytes1 = DataFormatUtil.bitToByte(sb1.toString());


        StringBuilder sb2 = new StringBuilder();

        sb2.append(0);
        sb2.insert(0, 0);
        sb2.insert(0, 1);
        sb2.insert(0, 0);
        sb2.insert(0, 1);
        sb2.insert(0, 1);//预留
        sb2.insert(0, 0);//预留
        sb2.insert(0, 0);//预留
        byte dataBytes2 = DataFormatUtil.bitToByte(sb2.toString());

        //预留部分
        StringBuilder sb3 = new StringBuilder();

        sb3.append(0);
        sb3.insert(0, 1);
        sb3.insert(0, 0);
        sb3.insert(0, 0);
        sb3.insert(0, 1);
        sb3.insert(0, 0);//预留
        sb3.insert(0, 0);//预留
        sb3.insert(0, 0);//预留
        byte dataBytes3 = DataFormatUtil.bitToByte(sb3.toString());

        byte[] contentBytes = new byte[4];
        contentBytes[0] = dataBytes0;
        contentBytes[1] = dataBytes1;
        contentBytes[2] = dataBytes2;
        contentBytes[3] = dataBytes3;

        String s3 = DataFormatUtil.bytesToHex(contentBytes);
        System.out.println(s3);*/

/*        byte[] lenBytes = DataFormatUtil.hexToBytes("0600");
        String s3 = DataFormatUtil.bytesToHex(lenBytes);
        System.out.println(s3);*/
/*
        float f1 = 1.5f;
        String s = floatToHexStr(String.valueOf(f1));
        String s1 = spaceHex(s);
        System.out.println(s);
        System.out.println(s1);
        String s2 = highLowHex(s1);
        System.out.println(s2);*/

/*        String s = "70 17";
        String s1 = DataFormatUtil.highLowHex(s);
        String s2 = DataFormatUtil.HexToDecimal(s1);
        System.out.println(s2);*/

//        String s = "A4 70 9D BF";
//        String s1 = highLowHex(s);
//        System.out.println(s1);
//        float v = hexToFloat(s1);
//        System.out.println(v);
        String s = floatToHexStr("-1.23");
        System.out.println(s);
        System.out.println(Integer.toHexString(Float.floatToIntBits(-1.23f)));
    }
}
