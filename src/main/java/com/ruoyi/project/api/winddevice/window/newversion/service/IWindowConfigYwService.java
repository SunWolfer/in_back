package com.ruoyi.project.api.winddevice.window.newversion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.api.winddevice.window.newversion.domain.WindowConfigYwEntity;

/**
 * 风窗预警 业务层
 * 
 */
public interface IWindowConfigYwService extends IService<WindowConfigYwEntity>
{

    int updateConfigYw(WindowConfigYwEntity windowConfigYwEntity);

}
