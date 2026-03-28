package com.zygj.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.zygj.hotel.domain.Room;

/**
 * 房间管理Service接口
 * 
 * @author Duke
 * @date 2026-03-12
 */
public interface IRoomService extends IService<Room>
{
    /**
     * 查询房间管理
     * 
     * @param id 房间管理主键
     * @return 房间管理
     */
    public Room selectRoomById(Long id);

    /**
     * 查询房间管理列表
     * 
     * @param room 房间管理
     * @return 房间管理集合
     */
    public List<Room> selectRoomList(Room room);

    /**
     * 新增房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    public int insertRoom(Room room);

    /**
     * 修改房间管理
     * 
     * @param room 房间管理
     * @return 结果
     */
    public int updateRoom(Room room);

    /**
     * 批量删除房间管理
     * 
     * @param ids 需要删除的房间管理主键集合
     * @return 结果
     */
    public int deleteRoomByIds(Long[] ids);

    /**
     * 删除房间管理信息
     * 
     * @param id 房间管理主键
     * @return 结果
     */
    public int deleteRoomById(Long id);
}
