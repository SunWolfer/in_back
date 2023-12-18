package com.ruoyi.project.api.disaster.domain;

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
 * 系统避灾路线对象 tb_escape_path
 * 
 * @author ruoyi
 * @date 2023-08-18
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_escape_path")
public class EscapePath implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 起始节点 */
    @Excel(name = "起始节点")
    private String startNode;

    /** 结束节点 */
    @Excel(name = "结束节点")
    private String endNode;

    /** 巷道编号 */
    @Excel(name = "巷道编号")
    private String node;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String name;

    /** 撤退描述 */
    @Excel(name = "撤退描述")
    private String routeDesc;

    /** 区域坐标 */
    @Excel(name = "区域坐标")
    private String val1;
}
