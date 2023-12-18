package com.ruoyi.common.utils;


import java.math.BigInteger;

/**
 * 进制转化
 * @author
 *
 */
public class HexUtil {

    /**
     * 二进制byte数组转十六进制String
     * byte array to hex
     *
     * @param b byte array
     * @return hex string
     */
    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int i = 0; i < b.length; i++) {
            stmp = Integer.toHexString(b[i] & 0xFF).toUpperCase();
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString();
    }

    /**
     * 十六进制byte数组转二进制byte数组
     * hex to byte array
     *
     * @param hex hex string
     * @return byte array
     */
    public static byte[] hex2byte(String hex)
             throws IllegalArgumentException{
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException ("invalid hex string");
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }



    /**
	 * 将字节数组转换成十六进制的字符串
	 *
	 * @return
	 */
	public static String BinaryToHexString(byte[] bytes) {
	    String hexStr = "0123456789ABCDEF";
	    String result = "";
	    String hex = "";
	    for (byte b : bytes) {
	        hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
	        hex += String.valueOf(hexStr.charAt(b & 0x0F));
	        result += hex + " ";
	    }
	    return result;
	}

	public static String getCrc(int value){
	    return byte2hex(intToBytes(value));
    }

    /**
     * 将int转换成byte数组，低位在前，高位在后
     * 改变高低位顺序只需调换数组序号
     */
    private static byte[] intToBytes(int value) {
        byte[] src = new byte[2];
        src[1] = (byte) ((value >> 8) & 0xFF);
        src[0] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * 将16进制字符串转换成float
     * @return
     */
    public static Float hexStringToFloat(String hex) {

        Float value = Float.intBitsToFloat(new BigInteger(hex,16).intValue());
        return value;
    }


    public static String hexStringToByte(String hex) {
        int i = Integer.parseInt(hex, 16);
        String str2 = Integer.toBinaryString(i);
        str2 = String.format("%08d",Integer.parseInt(str2));
        return str2;
    }
    /**
     * 将16进制字符串转换成2进制的字符串
     * @param b
     */

    public static String byte2BinStr(byte[] b){
        return hexStr2BinStr(byte2hex(b));
    }
    public static String hexStr2BinStr(String hexStr){
        String[] srcs = hexStr.split("");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < srcs.length; i=i+2){
            sb.append(formatStr(Long.toBinaryString(Long.parseLong(srcs[i]+srcs[i+1], 16))));
        }
        return sb.toString();
    }
    private static String formatStr(String str){
        //左边拼0不足四位
        String s = "00000000";
        s = s.substring(0,8-str.length())+str;
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * 字符串长度不足length的长度进行左侧补0
     * @param source
     * @param length
     * @return
     */
    public static String leftStr(String source,int length){
        if(source.length() < length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < length; i++){
                sb.append("0");
            }
            //左边拼0
            String s = sb.toString();
            s = s.substring(0,length-source.length())+source;
            return  s;
        }
        return source;
    }
    public static void main(String[] args) {
        int  source = 20;
        System.out.println(Integer.toHexString(source));
        System.out.println(leftStr(Integer.toHexString(source), 4));
//        String str1 = "A001";


        //String str1 = "1";
       /* String hexStr = HexUtil.byte2hex(str1.getBytes());
        System.out.println(hexStr);
        String str2 = new String(HexUtil.hex2byte(hexStr));
        System.out.println(str2);
        System.out.println(str1.equals(str2));
        ///FFFC502E
        257275

        3ecfb
*/


//       Long v = new Long(257275);
       //System.out.println(Long.toHexString(v));

       // System.out.println(Long.valueOf("ecfb",16));



//        String s="c1780000";
//        BigInteger bi = new BigInteger(s,16);

       // System.out.println(new BigInteger("FFFC502E",16).intValue());

//        Float value = Float.intBitsToFloat(bi.intValue());
      // System.out.println(value);

//        Float f=-15.5f;
//        String ihex = "0003A980";

        //System.out.println((Integer.valueOf("01d9",16)-200d)/10d);

//        System.out.println(Integer.toHexString(101));
        /*System.out.println(Float.floatToIntBits(f));

        System.out.println(Integer.valueOf("240000",16));

        System.out.println(Integer.toHexString(240000));

        System.out.println(Integer.toHexString(Float.floatToIntBits(3.1f)));

        System.out.println(s.substring(4));

        System.out.println(Integer.valueOf(ihex.substring(0,4),16)+","+Integer.valueOf(ihex.substring(4),16));*/
    }

}
