package com.ruoyi.project.api.winddevice.window.newversion.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.project.api.winddevice.window.newversion.domain.WindowConfigYwEntity;

/**
 * 风窗配置业务表
 */
public interface WindowConfigYwMapper extends BaseMapper<WindowConfigYwEntity> {

    int updateConfigYw(WindowConfigYwEntity windowConfigYwEntity);
}
