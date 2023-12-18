package com.ruoyi.project.api.winddevice.window.newversion.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 风窗登录表
 */
@Data
@TableName("tb_window_login")
public class WindowLoginEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;

	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 端口号
	 */
	private Integer port;
	/**
	 * 地址编号
	 */
	private String addrNum;
	/**
	 * 登录标识
	 */
	private String loginTag;
	/**
	 * 登录时间
	 */
	private String createTime;
	/**
	 * 时间的毫秒数
	 */
	private Long timeMs;



}
