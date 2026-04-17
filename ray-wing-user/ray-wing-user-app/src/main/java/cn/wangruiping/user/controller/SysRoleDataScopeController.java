package cn.wangruiping.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysRoleDataScopeEntity;
import cn.wangruiping.user.service.SysRoleDataScopeService;

import cn.wangruiping.web.core.domain.PageParam;


/**
 * 角色数据权限表接口
 *
 * @author wrp
 * @since 2026-04-17 10:27:12
 */
@Tag(name = "角色数据权限表接口")
@RestController
@RequestMapping("sys/role/data/scope")
public class SysRoleDataScopeController {
    @Autowired
    private SysRoleDataScopeService sysRoleDataScopeService;

    /**
     * 列表
     */
    @Operation(summary = "列表")
    @GetMapping
    public Result<IPage<SysRoleDataScopeEntity>> list(@Validated PageParam pageParam){
        IPage<SysRoleDataScopeEntity> page = sysRoleDataScopeService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @Operation(summary = "信息")
    @GetMapping("{id}")
    public Result<SysRoleDataScopeEntity> info(@PathVariable("id") Long id){
		SysRoleDataScopeEntity sysRoleDataScope = sysRoleDataScopeService.getById(id);

        return ResultUtils.success(sysRoleDataScope);
    }

    /**
     * 保存
     */
    @Operation(summary = "保存")
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysRoleDataScopeEntity sysRoleDataScope){
		sysRoleDataScopeService.save(sysRoleDataScope);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @Operation(summary = "修改")
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysRoleDataScopeEntity sysRoleDataScope){
		sysRoleDataScopeService.updateById(sysRoleDataScope);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @Operation(summary = "删除")
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysRoleDataScopeService.removeById(id);

        return ResultUtils.success();
    }

}
