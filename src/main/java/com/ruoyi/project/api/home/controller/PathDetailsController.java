package com.ruoyi.project.api.home.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ruoyi.project.api.home.domain.PathDetails;
import com.ruoyi.project.api.home.service.IPathDetailsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 巡检路线详情Controller
 *
 * @author ruoyi
 * @date 2023-08-11
 */
@AllArgsConstructor
@RestController
@RequestMapping("/home/details" )
public class PathDetailsController extends BaseController {

    private final IPathDetailsService iPathDetailsService;

    /**
     * 查询巡检路线详情列表
     */
    @PreAuthorize("@ss.hasPermi('home:details:list')")
    @GetMapping("/list")
    public TableDataInfo list(PathDetails pathDetails)
    {
        startPage();
        LambdaQueryWrapper<PathDetails> lqw = new LambdaQueryWrapper<PathDetails>();
        if (pathDetails.getDevId() != null){
            lqw.eq(PathDetails::getDevId ,pathDetails.getDevId());
        }
        if (pathDetails.getDevName() != null){
            lqw.like(PathDetails::getDevName ,pathDetails.getDevName());
        }
        if (StringUtils.isNotBlank(pathDetails.getDevLocation())){
            lqw.eq(PathDetails::getDevLocation ,pathDetails.getDevLocation());
        }
        if (StringUtils.isNotBlank(pathDetails.getDevType())){
            lqw.eq(PathDetails::getDevType ,pathDetails.getDevType());
        }
        if (pathDetails.getOrderNum() != null){
            lqw.eq(PathDetails::getOrderNum ,pathDetails.getOrderNum());
        }
        List<PathDetails> list = iPathDetailsService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出巡检路线详情列表
     */
    @PreAuthorize("@ss.hasPermi('home:details:export')" )
    @Log(title = "巡检路线详情" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(PathDetails pathDetails) {
        LambdaQueryWrapper<PathDetails> lqw = new LambdaQueryWrapper<PathDetails>(pathDetails);
        List<PathDetails> list = iPathDetailsService.list(lqw);
        ExcelUtil<PathDetails> util = new ExcelUtil<PathDetails>(PathDetails. class);
        return util.exportExcel(list, "details" );
    }

    /**
     * 获取巡检路线详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('home:details:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(iPathDetailsService.getById(id));
    }

    /**
     * 新增巡检路线详情
     */
    @PreAuthorize("@ss.hasPermi('home:details:add')" )
    @Log(title = "巡检路线详情" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PathDetails pathDetails) {
        return toAjax(iPathDetailsService.save(pathDetails) ? 1 : 0);
    }

    /**
     * 修改巡检路线详情
     */
    @PreAuthorize("@ss.hasPermi('home:details:edit')" )
    @Log(title = "巡检路线详情" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PathDetails pathDetails) {
        return toAjax(iPathDetailsService.updateById(pathDetails) ? 1 : 0);
    }

    /**
     * 删除巡检路线详情
     */
    @PreAuthorize("@ss.hasPermi('home:details:remove')" )
    @Log(title = "巡检路线详情" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iPathDetailsService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
