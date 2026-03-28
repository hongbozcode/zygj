package com.zygj.hotel.domain;

import com.zygj.common.annotation.Excel;
import com.zygj.common.core.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 房间管理对象 room
 * 
 * @author Duke
 * @date 2026-03-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "房间管理实体")
public class Room extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间ID */
    @Schema(title = "房间ID")
    private Long id;

    /** 所属楼栋ID（关联space.id且space.space_type=0） */
    @Excel(name = "所属楼栋ID", readConverterExp = "关=联space.id且space.space_type=0")
    @Schema(title = "所属楼栋ID（关联space.id且space.space_type=0）")
    private Long buildingId;

    /** 所属楼层ID（关联space.id且space.space_type=1） */
    @Excel(name = "所属楼层ID", readConverterExp = "关=联space.id且space.space_type=1")
    @Schema(title = "所属楼层ID（关联space.id且space.space_type=1）")
    private Long floorId;

    /** 房间号 */
    @Excel(name = "房间号")
    @Schema(title = "房间号")
    private String roomNumber;

    /** 房型ID */
    @Excel(name = "房型ID")
    @Schema(title = "房型ID")
    private Long roomTypeId;

    /** 状态（0-禁用 1-启用） */
    @Excel(name = "状态", readConverterExp = "0=-禁用,1=-启用")
    @Schema(title = "状态（0-禁用 1-启用）")
    private Integer status;


}
