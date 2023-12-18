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
 * 风机特性曲线对象 tb_fan_line
 * 
 * @author ruoyi
 * @date 2023-08-09
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_fan_line")
public class FanLine implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 风机id */
    @Excel(name = "风机id")
    private Long devId;

    /** 风量 */
    @Excel(name = "风量")
    private Double fengliang;

    /** 效率 */
    @Excel(name = "效率")
    private Double xiaolv;

    /** 功率 */
    @Excel(name = "功率")
    private Double gonglv;

    /** 叶片角度 */
    @Excel(name = "叶片角度")
    private String jiaodu;

    /** 全压 */
    @Excel(name = "全压")
    private Double quanya;

    /** 通风阻力 */
    @Excel(name = "通风阻力")
    private Double tongfengzuli;

    /** 风机转速 */
    @Excel(name = "风机转速")
    private Integer zhuansu;

    /** 备用字段1 */
    @Excel(name = "备用字段1")
    private String var1;

    /** 备用字段2 */
    @Excel(name = "备用字段2")
    private String var2;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
