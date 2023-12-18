package com.ruoyi.project.api.winddevice.window.newversion.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WindowRefactoryBody {

    @NotBlank(message = "风窗控制器IP不能为空")
    private String ip;

    @NotBlank(message = "风窗A/B类型不能为空")
    private String abTag;
}
