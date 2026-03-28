package com.zygj.hotel.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zygj.common.utils.StringUtils;
import com.zygj.hotel.domain.query.SpaceQuery;
import com.zygj.hotel.domain.vo.SpaceBuildingVo;
import com.zygj.hotel.domain.vo.SpaceFloorVo;
import com.zygj.hotel.domain.vo.SpaceVo;
import com.zygj.system.mapper.SysUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zygj.hotel.mapper.SpaceMapper;
import com.zygj.hotel.domain.Space;
import com.zygj.hotel.service.ISpaceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Arrays;

/**
 * 空间调整Service业务层处理
 * 
 * @author Duke
 * @date 2026-03-12
 */
@Service
public class SpaceServiceImpl extends ServiceImpl<SpaceMapper, Space> implements ISpaceService
{
    @Autowired
    private SpaceMapper spaceMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询空间调整
     * 
     * @param id 空间调整主键
     * @return 空间调整
     */
    @Override
    public Space selectSpaceById(Long id)
    {
        return getById(id);
    }

    /**
     * 查询空间调整列表
     * 
     * @param spaceQuery 空间调整
     * @return 空间调整
     */
    @Override
    public List<SpaceVo> selectSpaceList(SpaceQuery spaceQuery)
    {
        //先分页查询楼栋
        Page<Space> page = new Page<>(spaceQuery.getPageNum(), spaceQuery.getPageSize());
        //添加条件
        LambdaQueryWrapper<Space> qw = new LambdaQueryWrapper<>();
        qw.eq(Space::getParentId,0);
        qw.like(StringUtils.isNotEmpty(spaceQuery.getSpaceName()),Space::getSpaceName,spaceQuery.getSpaceName());
        //排序
        page.addOrder(OrderItem.asc("sort_order"));
        page = page(page,qw);
        //获取楼栋列表
        List<Space> records = page.getRecords();

        List<SpaceVo> spaceVoList= new ArrayList<>();
        //逐行拷贝属性
        records.forEach(space -> {
            SpaceVo spaceVo = new SpaceVo();
            BeanUtils.copyProperties(space, spaceVo);
            //设置updateBy
            String updateBy = sysUserMapper.getNickNameById(Long.valueOf(space.getUpdateBy()));
            spaceVo.setUpdateBy(updateBy);
            spaceVoList.add(spaceVo);
        });
        spaceVoList.forEach(spaceVo -> {
            //设置查询条件
            LambdaQueryWrapper<Space> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Space::getParentId, spaceVo.getId())
                    .orderByAsc(Space::getSortOrder);
            //根据楼栋查询楼层
            List<Space> spaces = spaceMapper.selectList(queryWrapper);

            List<SpaceVo> spaceVos = new ArrayList<>();
            //逐行拷贝属性
            spaces.forEach(space -> {
                SpaceVo vo = new SpaceVo();
                BeanUtils.copyProperties(space, vo);
                //设置updateBy
                String updateBy = sysUserMapper.getNickNameById(Long.valueOf(space.getUpdateBy()));
                vo.setUpdateBy(updateBy);
                spaceVos.add(vo);
            });
            //设置子节点
            spaceVo.setChildren(spaceVos);
        });

        return spaceVoList;
    }

    /**
     * 新增空间调整
     * 
     * @param space 空间调整
     * @return 结果
     */
    @Override
    public int insertSpace(Space space)
    {
        space.setUpdateBy(space.getCreateBy());
        space.setUpdateTime(space.getCreateTime());
        return save(space) ? 1 : 0;
    }

    /**
     * 修改空间调整
     * 
     * @param space 空间调整
     * @return 结果
     */
    @Override
    public int updateSpace(Space space)
    {
        return updateById(space) ? 1 : 0;
    }

    /**
     * 批量删除空间调整
     * 
     * @param ids 需要删除的空间调整主键
     * @return 结果
     */
    @Override
    public int deleteSpaceByIds(Long[] ids)
    {
        return removeByIds(Arrays.asList(ids)) ? 1 : 0;
    }

    /**
     * 删除空间调整信息
     * 
     * @param id 空间调整主键
     * @return 结果
     */
    @Override
    public int deleteSpaceById(Long id)
    {
        return removeById(id) ? 1 : 0;
    }

    /**
     * 获取所有楼栋
     * @return 楼栋集合
     */
    @Override
    public List<SpaceBuildingVo> getAllBuilding() {
        return spaceMapper.getAllBuilding();
    }

    /**
     * 获取所有楼层
     *
     * @param buildingId 楼栋ID
     * @return 楼层集合
     */
    @Override
    public List<SpaceFloorVo> getAllFloor(String buildingId) {
        return spaceMapper.getAllFloor(buildingId);
    }
}
