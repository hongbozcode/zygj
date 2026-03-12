package com.zygj.hotel.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 空间 VO（用于树形结构展示）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "空间树形结构 VO")
public class SpaceVo{

    /** 空间 ID */
    @Schema(description = "空间 ID")
    private Long id;


    /** 父空间 ID（楼栋的父 ID 为 0，楼层的父 ID 为所属楼栋 ID） */
    @Schema(description = "父空间 ID")
    private Long parentId;

    /** 空间名称 */
    @Schema(description = "空间名称")
    private String spaceName;

    /** 空间类型（0-楼栋 1-楼层） */
    @Schema(description = "空间类型（0-楼栋 1-楼层）")
    private Integer spaceType;

    /** 排序 */
    @Schema(description = "排序")
    private Integer sortOrder;

    /** 更新者 */
    @Schema(description = "更新者")
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /** 子节点列表（楼栋的子节点为楼层） */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Schema(title = "子节点列表")
    private List<SpaceVo> children;
}
