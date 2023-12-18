package com.ruoyi.project.network.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class DirectAdjustWindowOrder {

    private String requestIp;
    private String requestSn;

    private String controlTypeA;
    private Float controlTargetA;
    private Integer openDegreeTargetA;

    private String controlTypeB;
    private Float controlTargetB;
    private Integer openDegreeTargetB;

}
