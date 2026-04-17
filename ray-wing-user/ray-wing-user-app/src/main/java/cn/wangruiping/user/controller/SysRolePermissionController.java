package cn.wangruiping.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysRolePermissionEntity;
import cn.wangruiping.user.service.SysRolePermissionService;

import cn.wangruiping.web.core.domain.PageParam;


/**
 * 角色权限关联表接口
 *
 * @author wrp
 * @since 2026-04-17 10:27:12
 */
@Tag(name = "角色权限关联表接口")
@RestController
@RequestMapping("sys/role/permission")
public class SysRolePermissionController {
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    /**
     * 列表
     */
    @Operation(summary = "列表")
    @GetMapping
    public Result<IPage<SysRolePermissionEntity>> list(@Validated PageParam pageParam){
        IPage<SysRolePermissionEntity> page = sysRolePermissionService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @Operation(summary = "信息")
    @GetMapping("{id}")
    public Result<SysRolePermissionEntity> info(@PathVariable("id") Long id){
		SysRolePermissionEntity sysRolePermission = sysRolePermissionService.getById(id);

        return ResultUtils.success(sysRolePermission);
    }

    /**
     * 保存
     */
    @Operation(summary = "保存")
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysRolePermissionEntity sysRolePermission){
		sysRolePermissionService.save(sysRolePermission);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @Operation(summary = "修改")
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysRolePermissionEntity sysRolePermission){
		sysRolePermissionService.updateById(sysRolePermission);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @Operation(summary = "删除")
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysRolePermissionService.removeById(id);

        return ResultUtils.success();
    }

}
