package com.zygj.hotel.domain;

import java.math.BigDecimal;
import com.zygj.common.annotation.Excel;
import com.zygj.common.core.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 房型对象 room_type
 * 
 * @author Duke
 * @date 2026-03-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "房型实体")
public class RoomType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房型ID */
    @Schema(title = "房型ID")
    private Long id;


    /** 房型名称（如1人标准房） */
    @Excel(name = "房型名称", readConverterExp = "如=1人标准房")
    @Schema(title = "房型名称（如1人标准房）")
    private String typeName;

    /** 展示图片RL */
    @Excel(name = "展示图片RL")
    @Schema(title = "展示图片RL")
    private String image;

    /** 容纳人数 */
    @Excel(name = "容纳人数")
    @Schema(title = "容纳人数")
    private Integer capacity;

    /** 标准面积（平方米） */
    @Excel(name = "标准面积", readConverterExp = "平=方米")
    @Schema(title = "标准面积（平方米）")
    private Integer area;

    /** 是否有窗（0-无窗 1-有窗） */
    @Excel(name = "是否有窗", readConverterExp = "0=-无窗,1=-有窗")
    @Schema(title = "是否有窗（0-无窗 1-有窗）")
    private Integer hasWindow;

    /** 午夜价（展示价格） */
    @Excel(name = "午夜价", readConverterExp = "展=示价格")
    @Schema(title = "午夜价（展示价格）")
    private BigDecimal midnightPrice;

    /** 标准价 */
    @Excel(name = "标准价")
    @Schema(title = "标准价")
    private BigDecimal standardPrice;

    /** 状态（0-禁用 1-启用） */
    @Excel(name = "状态", readConverterExp = "0=-禁用,1=-启用")
    @Schema(title = "状态（0-禁用 1-启用）")
    private Integer status;


}
