package com.ruoyi.project.api.winddevice.window.newversion.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WindowTestWarnBody {

    @NotBlank(message = "风窗控制器IP不能为空")
    private String ip;

    @NotBlank(message = "报警时间不能为空")
    private String warnTime;
}
