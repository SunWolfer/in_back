package com.ruoyi.project.api.winddevice.door.newversion.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.io.Serializable;
import java.util.Date;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 风门用户操作信息对象 tb_door_oper
 * 
 * @author ruoyi
 * @date 2023-08-08
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_door_oper")
public class DoorOper implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private Long devId;

    /** 操作类型 */
    @Excel(name = "操作类型")
    private String czlx;

    /** 操作名称 */
    @Excel(name = "操作名称")
    private String czmc;

    /** 操作人 */
    @Excel(name = "操作人")
    private String createUser;

    /** 操作时间 */
    private String createTime;

    /** 时间毫秒数 */
    @Excel(name = "时间毫秒数")
    private Long timeMs;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String devName;

    /** 设备位置 */
    @Excel(name = "设备位置")
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
