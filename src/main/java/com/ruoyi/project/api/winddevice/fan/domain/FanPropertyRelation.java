package com.ruoyi.project.api.winddevice.fan.domain;

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

/**
 * 风机参数关联管理对象 tb_fan_property_relation
 * 
 * @author ruoyi
 * @date 2023-08-09
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_fan_property_relation")
public class FanPropertyRelation implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 风机主键 */
    @Excel(name = "风机主键")
    private Long devId;

    /** 风机类型：1-主扇；2-局扇 */
    @Excel(name = "风机类型：1-主扇；2-局扇")
    private String fanType;

    /** 风机名称 */
    @Excel(name = "风机名称")
    private String name;

    /** 整体/主机/备机 0/1/2 */
    @Excel(name = "整体/主机/备机 0/1/2")
    private String devAs;

    /** 整体/一级电机/二级电机 0/1/2 */
    @Excel(name = "整体/一级电机/二级电机 0/1/2")
    private String electricMachine;

    /** 属性名称 */
    @Excel(name = "属性名称")
    private String propertyName;

    /** 属性编码 */
    @Excel(name = "属性编码")
    private String propertyCode;

    /** 属性值 */
    @Excel(name = "属性值")
    private String propertyValue;

    /** 属性类型 */
    @Excel(name = "属性类型")
    private String propertyType;

    /** 属性单位 */
    @Excel(name = "属性单位")
    private String propertyUnit;

    /** 排序列 */
    @Excel(name = "排序列")
    private Integer orderNum;

    /** 是否显示 0显示 1不显示 */
    @Excel(name = "是否显示 0显示 1不显示")
    private String showFlag;

    private Date reportTime;

    /** 创建人 */
    private String createBy;

    /** 创建时间 */
    private Date createTime;

    /** 修改人 */
    private String updateBy;

    /** 修改时间 */
    private Date updateTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
