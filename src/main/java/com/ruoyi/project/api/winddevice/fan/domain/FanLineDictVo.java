package com.ruoyi.project.api.winddevice.fan.domain;

import lombok.Data;

import java.util.List;

@Data
public class FanLineDictVo {
    private String zhuansu;
    private List<String> children;
}
