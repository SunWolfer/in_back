package com.ruoyi.project.api.winddevice.window.newversion.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.api.winddevice.window.newversion.domain.WindowOperEntity;
import com.ruoyi.project.api.winddevice.window.newversion.service.IWindowOperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * 风窗操作记录表
 */
@RestController
@RequestMapping("/api/window/oper")
public class WindowOperController extends BaseController {
    @Autowired
    private IWindowOperService windowOperService;

    /**
     * 风窗操作记录列表页
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo list(WindowOperEntity windowOperEntity){

        startPage();
        LambdaQueryWrapper<WindowOperEntity> lqw = new LambdaQueryWrapper();

        lqw.like(StringUtils.isNotBlank(windowOperEntity.getDevName()), WindowOperEntity::getDevName, windowOperEntity.getDevName());

        Date beginTime = windowOperEntity.getBeginTime();
        Date endTime = windowOperEntity.getEndTime();

        if(beginTime!=null){
            lqw.ge(WindowOperEntity::getTimeMs, beginTime.getTime());
        }
        if(endTime!=null){
            lqw.le(WindowOperEntity::getTimeMs, endTime.getTime());
        }

        lqw.orderByDesc(WindowOperEntity::getTimeMs);

        List<WindowOperEntity> list = windowOperService.list(lqw);
        return getDataTable(list);
    }

}
