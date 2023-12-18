package com.ruoyi.project.api.winddevice.window.newversion.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.project.api.winddevice.window.newversion.domain.WindowInfoEntity;

import java.util.List;

/**
 * 风窗基本信息
 */
public interface WindowInfoMapper extends BaseMapper<WindowInfoEntity> {

    List<WindowInfoEntity> findIpLocation();

    int updateWindowInfo(WindowInfoEntity windowInfoEntity);

}
