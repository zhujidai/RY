package com.ruoyi.project.customer.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customer.domain.Customer;
import com.ruoyi.project.customer.service.ICustomerService;
import com.ruoyi.project.details.domain.Details;
import com.ruoyi.project.details.service.IDetailsService;
import com.ruoyi.project.system.role.domain.Role;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 客户信息管理Controller
 *
 * @author ruoyi
 * @date 2021-07-11
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
    private String prefix = "customer";

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IDetailsService detailsService;

    @RequiresPermissions("customer:view")
    @GetMapping()
    public String custInfo() {
        return prefix+"/custInfo";
    }

    /**
     * 查询客户信息管理列表
     */
    @RequiresPermissions("customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Customer customer) {
        startPage();
        User sysUser = ShiroUtils.getSysUser();
        Long userId = sysUser.getUserId();
        List<Role> roleLst = sysUser.getRoles();
        if (roleLst != null && roleLst.size() > 0) {
            for (Role role : roleLst) {
                if (role.getRoleId() == 1) {
                    userId = null;
                }
            }
        }
        // TODO
        customer.setUserId(userId);
         List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    /**
     * 导出客户信息管理列表
     */
    @RequiresPermissions("customer:export")
    @Log(title = "客户信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Customer customer) {
        List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "客户信息管理数据");
    }

    /**
     * 新增客户信息管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存客户信息管理
     */
    @RequiresPermissions("customer:add")
    @Log(title = "客户信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Customer customer) {
        customer.setId(UUID.randomUUID().toString().replace("-", ""));
        String intention = customer.getIntention();
        Calendar nextVisit = Calendar.getInstance();
        if ("0".equals(intention)) {
            nextVisit.add(Calendar.DATE, 2);
        }else if ("1".equals(intention)) {
            nextVisit.add(Calendar.DATE, 4);
        } else if ("2".equals(intention)) {
            nextVisit.add(Calendar.DATE, 7);
        } else if ("3".equals(intention)) {
            nextVisit.add(Calendar.DATE, 15);
        }
        customer.setNextDate(nextVisit.getTime());
        Date today = new Date();
        customer.setVisitDate(today);
        customer.setAddDate(today);

        customer.setCounter(0L);

        String address = "";
        if (StringUtils.isNotEmpty(customer.getQv())) {
            address = customerService.getQvName(customer.getQv());
        }
        if (StringUtils.isNotEmpty(customer.getOaddress())) {
            customer.setAddress(address + "," + customer.getOaddress());
        }

        User user = ShiroUtils.getSysUser();
        customer.setUserId(user.getUserId());


        Details details = new Details();
        details.setId(UUID.randomUUID().toString().replace("-", ""));
        details.setCustomerId(customer.getId());
        details.setPhone(customer.getPhone());
        details.setSex(customerService.getSexValue(customer.getSex()));
        details.setIntentionId(customer.getIntention());
        details.setIntentionName(customerService.getIntentionVal(customer.getIntention()));
        details.setPrepay(customer.getPrepay());
        details.setCustomerId(customer.getCourseId());
        details.setCourseId(customerService.getCourseVal(customer.getCourseId()));
        details.setAddress(customer.getAddress());
        details.setAddDate(today);
        details.setUserId(user.getUserId());
        details.setUserName(user.getLoginName());

        details.setCourseName(customer.getCourseId());
        details.setSourceId(customer.getSourceId());
        details.setSourceName(customerService.getSourceVal(customer.getSourceId()));


        details.setCustomerName(customer.getName());
        details.setPrepay(customer.getPrepay());
        details.setRemark(customer.getRemark());
        detailsService.insertDetails(details);

        return toAjax(customerService.insertCustomer(customer));
    }

    /**
     * 修改客户信息管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap, HttpServletRequest request,ServletResponse response) {

        Customer customer = customerService.selectCustomerById(id);
        User user = ShiroUtils.getSysUser();
        if (user != null) {
            customer.setUserName(user.getUserName());
        }
        mmap.put("customer", customer);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户信息管理
     */
    @RequiresPermissions("customer:edit")
    @Log(title = "客户信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Customer customer) {
        return toAjax(customerService.updateCustomer(customer));
    }

    /**
     * 删除客户信息管理
     */
    @RequiresPermissions("customer:remove")
    @Log(title = "客户信息管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(customerService.deleteCustomerByIds(ids));
    }
}
