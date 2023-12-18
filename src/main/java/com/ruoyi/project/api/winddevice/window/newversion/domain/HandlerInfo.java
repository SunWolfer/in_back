package com.ruoyi.project.api.winddevice.window.newversion.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 传感器数据处理类对象 t_handler_info
 *
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_handler_info")
public class HandlerInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /** 主键ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 命令码 */
    private String orderType;

    /** 数据处理对应handler */
    private String handlerType;

    /** 控制的设备类型 */
    private String controlType;

    /*默认0 是否启用 0为启用 1为不启用*/
    private String status;


}
