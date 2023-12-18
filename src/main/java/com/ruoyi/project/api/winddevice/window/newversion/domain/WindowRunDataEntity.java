package com.ruoyi.project.api.winddevice.window.newversion.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 风窗运行状态信息表
 */
@Data
@TableName("tb_window_run_data")
public class WindowRunDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 风窗IP
	 */
	@TableId(value = "ip", type = IdType.INPUT)
	private String ip;
	/**
	 * 地址编号
	 */
	private String addrNum;

	/**
	 * 风窗A工作模式
	 */
	private String workModelA;
	/**
	 * 风窗A风压风速风量
	 */
	private String controlTypeA;
	/**
	 * 风窗A 风速传感器0 多参传感器2 差压传感器3
	 */
	private String controlSensorA;
	/**
	 * 风窗A风速
	 */
	private String speedA;
	/**
	 * 风窗A风量
	 */
	private String volumeA;
	/**
	 * 风窗A风压
	 */
	private String pressureA;
	/**
	 * 风窗A绝压
	 */
	private String absolutePressureA;
	/**
	 * 风窗A温度
	 */
	private String temperatureA;
	/**
	 * 风窗A湿度
	 */
	private String humidityA;
	/**
	 * 风窗A开度
	 */
	private String openDegreeA;

	/**
	 * 风窗B工作模式
	 */
	private String workModelB;
	/**
	 * 风窗B风压风速风量
	 */
	private String controlTypeB;
	/**
	 * 风窗B 风速传感器0 多参传感器2 差压传感器3
	 */
	private String controlSensorB;
	/**
	 * 风窗B风速
	 */
	private String speedB;
	/**
	 * 风窗B风量
	 */
	private String volumeB;
	/**
	 * 风窗B风压
	 */
	private String pressureB;
	/**
	 * 风窗A绝压
	 */
	private String absolutePressureB;
	/**
	 * 风窗B温度
	 */
	private String temperatureB;
	/**
	 * 风窗B湿度
	 */
	private String humidityB;
	/**
	 * 风窗B开度
	 */
	private String openDegreeB;
	/**
	 * 风窗A正在调风 0否 1是
	 */
	private String ajustingA;
	/**
	 * 风窗B正在调风 0否 1是
	 */
	private String ajustingB;
	/**
	 * 风窗A超时预警 0否 1是
	 */
	private String outTimeA;
	/**
	 * 风窗B超时预警 0否 1是
	 */
	private String outTimeB;
	/**
	 * 风窗A编码器故障 0否 1是
	 */
	private String encoderErrorA;
	/**
	 * 风窗B编码器故障 0否 1是
	 */
	private String encoderErrorB;
	/**
	 * 气源压力报警 0否 1是
	 */
	private String airError;
	/**
	 * DI开关量检测预警 0否 1是
	 */
	private String ocCheckWarn;
	/**
	 * I开关量检测预警 对应的di号
	 */
	private String ocCheckWarnNum;
	/**
	 * ai1是否有值 0否 1是
	 */
	private String ai1ValueHave;
	/**
	 * ai1值
	 */
	private String ai1Value;
	/**
	 * ai2是否有值 0否 1是
	 */
	private String ai2ValueHave;
	/**
	 * ai2值
	 */
	private String ai2Value;
	/**
	 * ai1报警 0否 1是
	 */
	private String ai1Warn;
	/**
	 * ai2报警 0否 1是
	 */
	private String ai2Warn;
	/**
     * 远程报警
	 */
	private String remoteWarn;

	/**
     * 预警时间
	 */
	private String createTime;
	/**
     * 时间的毫秒数
	 */
	private Long timeMs;



}
