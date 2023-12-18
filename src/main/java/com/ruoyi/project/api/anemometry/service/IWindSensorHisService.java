package com.ruoyi.project.api.anemometry.service;

import com.ruoyi.project.api.anemometry.domain.WindSensor;
import com.ruoyi.project.api.anemometry.domain.WindSensorHis;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 超声波精准测风历史Service接口
 *
 * @author ruoyi
 * @date 2023-08-04
 */
public interface IWindSensorHisService extends IService<WindSensorHis> {
    List<WindSensorHis> findTopList(List<WindSensor> windSensorList);
}
