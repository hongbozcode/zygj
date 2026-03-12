package com.zygj.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zygj.hotel.domain.vo.SpaceBuildingVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.zygj.hotel.domain.Space;
import org.apache.ibatis.annotations.Select;

/**
 * 空间调整Mapper接口
 * 
 * @author Duke
 * @date 2026-03-12
 */
@Mapper
public interface SpaceMapper extends BaseMapper<Space>
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
     * @param space 空间调整
     * @return 空间调整集合
     */
    public List<Space> selectSpaceList(Space space);

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
     * 删除空间调整
     * 
     * @param id 空间调整主键
     * @return 结果
     */
    public int deleteSpaceById(Long id);

    /**
     * 批量删除空间调整
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpaceByIds(Long[] ids);

    /**
     * 获取所有楼栋
     * @return 列表
     */
    @Select("select space_name as buildingName,id as buildingId from space where parent_id = 0")
    List<SpaceBuildingVo> getAllBuilding();

}
