package com.ruoyi.project.api.anemometry.service;

import com.ruoyi.project.api.anemometry.domain.WindFull;
import com.ruoyi.project.api.anemometry.domain.WindFullHis;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 测风站测风记录Service接口
 *
 * @author ruoyi
 * @date 2023-08-05
 */
public interface IWindFullHisService extends IService<WindFullHis> {
    List<WindFullHis> findTopList(List<WindFull> windFullList);
}
