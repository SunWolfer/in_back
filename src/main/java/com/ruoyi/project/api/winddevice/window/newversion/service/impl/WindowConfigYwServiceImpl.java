package com.ruoyi.project.api.winddevice.window.newversion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.api.winddevice.window.newversion.domain.WindowConfigYwEntity;
import com.ruoyi.project.api.winddevice.window.newversion.mapper.WindowConfigYwMapper;
import com.ruoyi.project.api.winddevice.window.newversion.service.IWindowConfigYwService;
import org.springframework.stereotype.Service;

@Service
public class WindowConfigYwServiceImpl extends ServiceImpl<WindowConfigYwMapper, WindowConfigYwEntity> implements IWindowConfigYwService {


    @Override
    public int updateConfigYw(WindowConfigYwEntity windowConfigYwEntity) {
        return baseMapper.updateConfigYw(windowConfigYwEntity);
    }
}
