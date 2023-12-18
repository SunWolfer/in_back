package com.ruoyi.project.api.calculate.domain;

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
 * 巷道通风网络图记录对象 tb_wind_network
 * 
 * @author ruoyi
 * @date 2023-08-16
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_wind_network")
public class WindNetwork implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String w;
    private String h;
    private String dx;
    private String dy;

    /** 生成的通风网络图 */
    @Excel(name = "生成的通风网络图")
    private String info;

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
