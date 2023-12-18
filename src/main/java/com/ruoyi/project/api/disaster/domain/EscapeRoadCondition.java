package com.ruoyi.project.api.disaster.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EscapeRoadCondition {


    public static Double getRoadTypeCondition(String type){
        if("1".equals(type)){
            return 1.00d;
        } else if("2".equals(type)){
            return 1.00d;
        } else if("3".equals(type)){
            return 1.25d;
        } else if("4".equals(type)){
            return 1.30d;
        } else if("5".equals(type)){
            return 1.22d;
        } else if("6".equals(type)){
            return 1.15d;
        } else if("7".equals(type)){
            return 1.30d;
        } else if("8".equals(type)){
            return 10000d;
        }
        return 1.00d;
    }

    public static Double getAngleContion(Double startAltitude, Double endAltitude, Double length){
        BigDecimal start = new BigDecimal(String.valueOf(startAltitude));
        BigDecimal end = new BigDecimal(String.valueOf(endAltitude));
        BigDecimal len = new BigDecimal(String.valueOf(length));
        BigDecimal subtract = end.subtract(start);
        double v = subtract.divide(len, 2, RoundingMode.HALF_UP).doubleValue();
        double angelD = Math.toDegrees(Math.asin(v));
        BigDecimal angelB = new BigDecimal(String.valueOf(angelD));
        double v1 = angelB.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return v1;
    }

    public static void main(String[] args) {
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);

        System.out.format("pi 的值为 %.4f%n", Math.PI);
        System.out.format("%.4f 的反正弦值为 %.4f 度 %n", Math.sin(radians), Math.toDegrees(Math.asin(Math.sin(radians))));
        System.out.println(Math.asin(Math.sin(radians)));
        System.out.println( Math.round(Math.toDegrees(Math.asin(Math.sin(radians)))));
    }

}
