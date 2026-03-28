package com.zygj.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.zygj.hotel.domain.Room;

/**
 * 房间管理Mapper接口
 * 
 * @author Duke
 * @date 2026-03-12
 */
@Mapper
public interface RoomMapper extends BaseMapper<Room>
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
     * 删除房间管理
     * 
     * @param id 房间管理主键
     * @return 结果
     */
    public int deleteRoomById(Long id);

    /**
     * 批量删除房间管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRoomByIds(Long[] ids);
}
