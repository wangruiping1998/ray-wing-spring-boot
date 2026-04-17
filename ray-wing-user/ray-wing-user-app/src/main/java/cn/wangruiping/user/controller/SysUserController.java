package cn.wangruiping.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysUserEntity;
import cn.wangruiping.user.service.SysUserService;

import cn.wangruiping.web.core.domain.PageParam;


/**
 * 用户表接口
 *
 * @author wrp
 * @since 2026-04-17 10:27:12
 */
@Tag(name = "用户表接口")
@RestController
@RequestMapping("sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @Operation(summary = "列表")
    @GetMapping
    public Result<IPage<SysUserEntity>> list(@Validated PageParam pageParam){
        IPage<SysUserEntity> page = sysUserService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @Operation(summary = "信息")
    @GetMapping("{id}")
    public Result<SysUserEntity> info(@PathVariable("id") Long id){
		SysUserEntity sysUser = sysUserService.getById(id);

        return ResultUtils.success(sysUser);
    }

    /**
     * 保存
     */
    @Operation(summary = "保存")
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysUserEntity sysUser){
		sysUserService.save(sysUser);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @Operation(summary = "修改")
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysUserEntity sysUser){
		sysUserService.updateById(sysUser);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @Operation(summary = "删除")
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysUserService.removeById(id);

        return ResultUtils.success();
    }

}
