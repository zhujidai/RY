package com.ruoyi.project.customer.service;

import com.ruoyi.project.customer.domain.Customer;

import java.util.List;

/**
 * 客户信息管理Service接口
 * 
 * @author ruoyi
 * @date 2021-07-11
 */
public interface ICustomerService 
{
    /**
     * 查询客户信息管理
     * 
     * @param id 客户信息管理ID
     * @return 客户信息管理
     */
    public Customer selectCustomerById(String id);

    /**
     * 查询客户信息管理列表
     * 
     * @param customer 客户信息管理
     * @return 客户信息管理集合
     */
//    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增客户信息管理
     * 
     * @param customer 客户信息管理
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改客户信息管理
     * 
     * @param customer 客户信息管理
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 批量删除客户信息管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerByIds(String ids);

    /**
     * 删除客户信息管理信息
     * 
     * @param id 客户信息管理ID
     * @return 结果
     */
//    public int deleteCustomerById(String id);

    public String getQvName(String shi);

    public String getSexValue(String sex);

    public String getIntentionVal(String intention);

    public String getCourseVal(String courseId);

    public String getSourceVal(String sourceId);

    public List<Customer> selectCustomerList(Customer customer);
}
