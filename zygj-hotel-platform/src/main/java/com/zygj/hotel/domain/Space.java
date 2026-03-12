package com.zygj.hotel.domain;

import com.zygj.common.annotation.Excel;
import com.zygj.common.core.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 空间调整对象 space
 * 
 * @author Duke
 * @date 2026-03-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "空间调整实体")
public class Space extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 空间ID */
    @Schema(title = "空间ID")
    private Long id;


    /** 父空间ID（楼栋的父ID为0，楼层的父ID为所属楼栋ID） */
    @Excel(name = "父空间ID", readConverterExp = "楼=栋的父ID为0，楼层的父ID为所属楼栋ID")
    @Schema(title = "父空间ID（楼栋的父ID为0，楼层的父ID为所属楼栋ID）")
    private Long parentId;

    /** 空间名称 */
    @Excel(name = "空间名称")
    @Schema(title = "空间名称")
    private String spaceName;

    /** 空间类型（0-楼栋 1-楼层） */
    @Excel(name = "空间类型", readConverterExp = "0=-楼栋,1=-楼层")
    @Schema(title = "空间类型（0-楼栋 1-楼层）")
    private Integer spaceType;

    /** 排序 */
    @Excel(name = "排序")
    @Schema(title = "排序")
    private Integer sortOrder;


}
