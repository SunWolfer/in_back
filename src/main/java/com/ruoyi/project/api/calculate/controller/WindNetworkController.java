package com.ruoyi.project.api.calculate.controller;

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
import com.ruoyi.project.api.calculate.domain.WindNetwork;
import com.ruoyi.project.api.calculate.service.IWindNetworkService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 巷道通风网络图记录Controller
 *
 * @author ruoyi
 * @date 2023-08-16
 */
@AllArgsConstructor
@RestController
@RequestMapping("/calculate/network" )
public class WindNetworkController extends BaseController {

    private final IWindNetworkService iWindNetworkService;

    /**
     * 查询巷道通风网络图记录列表
     */
    @PreAuthorize("@ss.hasPermi('calculate:network:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindNetwork windNetwork)
    {
        startPage();
        LambdaQueryWrapper<WindNetwork> lqw = new LambdaQueryWrapper<WindNetwork>();
        if (StringUtils.isNotBlank(windNetwork.getInfo())){
            lqw.eq(WindNetwork::getInfo ,windNetwork.getInfo());
        }
        List<WindNetwork> list = iWindNetworkService.list(lqw);
        return getDataTable(list);
    }

    /**
     * 导出巷道通风网络图记录列表
     */
    @PreAuthorize("@ss.hasPermi('calculate:network:export')" )
    @Log(title = "巷道通风网络图记录" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(WindNetwork windNetwork) {
        LambdaQueryWrapper<WindNetwork> lqw = new LambdaQueryWrapper<WindNetwork>(windNetwork);
        List<WindNetwork> list = iWindNetworkService.list(lqw);
        ExcelUtil<WindNetwork> util = new ExcelUtil<WindNetwork>(WindNetwork. class);
        return util.exportExcel(list, "network" );
    }

    /**
     * 获取巷道通风网络图记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('calculate:network:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(iWindNetworkService.getById(id));
    }

    /**
     * 新增巷道通风网络图记录
     */
    @PreAuthorize("@ss.hasPermi('calculate:network:add')" )
    @Log(title = "巷道通风网络图记录" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindNetwork windNetwork) {
        return toAjax(iWindNetworkService.save(windNetwork) ? 1 : 0);
    }

    /**
     * 修改巷道通风网络图记录
     */
    @PreAuthorize("@ss.hasPermi('calculate:network:edit')" )
    @Log(title = "巷道通风网络图记录" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindNetwork windNetwork) {
        return toAjax(iWindNetworkService.updateById(windNetwork) ? 1 : 0);
    }

    /**
     * 删除巷道通风网络图记录
     */
    @PreAuthorize("@ss.hasPermi('calculate:network:remove')" )
    @Log(title = "巷道通风网络图记录" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iWindNetworkService.removeByIds(Arrays.asList(ids)) ? 1 : 0);
    }
}
