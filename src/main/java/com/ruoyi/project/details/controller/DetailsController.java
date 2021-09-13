package com.ruoyi.project.details.controller;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.details.domain.Details;
import com.ruoyi.project.details.service.IDetailsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2021-07-25
 */
@Controller
@RequestMapping("/system/details")
public class DetailsController extends BaseController {
    private String prefix = "system/details";

    @Autowired
    private IDetailsService detailsService;

    @RequiresPermissions("system:details:view")
    @GetMapping()
    public String details() {
        return prefix + "/details";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:details:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String customerId) {
        startPage();
        List<Map<String,String>> list = detailsService.selectDetailsList(customerId);
        System.out.println("list = " + list);
        return getDataTable(list);
    }

    /**
     * 查询字典详细
     */
    @RequiresPermissions("system:details:list")
    @GetMapping("/details/{customerId}")
    public String detail(@PathVariable("customerId") String customerId, ModelMap mmap) {
//        List<Map<String,String>> details = detailsService.selectDetailsByCustId(customerId);
//        System.out.println(details);
        mmap.put("customerId", customerId);
        return "system/details/details";
    }

    /**
     * 导出【请填写功能名称】列表
     */
//    @RequiresPermissions("system:details:export")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(Details details) {
//        User user = ShiroUtils.getSysUser();
//        if (user != null && !"admin".equals(user.getLoginName())) {
//            details.setUserId(user.getUserId());
//        }
//        List<Details> list = detailsService.selectDetailsList(details);
//        ExcelUtil<Details> util = new ExcelUtil<Details>(Details.class);
//        return util.exportExcel(list, "【请填写功能名称】数据");
//    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:details:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Details details) {
        return toAjax(detailsService.insertDetails(details));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Details details = detailsService.selectDetailsById(id);
        mmap.put("details", details);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:details:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Details details) {
        return toAjax(detailsService.updateDetails(details));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:details:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(detailsService.deleteDetailsByIds(ids));
    }
}
