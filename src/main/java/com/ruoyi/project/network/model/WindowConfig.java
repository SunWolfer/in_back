package com.ruoyi.project.network.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class WindowConfig {
    /**
     * 请求的控制器IP
     */
    private String requestIp;

    private String requestSn;

    /**
     * 控制器地址编号
     */
    private String addressNumber;
    /**
     * 服务器ip
     */
    private String serverIp;
    /**
     * 服务器端口
     */
    private Integer serverPort;
    /**
     * IP获取方式
     */
    private String getIpWay;
    /**
     * 控制器IP
     */
    private String controllerIp;
    /**
     * 控制器子网掩码
     */
    private String controllerSubnetMask;
    /**
     * 控制器网关地址
     */
    private String controllerGatewayIp;
    /**
     * 心跳周期
     */
    private Integer heatBeatPeriod;
    /**
     * 上报周期
     */
    private Integer reportPeriod;
    /**
     * 超时时间
     */
    private Integer timeOut;
    /**
     * 总调节时间
     */
    private Integer controlTime;
    /**
     * 调节误差
     */
    private Integer controlError;
    /**
     * 风窗A工作模式
     */
    private String workModeA;
    /**
     * 风窗A风速/风量/风压类型 0-风速， 1-风量， 2-风压
     */
    private String controlTypeA;
    /**
     * 风窗A风速/风量/风压目标值
     */
//    private Float controlTargetB;
    private Float controlSpeedA;
    private Float controlVolumeA;
    private Float controlPressureA;
    /**
     * 风窗A开度目标值
     */
    private Integer openDegreeTargetA;
    /**
     * 风窗B工作模式
     */
    private String workModeB;
    /**
     * 风窗B风速/风量/风压类型  0-风速， 1-风量， 2-风压
     */
    private String controlTypeB;
    /**
     * 风窗B风速/风量/风压目标值
     */
//    private Float controlTargetB;
    private Float controlSpeedB;
    private Float controlVolumeB;
    private Float controlPressureB;

    /**
     *  风窗B开度目标值
     */
    private Integer openDegreeTargetB;
    /**
     * do1设备类型
     */
    private String doDeviceType1;
    /**
     * do1控制源
     */
    private String doControlSource1;

    private String doDeviceType2;

    private String doControlSource2;

    private String doDeviceType3;

    private String doControlSource3;

    private String doDeviceType4;

    private String doControlSource4;

    private String doDeviceType5;

    private String doControlSource5;

    private String doDeviceType6;

    private String doControlSource6;

    private String doDeviceType7;

    private String doControlSource7;

    private String doDeviceType8;

    private String doControlSource8;

    private String doDeviceType9;

    private String doControlSource9;

    private String doDeviceType10;

    private String doControlSource10;

    private String doDeviceType11;

    private String doControlSource11;

    private String doDeviceType12;

    private String doControlSource12;

    /**
     * di1设备类型
     */
    private String diDeviceType1;
    /**
     * di1极性
     */
    private String diPalarity1;
    /**
     * di1传感器类型
     */
    private String diSensorType1;
    private String diDeviceType2;
    private String diPalarity2;
    private String diSensorType2;
    private String diDeviceType3;
    private String diPalarity3;
    private String diSensorType3;
    private String diDeviceType4;
    private String diPalarity4;
    private String diSensorType4;
    private String diDeviceType5;
    private String diPalarity5;
    private String diSensorType5;
    private String diDeviceType6;
    private String diPalarity6;
    private String diSensorType6;
    private String diDeviceType7;
    private String diPalarity7;
    private String diSensorType7;
    private String diDeviceType8;
    private String diPalarity8;
    private String diSensorType8;
    private String diDeviceType9;
    private String diPalarity9;
    private String diSensorType9;
    private String diDeviceType10;
    private String diPalarity10;
    private String diSensorType10;
    private String diDeviceType11;
    private String diPalarity11;
    private String diSensorType11;
    private String diDeviceType12;
    private String diPalarity12;
    private String diSensorType12;

    /**
     * ai1设备类型
     */
    private String aiDeviceType1;
    /**
     * ai1报警门限
     */
    private String aiAlarmLimit1;
    /**
     * ai1解除门限
     */
    private String aiCancelAlarmLimit1;
    /**
     * ai1滤波次数
     */
    private String aiFilterNumber1;
    /**
     * ai1传感器类型
     */
    private String aiSensorType1;
    /**
     * ai1传感器厂家
     */
    private String aiSensorFactory1;
    /**
     * ai1传感器型号
     */
    private String aiSensorModel1;

    private String aiDeviceType2;
    private String aiAlarmLimit2;
    private String aiCancelAlarmLimit2;
    private String aiFilterNumber2;
    private String aiSensorType2;
    private String aiSensorFactory2;
    private String aiSensorModel2;

    /**
     * rs485设备类型
     */
    private String rs485DeviceType1;
    /**
     * rs485波特率
     */
    private String rs485Baud1;
    /**
     * rs485校验位
     */
    private String rs485CheckBit1;
    /**
     * rs485传感器类型
     */
    private String rs485SensorType1;

    private String rs485DeviceType2;
    private String rs485Baud2;
    private String rs485CheckBit2;
    private String rs485SensorType2;

    private String rs485DeviceType3;
    private String rs485Baud3;
    private String rs485CheckBit3;
    private String rs485SensorType3;

    private String rs485DeviceType4;
    private String rs485Baud4;
    private String rs485CheckBit4;
    private String rs485SensorType4;

}
