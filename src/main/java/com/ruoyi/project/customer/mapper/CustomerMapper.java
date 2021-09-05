package com.ruoyi.project.customer.mapper;

import java.util.List;
import com.ruoyi.project.customer.domain.Customer;

/**
 * 客户信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-11
 */
public interface CustomerMapper 
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
    public List<Customer> selectCustomerList(Customer customer);

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
//    public int updateCustomer(Customer customer);

    /**
     * 删除客户信息管理
     * 
     * @param id 客户信息管理ID
     * @return 结果
     */
    public int deleteCustomerById(String id);

    /**
     * 批量删除客户信息管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerByIds(String[] ids);

    public String getQvName(String qvId);

    public String getSexValue(String sex);

    public String getIntentionVal(String intention);

    public String getCourseVal(String courseId);

    public String getSourceVal(String sourceId);

    public List<Customer> selectCustomerList(Long userId);

    public int updateCustomer(Customer customer);
}
