package com.zygj.hotel.controller;

import java.util.List;

import com.zygj.common.core.domain.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springdoc.core.annotations.ParameterObject;
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
import com.zygj.hotel.domain.Room;
import com.zygj.hotel.service.IRoomService;
import com.zygj.common.utils.poi.ExcelUtil;
import com.zygj.common.core.page.TableDataInfo;

/**
 * 房间管理Controller
 * 
 * @author Duke
 * @date 2026-03-12
 */
@RestController
@RequestMapping("/hotel/room")
@Tag(name= "房间管理相关接口")
public class RoomController extends BaseController
{
    @Autowired
    private IRoomService roomService;

    /**
     * 查询房间管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:room:list')")
    @GetMapping("/list")
    @Operation(summary = "查询房间管理列表")
    public TableDataInfo list( @ParameterObject Room room)
    {
        startPage();
        List<Room> list = roomService.selectRoomList(room);
        return getDataTable(list);
    }

    /**
     * 导出房间管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:room:export')")
    @Log(title = "房间管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @Operation(summary = "导出房间管理列表")
    public void export(HttpServletResponse response, @Parameter(description = "房间管理查询条件") Room room)
    {
        List<Room> list = roomService.selectRoomList(room);
        ExcelUtil<Room> util = new ExcelUtil<Room>(Room.class);
        util.exportExcel(response, list, "房间管理数据");
    }

    /**
     * 获取房间管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:room:query')")
    @GetMapping(value = "/{id}")
    @Operation(summary = "获取房间管理详细信息")
    public R<Room> getInfo(@Parameter(description = "房间管理ID" ,required = true)
            @PathVariable("id") Long id)
    {
        return R.ok(roomService.selectRoomById(id));
    }

    /**
     * 新增房间管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:room:add')")
    @Log(title = "房间管理", businessType = BusinessType.INSERT)
    @PostMapping
    @Operation(summary = "新增房间管理")
    public AjaxResult add( @Parameter(description = "房间管理实体", required = true) @RequestBody Room room)
    {
        return toAjax(roomService.insertRoom(room));
    }

    /**
     * 修改房间管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:room:edit')")
    @Log(title = "房间管理", businessType = BusinessType.UPDATE)
    @PutMapping
    @Operation(summary = "修改房间管理")
    public AjaxResult edit( @Parameter(description = "房间管理实体", required = true) @RequestBody Room room)
    {
        return toAjax(roomService.updateRoom(room));
    }

    /**
     * 删除房间管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:room:remove')")
    @Log(title = "房间管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @Operation(summary = "删除房间管理")
    public AjaxResult remove( @Parameter(description = "房间管理ID数组" ,required = true) @PathVariable Long[] ids)
    {
        return toAjax(roomService.deleteRoomByIds(ids));
    }
}
