package com.zygj.hotel.service.impl;

import java.util.List;
import com.zygj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zygj.hotel.mapper.RoomMapper;
import com.zygj.hotel.domain.Room;
import com.zygj.hotel.service.IRoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Arrays;

/**
 * 房间管理Service业务层处理
 * 
 * @author Duke
 * @date 2026-03-12
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements IRoomService
{
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 查询房间管理
     * 
     * @param id 房间管理主键
     * @return 房间管理
     */
    @Override
    public Room selectRoomById(Long id)
    {
        return getById(id);
    }

    /**
     * 查询房间管理列表
     * 
     * @param room 房间管理
     * @return 房间管理
     */
    @Override
    public List<Room> selectRoomList(Room room)
    {
        return roomMapper.selectRoomList(room);
    }

    /**
     * 新增房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    @Override
    public int insertRoom(Room room)
    {
        return save(room) ? 1 : 0;
    }

    /**
     * 修改房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    @Override
    public int updateRoom(Room room)
    {
        return updateById(room) ? 1 : 0;
    }

    /**
     * 批量删除房间管理
     * 
     * @param ids 需要删除的房间管理主键
     * @return 结果
     */
    @Override
    public int deleteRoomByIds(Long[] ids)
    {
        return removeByIds(Arrays.asList(ids)) ? 1 : 0;
    }

    /**
     * 删除房间管理信息
     * 
     * @param id 房间管理主键
     * @return 结果
     */
    @Override
    public int deleteRoomById(Long id)
    {
        return removeById(id) ? 1 : 0;
    }
}
