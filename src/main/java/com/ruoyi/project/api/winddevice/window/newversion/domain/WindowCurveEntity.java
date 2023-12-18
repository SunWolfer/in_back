package com.ruoyi.project.api.winddevice.window.newversion.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 风窗曲线表
 */
@Data
@TableName("tb_window_curve")
public class WindowCurveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 风窗id
	 */
	private Long devId;

	/**
	 * 风速
	 */
	private String speed;
	/**
	 * 风量
	 */
	private String volume;
	/**
	 * 开度
	 */
	private String openDegree;
	/**
	 * 断面面积
	 */
	private String area;
	/**
	 * 风压
	 */
	private String pressure;
	/**
	 * 绝压
	 */
	private String absolutePressure;
	/**
	 * 温度
	 */
	private String temperature;
	/**
	 * 湿度
	 */
	private String humidity;

	/**
     * 预警时间
	 */
	private String createTime;
	/**
     * 时间的毫秒数
	 */
	private Long timeMs;



}
