package com.ruoyi.project.api.home.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class HomeDeviceVo {

    private Long id;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备大类 1
     */
    private String mainType;
    private String devType;
    private String value;
    private String warnStatus;
    private String warnName;
    private Integer warnLevel;
//    private String warnType;
    private String uniqueCode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date warnTime;
    private String onlineStatus;

    /** 模型编号 */
    private String mapModelCode;

    /** 三维x轴坐标 */
    private Double pointX;

    /** 三维y轴坐标 */
    private Double pointY;

    /** 三维z轴坐标 */
    private Double pointZ;

    /** 三维位置x轴坐标 */
    private Double positionX;

    /** 三维位置y轴坐标 */
    private Double positionY;

    /** 三维位置z轴坐标 */
    private Double positionZ;

    /** 三维视角x轴坐标 */
    private Double lookAtX;

    /** 三维视角y轴坐标 */
    private Double lookAtY;

    /** 三维视角z轴坐标 */
    private Double lookAtZ;

}
