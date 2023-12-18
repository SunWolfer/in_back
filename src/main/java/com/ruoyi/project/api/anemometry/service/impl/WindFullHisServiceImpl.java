package com.ruoyi.project.api.anemometry.service.impl;

import com.ruoyi.project.api.anemometry.domain.WindFull;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.api.anemometry.mapper.WindFullHisMapper;
import com.ruoyi.project.api.anemometry.domain.WindFullHis;
import com.ruoyi.project.api.anemometry.service.IWindFullHisService;

import java.util.List;

/**
 * 测风站测风记录Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-05
 */
@Service
public class WindFullHisServiceImpl extends ServiceImpl<WindFullHisMapper, WindFullHis> implements IWindFullHisService {

    @Override
    public List<WindFullHis> findTopList(List<WindFull> windFullList) {
        return baseMapper.findTopList(windFullList);
    }
}
