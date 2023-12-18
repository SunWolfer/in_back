package com.ruoyi.project.api.disaster.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.api.disaster.domain.EscapePath;
import com.ruoyi.project.api.disaster.service.IEscapePathService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 系统避灾路线Controller
 *
 * @author ruoyi
 * @date 2023-08-18
 */
@AllArgsConstructor
@RestController
@RequestMapping("/calculate/path" )
public class EscapePathController extends BaseController {

    private final IEscapePathService iEscapePathService;

    /**
     * 查询系统避灾路线列表
     */
    @PreAuthorize("@ss.hasPermi('calculate:path:list')")
    @GetMapping("/list")
    public TableDataInfo list(EscapePath escapePath)
    {
        startPage();
        LambdaQueryWrapper<EscapePath> lqw = new LambdaQueryWrapper<EscapePath>();
        if (StringUtils.isNotBlank(escapePath.getStartNode())){
            lqw.eq(EscapePath::getStartNode ,escapePath.getStartNode());
        }
        if (StringUtils.isNotBlank(escapePath.getEndNode())){
            lqw.eq(EscapePath::getEndNode ,escapePath.getEndNode());
        }
        if (StringUtils.isNotBlank(escapePath.getName())){
            lqw.like(EscapePath::getName ,escapePath.getName());
        }
        if (StringUtils.isNotBlank(escapePath.getRouteDesc())){
            lqw.eq(EscapePath::getRouteDesc ,escapePath.getRouteDesc());
        }
        if (StringUtils.isNotBlank(escapePath.getVal1())){
            lqw.eq(EscapePath::getVal1 ,escapePath.getVal1());
        }
        List<EscapePath> list = iEscapePathService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出系统避灾路线列表
     */
    @PreAuthorize("@ss.hasPermi('calculate:path:export')" )
    @Log(title = "系统避灾路线" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(EscapePath escapePath) {
        LambdaQueryWrapper<EscapePath> lqw = new LambdaQueryWrapper<EscapePath>(escapePath);
        List<EscapePath> list = iEscapePathService.list(lqw);
        ExcelUtil<EscapePath> util = new ExcelUtil<EscapePath>(EscapePath. class);
        return util.exportExcel(list, "path" );
    }

    /**
     * 获取系统避灾路线详细信息
     */
    @PreAuthorize("@ss.hasPermi('calculate:path:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(iEscapePathService.getById(id));
    }

    /**
     * 新增系统避灾路线
     */
    @PreAuthorize("@ss.hasPermi('calculate:path:add')" )
    @Log(title = "系统避灾路线" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EscapePath escapePath) {
        return toAjax(iEscapePathService.save(escapePath) ? 1 : 0);
    }

    /**
     * 修改系统避灾路线
     */
    @PreAuthorize("@ss.hasPermi('calculate:path:edit')" )
    @Log(title = "系统避灾路线" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EscapePath escapePath) {
        return toAjax(iEscapePathService.updateById(escapePath) ? 1 : 0);
    }

    /**
     * 删除系统避灾路线
     */
    @PreAuthorize("@ss.hasPermi('calculate:path:remove')" )
    @Log(title = "系统避灾路线" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iEscapePathService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
