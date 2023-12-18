package com.ruoyi.project.api.winddevice.fan.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FanAdjustBody {

    @NotBlank(message = "风机的id不能为空")
    private String devId;

    private String controlType;

    private String controlValue;
}
