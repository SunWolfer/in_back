package com.ruoyi.project.api.anemometry.mapper;

import com.ruoyi.project.api.anemometry.domain.WindFull;
import com.ruoyi.project.api.anemometry.domain.WindFullHis;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 测风站测风记录Mapper接口
 *
 * @author ruoyi
 * @date 2023-08-05
 */
public interface WindFullHisMapper extends BaseMapper<WindFullHis> {
    List<WindFullHis> findTopList(List<WindFull> windFullList);
}
