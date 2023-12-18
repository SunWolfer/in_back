package com.ruoyi.project.api.winddevice.window.newversion.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.api.winddevice.window.newversion.service.IWindowCurveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 风窗曲线表
 */
@RestController
@RequestMapping("/api/window/curve")
public class WindowCurveController extends BaseController {
    @Autowired
    private IWindowCurveService windowCurveService;




}
