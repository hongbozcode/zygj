package com.zygj.hotel.controller;

import java.util.List;

import com.zygj.common.core.domain.R;
import com.zygj.hotel.domain.query.SpaceQuery;
import com.zygj.hotel.domain.vo.SpaceBuildingVo;
import com.zygj.hotel.domain.vo.SpaceVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zygj.common.annotation.Log;
import com.zygj.common.core.controller.BaseController;
import com.zygj.common.core.domain.AjaxResult;
import com.zygj.common.enums.BusinessType;
import com.zygj.hotel.domain.Space;
import com.zygj.hotel.service.ISpaceService;
import com.zygj.common.utils.poi.ExcelUtil;
import com.zygj.common.core.page.TableDataInfo;

/**
 * 空间调整Controller
 * 
 * @author Duke
 * @date 2026-03-12
 */
@Slf4j
@RestController
@RequestMapping("/hotel/space")
@Tag(name= "空间调整相关接口")
public class SpaceController extends BaseController
{
    @Autowired
    private ISpaceService spaceService;

    /**
     * 查询空间调整列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:space:list')")
    @GetMapping("/list")
    @Operation(summary = "查询空间调整列表")
    public TableDataInfo list(@ParameterObject SpaceQuery spaceQuery)
    {
        log.info("查询空间调整列表：{}", spaceQuery);
        List<SpaceVo> list = spaceService.selectSpaceList(spaceQuery);
        return getDataTable(list);
    }

    /**
     * 获取空间调整详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:space:query')")
    @GetMapping(value = "/{id}")
    @Operation(summary = "获取空间调整详细信息")
    public R<Space> getInfo(@Parameter(description = "空间调整ID" ,required = true)
            @PathVariable("id") Long id)
    {
        return R.ok(spaceService.selectSpaceById(id));
    }

    /**
     * 新增空间调整
     */
    @PreAuthorize("@ss.hasPermi('hotel:space:add')")
    @Log(title = "空间调整", businessType = BusinessType.INSERT)
    @PostMapping
    @Operation(summary = "新增空间调整")
    public AjaxResult add( @Parameter(description = "空间调整实体", required = true) @RequestBody Space space)
    {
        return toAjax(spaceService.insertSpace(space));
    }

    /**
     * 修改空间调整
     */
    @PreAuthorize("@ss.hasPermi('hotel:space:edit')")
    @Log(title = "空间调整", businessType = BusinessType.UPDATE)
    @PutMapping
    @Operation(summary = "修改空间调整")
    public AjaxResult edit( @Parameter(description = "空间调整实体", required = true) @RequestBody Space space)
    {
        return toAjax(spaceService.updateSpace(space));
    }

    /**
     * 删除空间调整
     */
    @PreAuthorize("@ss.hasPermi('hotel:space:remove')")
    @Log(title = "空间调整", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @Operation(summary = "删除空间调整")
    public AjaxResult remove( @Parameter(description = "空间调整ID数组" ,required = true) @PathVariable Long[] ids)
    {
        return toAjax(spaceService.deleteSpaceByIds(ids));
    }


    /**
     * 获取所有楼栋
     */
    @GetMapping("/getAllBuilding")
    @Operation(summary = "获取所有楼栋")
    public R<List<SpaceBuildingVo>> getAllBuilding(){
        return R.ok(spaceService.getAllBuilding());
    }

}
