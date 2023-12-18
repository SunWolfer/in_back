package com.ruoyi.project.network.model;

import lombok.Data;

@Data
public class WindowGetConfigVo {

    private Integer addressNumberFlag;
    private Integer serverIpPortFlag;
    private Integer getIpWayFlag;
    private Integer controllerIpFlag;

    private Integer heatBeatPeriodFlag;
    private Integer reportPeriodFlag;
    private Integer timeOutFlag;
    private Integer controlTimeFlag;

    private Integer controlErrorFlag;
    private Integer workModeA;
    private Integer controlTypeA;
    private Integer controlTargetA;

    private Integer openDegreeTargetA;
    private Integer workModeB;
    private Integer controlTypeB;
    private Integer controlTargetB;

    private Integer openDegreeTargetB;
    private Integer configDoFlag;
    private Integer configDiFlag;
    private Integer configAiFlag;

    private Integer configRs485Flag;

    public WindowGetConfigVo() {
    }

    public WindowGetConfigVo(boolean allRead) {
        if(allRead){//true 都读取
            this.addressNumberFlag = 1;
            this.serverIpPortFlag = 1;
            this.getIpWayFlag = 1;
            this.controllerIpFlag = 1;
            this.heatBeatPeriodFlag = 1;
            this.reportPeriodFlag = 1;
            this.timeOutFlag = 1;
            this.controlTimeFlag = 1;
            this.controlErrorFlag = 1;
            this.workModeA = 1;
            this.controlTypeA = 1;
            this.controlTargetA = 1;
            this.openDegreeTargetA = 1;
            this.workModeB = 1;
            this.controlTypeB = 1;
            this.controlTargetB = 1;
            this.openDegreeTargetB = 1;
            this.configDoFlag = 1;
            this.configDiFlag = 1;
            this.configAiFlag = 1;
            this.configRs485Flag = 1;
        } else {//false 都不读取
            this.addressNumberFlag = 0;
            this.serverIpPortFlag = 0;
            this.getIpWayFlag = 0;
            this.controllerIpFlag = 0;
            this.heatBeatPeriodFlag = 0;
            this.reportPeriodFlag = 0;
            this.timeOutFlag = 0;
            this.controlTimeFlag = 0;
            this.controlErrorFlag = 0;
            this.workModeA = 0;
            this.controlTypeA = 0;
            this.controlTargetA = 0;
            this.openDegreeTargetA = 0;
            this.workModeB = 0;
            this.controlTypeB = 0;
            this.controlTargetB = 0;
            this.openDegreeTargetB = 0;
            this.configDoFlag = 0;
            this.configDiFlag = 0;
            this.configAiFlag = 0;
            this.configRs485Flag = 0;
        }

    }
}
