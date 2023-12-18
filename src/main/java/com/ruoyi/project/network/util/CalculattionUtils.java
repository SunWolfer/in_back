package com.ruoyi.project.network.util;


import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CalculattionUtils {

    /**
     * 百叶窗根据开口面积计算开度值
     * @param width 风窗宽度
     * @param length 风窗长度
     * @param area 开口面积
     */
    public static int areaToOpenDegreeByc(String width, String length, String area){

        double widthD = Double.parseDouble(width);
        double lengthD = Double.parseDouble(length);
        double areaD = Double.parseDouble(area);


        BigDecimal p1 = new BigDecimal(Double.toString(widthD));
        BigDecimal p2 = new BigDecimal(Double.toString(lengthD));
        BigDecimal areaDecimal = p1.multiply(p2);

        BigDecimal p3 = new BigDecimal(Double.toString(areaD));
        BigDecimal divide = p3.divide(areaDecimal, 2, BigDecimal.ROUND_HALF_UP);

        BigDecimal p4 = new BigDecimal("1");
        double cosValue = p4.subtract(divide).doubleValue();

//        double cosValue = 1 - (areaD / (widthD * lengthD));

//        double kcjd = Math.acos(cosValue) * 180d / Math.PI;
        double kcjd = Math.toDegrees(Math.acos(cosValue));

        BigDecimal kcjdDecimal = new BigDecimal(Double.toString(kcjd));
        BigDecimal p5 = new BigDecimal(Double.toString(0.9));
        double kdz = kcjdDecimal.divide(p5, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        Double kdz = kcjd / 0.9;
        int round = (int)Math.round(kdz);
        return round;
    }

    /**
     * 推拉窗根据开口面积计算开度值
     * @param width
     * @param length
     * @param area
     * @return
     */
    public static int areaToOpenDegreeTlc(String width, String length, String area){

        double widthD = Double.parseDouble(width);
        double lengthD = Double.parseDouble(length);
        double areaD = Double.parseDouble(area);

        BigDecimal p1 = new BigDecimal(Double.toString(widthD));
        BigDecimal p2 = new BigDecimal(Double.toString(lengthD));
        BigDecimal areaDecimal = p1.multiply(p2);
        BigDecimal p3 = new BigDecimal(Double.toString(areaD));
        BigDecimal divide = p3.divide(areaDecimal, 2, BigDecimal.ROUND_HALF_UP);

        BigDecimal p4 = new BigDecimal("100");

        double kdz = divide.multiply(p4).doubleValue();
//        double kdz = (areaD / (widthD * lengthD)) * 100;

        int round = (int)Math.round(kdz);
        return round;
    }


    /**
     * 百叶窗根据开度值计算开口面积
     * @param width 风窗宽度
     * @param length 风窗长度
     * @param kd 开度
     */
    public static String openDegreeToAreaByc(String width, String length, String kd){

        double widthD = Double.parseDouble(width);
        double lengthD = Double.parseDouble(length);
        double kdD = Double.parseDouble(kd);

        BigDecimal p1 = new BigDecimal(Double.toString(widthD));
        BigDecimal p2 = new BigDecimal(Double.toString(lengthD));
        BigDecimal p3 = new BigDecimal(Double.toString(kdD));
        BigDecimal p4 = new BigDecimal(Double.toString(0.9));

        double kjd = p4.multiply(p3).doubleValue();
//        double kjd = 0.9 * kdD;
        double kjdjava = Math.toRadians(kjd);//把数字90转换成90度

        BigDecimal areaDecimal = p1.multiply(p2);

        double cos = Math.cos(kjdjava);
        BigDecimal p5 = new BigDecimal("1");
        BigDecimal p6 = new BigDecimal(Double.toString(cos));
        BigDecimal subtract = p5.subtract(p6);

        double area = areaDecimal.multiply(subtract).doubleValue();

//        double area = (widthD * lengthD) * (1 - Math.cos(kjdjava));
        DecimalFormat df =new DecimalFormat("0.00");
        String areaFormat = df.format(area);
        return areaFormat;
    }


    /**
     * 推拉窗根据开度值计算开口面积
     * @param width
     * @param length
     * @param kd
     * @return
     */
    public static String openDegreeToAreaTlc(String width, String length, String kd){

        double widthD = Double.parseDouble(width);
        double lengthD = Double.parseDouble(length);
        double kdD = Double.parseDouble(kd);

        BigDecimal p1 = new BigDecimal(Double.toString(widthD));
        BigDecimal p2 = new BigDecimal(Double.toString(lengthD));
        BigDecimal p3 = new BigDecimal(Double.toString(kdD));
        BigDecimal p4 = new BigDecimal("100");

        BigDecimal areaDecimal = p1.multiply(p2);
        BigDecimal divide = p3.divide(p4, 2, BigDecimal.ROUND_HALF_UP);
        double areaD = divide.multiply(areaDecimal).doubleValue();

//        double areaD = kdD / 100 * (widthD * lengthD);

        return String.valueOf(areaD);
    }

    public static String areaPercent(String width, String length, String area){
        double widthD = Double.parseDouble(width);
        double lengthD = Double.parseDouble(length);
        double areaD = Double.parseDouble(area);

        BigDecimal p1 = new BigDecimal(Double.toString(widthD));
        BigDecimal p2 = new BigDecimal(Double.toString(lengthD));
        BigDecimal p3 = new BigDecimal(Double.toString(areaD));
        BigDecimal p4 = new BigDecimal("100");

        BigDecimal areaDecimal = p1.multiply(p2);
        double percent = p3.divide(areaDecimal, 2, BigDecimal.ROUND_HALF_UP).multiply(p4).doubleValue();
//        double percent = (areaD / (widthD * lengthD)) * 100;
        DecimalFormat df =new DecimalFormat("0.00");
        String areaFormat = df.format(percent);
        return areaFormat;
    }

    public static void main(String[] args) {
//        double a = Math.toRadians(30);//把数字90转换成90度
//        double cos = Math.toDegrees(Math.acos(0.70710678));
//        System.out.println(cos);
        int i = areaToOpenDegreeByc("20","20","200");
        System.out.println(i);

        int i1 = areaToOpenDegreeTlc("10","10","50");
        System.out.println(i1);

        String s = openDegreeToAreaByc("10", "10", "67");
        System.out.println(s);

        String s1 = openDegreeToAreaTlc("10", "10", "50");
        System.out.println(s1);
    }
}
