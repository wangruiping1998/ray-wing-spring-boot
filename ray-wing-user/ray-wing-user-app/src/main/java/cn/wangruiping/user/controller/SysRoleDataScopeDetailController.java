package cn.wangruiping.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysRoleDataScopeDetailEntity;
import cn.wangruiping.user.service.SysRoleDataScopeDetailService;

import cn.wangruiping.web.core.domain.PageParam;


/**
 * 角色数据权限明细表接口
 *
 * @author wrp
 * @since 2026-04-17 10:27:12
 */
@Tag(name = "角色数据权限明细表接口")
@RestController
@RequestMapping("sys/role/data/scope/detail")
public class SysRoleDataScopeDetailController {
    @Autowired
    private SysRoleDataScopeDetailService sysRoleDataScopeDetailService;

    /**
     * 列表
     */
    @Operation(summary = "列表")
    @GetMapping
    public Result<IPage<SysRoleDataScopeDetailEntity>> list(@Validated PageParam pageParam){
        IPage<SysRoleDataScopeDetailEntity> page = sysRoleDataScopeDetailService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @Operation(summary = "信息")
    @GetMapping("{id}")
    public Result<SysRoleDataScopeDetailEntity> info(@PathVariable("id") Long id){
		SysRoleDataScopeDetailEntity sysRoleDataScopeDetail = sysRoleDataScopeDetailService.getById(id);

        return ResultUtils.success(sysRoleDataScopeDetail);
    }

    /**
     * 保存
     */
    @Operation(summary = "保存")
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysRoleDataScopeDetailEntity sysRoleDataScopeDetail){
		sysRoleDataScopeDetailService.save(sysRoleDataScopeDetail);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @Operation(summary = "修改")
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysRoleDataScopeDetailEntity sysRoleDataScopeDetail){
		sysRoleDataScopeDetailService.updateById(sysRoleDataScopeDetail);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @Operation(summary = "删除")
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysRoleDataScopeDetailService.removeById(id);

        return ResultUtils.success();
    }

}
