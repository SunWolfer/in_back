package com.ruoyi.project.api.winddevice.window.newversion.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 风窗预警表
 */
@Data
@TableName("tb_window_warn")
public class WindowWarnEntity implements Serializable {
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
	 * 预警类型
	 */
	private String yjlx;
	/**
	 * 预警内容
	 */
	private String yjmc;
	/**
	 * 预警时间
	 */
	private String createTime;
	/**
	 * 时间的毫秒数
	 */
	private Long timeMs;
	/**
	 * 风窗名称
	 */
	private String devName;
	/**
	 * 风窗位置
	 */
	private String devLocation;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(exist = false)
	private Date beginTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField(exist = false)
	private Date endTime;

}
