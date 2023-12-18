package com.ruoyi.project.api.winddevice.window.newversion.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WindowAdjustBody {

    @NotBlank(message = "风窗的id不能为空")
    private String devId;

    private String controlType;

    private String controlValue;

    private boolean ldFlag;

    public boolean getLdFlag() {
        return ldFlag;
    }

    public void setLdFlag(boolean ldFlag) {
        this.ldFlag = ldFlag;
    }
}
