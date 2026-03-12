package com.zygj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.zygj.hotel.domain.Space;
import com.zygj.hotel.domain.query.SpaceQuery;
import com.zygj.hotel.domain.vo.SpaceBuildingVo;
import com.zygj.hotel.domain.vo.SpaceVo;

/**
 * 空间调整Service接口
 * 
 * @author Duke
 * @date 2026-03-12
 */
public interface ISpaceService extends IService<Space>
{
    /**
     * 查询空间调整
     * 
     * @param id 空间调整主键
     * @return 空间调整
     */
    public Space selectSpaceById(Long id);

    /**
     * 查询空间调整列表
     *
     * @param spaceQuery 空间调整查询参数
     * @return 空间调整集合
     */
    public List<SpaceVo> selectSpaceList(SpaceQuery spaceQuery);

    /**
     * 新增空间调整
     * 
     * @param space 空间调整
     * @return 结果
     */
    public int insertSpace(Space space);

    /**
     * 修改空间调整
     * 
     * @param space 空间调整
     * @return 结果
     */
    public int updateSpace(Space space);

    /**
     * 批量删除空间调整
     * 
     * @param ids 需要删除的空间调整主键集合
     * @return 结果
     */
    public int deleteSpaceByIds(Long[] ids);

    /**
     * 删除空间调整信息
     * 
     * @param id 空间调整主键
     * @return 结果
     */
    public int deleteSpaceById(Long id);

    /**
     * 获取所有楼栋
     * @return 楼栋集合
     */
    List<SpaceBuildingVo> getAllBuilding();

}
