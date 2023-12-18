package com.ruoyi.project.api.anemometry.mapper;

import com.ruoyi.project.api.anemometry.domain.WindSensor;
import com.ruoyi.project.api.anemometry.domain.WindSensorHis;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 超声波精准测风历史Mapper接口
 *
 * @author ruoyi
 * @date 2023-08-04
 */
public interface WindSensorHisMapper extends BaseMapper<WindSensorHis> {
    List<WindSensorHis> findTopList(List<WindSensor> windSensorList);
}
