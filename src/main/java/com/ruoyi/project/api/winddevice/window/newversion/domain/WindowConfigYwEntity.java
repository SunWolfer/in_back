package com.ruoyi.project.api.winddevice.window.newversion.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 风窗配置业务表
 */
@Data
@TableName("tb_window_config_yw")
public class WindowConfigYwEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 风窗IP
	 */
	@TableId(value = "ip", type = IdType.INPUT)
	private String ip;

	private String di1Type;
	private String di1SensorType;
	private String di2Type;
	private String di2SensorType;
	private String di3Type;
	private String di3SensorType;
	private String di4Type;
	private String di4SensorType;
	private String di5Type;
	private String di5SensorType;
	private String di6Type;
	private String di6SensorType;
	private String di7Type;
	private String di7SensorType;
	private String di8Type;
	private String di8SensorType;
	private String di9Type;
	private String di9SensorType;
	private String di10Type;
	private String di10SensorType;
	private String di11Type;
	private String di11SensorType;
	private String di12Type;
	private String di12SensorType;

	private String ai1Type;
	private String ai1SensorType;
	private String ai1SensorFactory;
	private String ai1SensorModel;

	private String ai2Type;
	private String ai2SensorType;
	private String ai2SensorFactory;
	private String ai2SensorModel;

	private String rs1Type;
	private String rs1SensorType;
	private String rs2Type;
	private String rs2SensorType;
	private String rs3Type;
	private String rs3SensorType;
	private String rs4Type;
	private String rs4SensorType;

	private String createTime;
	private Long timeMs;

}
