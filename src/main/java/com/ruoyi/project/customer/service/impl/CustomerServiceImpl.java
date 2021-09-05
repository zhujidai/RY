package com.ruoyi.project.customer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.customer.mapper.CustomerMapper;
import com.ruoyi.project.customer.domain.Customer;
import com.ruoyi.project.customer.service.ICustomerService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 客户信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-11
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询客户信息管理
     * 
     * @param id 客户信息管理ID
     * @return 客户信息管理
     */
    @Override
    public Customer selectCustomerById(String id)
    {
        return customerMapper.selectCustomerById(id);
    }

    /**
     * 查询客户信息管理列表
     * 
     * @param customer 客户信息管理
     * @return 客户信息管理
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }


    /**
     * 新增客户信息管理
     * 
     * @param customer 客户信息管理
     * @return 结果
     */
    @Override
    public int insertCustomer(Customer customer)
    {
        return customerMapper.insertCustomer(customer);
    }

    /**
     * 修改客户信息管理
     * 
     * @param customer 客户信息管理
     * @return 结果
     */
    @Override
    public int updateCustomer(Customer customer)
    {
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 删除客户信息管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCustomerByIds(String ids)
    {
        return customerMapper.deleteCustomerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户信息管理信息
     * 
     * @param id 客户信息管理ID
     * @return 结果
     */
//    @Override
//    public int deleteCustomerById(String id)
//    {
//        return customerMapper.deleteCustomerById(id);
//    }

    @Override
    public String getQvName(String qvId) {
        return customerMapper.getQvName(qvId);
    }

    @Override
    public String getSexValue(String sex) {
        return customerMapper.getSexValue(sex);
    }

    @Override
    public String getIntentionVal(String intention) {
        return customerMapper.getIntentionVal(intention);
    }

    @Override
    public String getCourseVal(String courseId) {
        return customerMapper.getCourseVal(courseId);
    }

    @Override
    public String getSourceVal(String sourceId) {
        return customerMapper.getSourceVal(sourceId);
    }

}
