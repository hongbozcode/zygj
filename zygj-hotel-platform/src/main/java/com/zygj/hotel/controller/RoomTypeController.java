package com.zygj.hotel.controller;

import java.util.List;

import com.zygj.common.core.domain.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zygj.common.annotation.Log;
import com.zygj.common.core.controller.BaseController;
import com.zygj.common.core.domain.AjaxResult;
import com.zygj.common.enums.BusinessType;
import com.zygj.hotel.domain.RoomType;
import com.zygj.hotel.service.IRoomTypeService;
import com.zygj.common.utils.poi.ExcelUtil;
import com.zygj.common.core.page.TableDataInfo;

/**
 * 房型Controller
 * 
 * @author Duke
 * @date 2026-03-11
 */
@RestController
@RequestMapping("/hotel/type")
@Tag(name= "房型相关接口")
public class RoomTypeController extends BaseController
{
    @Autowired
    private IRoomTypeService roomTypeService;

    /**
     * 查询房型列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:type:list')")
    @GetMapping("/list")
    @Operation(summary = "查询房型列表")
    public TableDataInfo list( @Parameter(description = "房型查询条件") RoomType roomType)
    {
        startPage();
        List<RoomType> list = roomTypeService.selectRoomTypeList(roomType);
        return getDataTable(list);
    }

    /**
     * 导出房型列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:type:export')")
    @Log(title = "房型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @Operation(summary = "导出房型列表")
    public void export(HttpServletResponse response, @Parameter(description = "房型查询条件") RoomType roomType)
    {
        List<RoomType> list = roomTypeService.selectRoomTypeList(roomType);
        ExcelUtil<RoomType> util = new ExcelUtil<RoomType>(RoomType.class);
        util.exportExcel(response, list, "房型数据");
    }

    /**
     * 获取房型详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:type:query')")
    @GetMapping(value = "/{id}")
    @Operation(summary = "获取房型详细信息")
    public R<RoomType> getInfo(@Parameter(description = "房型ID" ,required = true)
            @PathVariable("id") Long id)
    {
        return R.ok(roomTypeService.selectRoomTypeById(id));
    }

    /**
     * 新增房型
     */
    @PreAuthorize("@ss.hasPermi('hotel:type:add')")
    @Log(title = "房型", businessType = BusinessType.INSERT)
    @PostMapping
    @Operation(summary = "新增房型")
    public AjaxResult add( @Parameter(description = "房型实体", required = true) @RequestBody RoomType roomType)
    {
        return toAjax(roomTypeService.insertRoomType(roomType));
    }

    /**
     * 修改房型
     */
    @PreAuthorize("@ss.hasPermi('hotel:type:edit')")
    @Log(title = "房型", businessType = BusinessType.UPDATE)
    @PutMapping
    @Operation(summary = "修改房型")
    public AjaxResult edit( @Parameter(description = "房型实体", required = true) @RequestBody RoomType roomType)
    {
        return toAjax(roomTypeService.updateRoomType(roomType));
    }

    /**
     * 删除房型
     */
    @PreAuthorize("@ss.hasPermi('hotel:type:remove')")
    @Log(title = "房型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @Operation(summary = "删除房型")
    public AjaxResult remove( @Parameter(description = "房型ID数组" ,required = true) @PathVariable Long[] ids)
    {
        return toAjax(roomTypeService.deleteRoomTypeByIds(ids));
    }
}
