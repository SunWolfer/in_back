package com.ruoyi.project.api.winddevice.window.newversion.domain;

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
 * 风窗风阻对象 tb_window_ventr
 * 
 * @author ruoyi
 * @date 2023-08-05
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_window_ventr")
public class WindowVentr implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 风窗id */
    @Excel(name = "风窗id")
    private Long devId;

    /** 风窗开度 */
    @Excel(name = "风窗开度")
    private String kaidu;

    /** 通风面积 */
    @Excel(name = "通风面积")
    private String mianji;

    /** 风阻 */
    @Excel(name = "风阻")
    private String fengzu;

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
