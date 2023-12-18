package com.ruoyi.project.api.anemometry.service.impl;

import com.ruoyi.project.api.anemometry.domain.WindSensor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.api.anemometry.mapper.WindSensorHisMapper;
import com.ruoyi.project.api.anemometry.domain.WindSensorHis;
import com.ruoyi.project.api.anemometry.service.IWindSensorHisService;

import java.util.List;

/**
 * 超声波精准测风历史Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-04
 */
@Service
public class WindSensorHisServiceImpl extends ServiceImpl<WindSensorHisMapper, WindSensorHis> implements IWindSensorHisService {

    @Override
    public List<WindSensorHis> findTopList(List<WindSensor> windSensorList) {
        return baseMapper.findTopList(windSensorList);
    }
}
