package com.ruoyi.project.api.winddevice.window.newversion.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.api.winddevice.window.newversion.domain.WindowWarnEntity;
import com.ruoyi.project.api.winddevice.window.newversion.service.IWindowWarnService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * 风窗预警表
 */
@RestController
@RequestMapping("/api/window/warn")
public class WindowWarnController extends BaseController {
    @Autowired
    private IWindowWarnService windowWarnService;

    /**
     * 风窗操作记录列表页
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo list(WindowWarnEntity windowWarnEntity){

        startPage();
        LambdaQueryWrapper<WindowWarnEntity> lqw = new LambdaQueryWrapper();

        lqw.like(StringUtils.isNotBlank(windowWarnEntity.getDevName()), WindowWarnEntity::getDevName, windowWarnEntity.getDevName());
        lqw.like(StringUtils.isNotBlank(windowWarnEntity.getYjmc()), WindowWarnEntity::getYjmc, windowWarnEntity.getYjmc());

        lqw.eq(windowWarnEntity.getDevId()!=null, WindowWarnEntity::getDevId, windowWarnEntity.getDevId());

        Date beginTime = windowWarnEntity.getBeginTime();
        Date endTime = windowWarnEntity.getEndTime();

        if(beginTime!=null){
            lqw.ge(WindowWarnEntity::getTimeMs, beginTime.getTime());
        }
        if(endTime!=null){
            lqw.le(WindowWarnEntity::getTimeMs, endTime.getTime());
        }

        lqw.orderByDesc(WindowWarnEntity::getTimeMs);

        List<WindowWarnEntity> list = windowWarnService.list(lqw);
        return getDataTable(list);
    }
}
