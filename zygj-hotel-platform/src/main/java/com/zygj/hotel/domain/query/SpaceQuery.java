package com.zygj.hotel.domain.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Duke
 */
@Data
@Schema(title = "空间调整查询条件")
public class SpaceQuery {
    //分页参数
    @Schema(description = "当前页码")
    private Integer pageNum=1;
    @Schema(description = "每页数量")
    private Integer pageSize=5;
    //空间名称
    @Schema(description = "空间名称")
    private String  spaceName;

}
