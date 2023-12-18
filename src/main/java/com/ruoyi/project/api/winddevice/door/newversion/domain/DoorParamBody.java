package com.ruoyi.project.api.winddevice.door.newversion.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DoorParamBody {

    @NotBlank(message = "风窗的id不能为空")
    private String devId;

    private String paramType;

    private String paramValue;

}
