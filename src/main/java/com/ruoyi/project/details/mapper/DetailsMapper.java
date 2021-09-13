package com.ruoyi.project.details.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.details.domain.Details;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2021-07-25
 */
public interface DetailsMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Details selectDetailsById(String id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param details 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Map<String,String>> selectDetailsList(String customerId);
//    public List<Details> selectDetailsList(String customerId);

    /**
     * 新增【请填写功能名称】
     *
     * @param details 【请填写功能名称】
     * @return 结果
     */
    public int insertDetails(Details details);

    /**
     * 修改【请填写功能名称】
     *
     * @param details 【请填写功能名称】
     * @return 结果
     */
    public int updateDetails(Details details);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteDetailsById(String id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDetailsByIds(String[] ids);

    public List<Map<String,String>> selectDetailsByCustId(String customerId);
}
