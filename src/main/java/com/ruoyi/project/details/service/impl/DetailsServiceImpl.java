package com.ruoyi.project.details.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.details.mapper.DetailsMapper;
import com.ruoyi.project.details.domain.Details;
import com.ruoyi.project.details.service.IDetailsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2021-07-25
 */
@Service
public class DetailsServiceImpl implements IDetailsService {

    @Autowired
    private DetailsMapper detailsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Details selectDetailsById(String id) {
        return detailsMapper.selectDetailsById(id);
    }

//    /**
//     * 查询【请填写功能名称】列表
//     *
//     * @param details 【请填写功能名称】
//     * @return 【请填写功能名称】
//     */
    @Override
    public List<Map<String,String>> selectDetailsList(String customerId) {
        return detailsMapper.selectDetailsList(customerId);
    }

//    public List<Details> selectDetailsList(String customerId) {
//        return detailsMapper.selectDetailsList(customerId);
//    }

    /**
     * 新增【请填写功能名称】
     *
     * @param details 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertDetails(Details details) {
        return detailsMapper.insertDetails(details);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param details 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateDetails(Details details) {
        return detailsMapper.updateDetails(details);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDetailsByIds(String ids) {
        return detailsMapper.deleteDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteDetailsById(String id) {
        return detailsMapper.deleteDetailsById(id);
    }

    @Override
    public List<Map<String,String>> selectDetailsByCustId(String customerId) {
        return detailsMapper.selectDetailsByCustId(customerId);
    }
}
