package cn.wangruiping.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysUserRoleEntity;
import cn.wangruiping.user.service.SysUserRoleService;
import cn.wangruiping.web.core.domain.PageParam;


/**
 * 用户角色关联表接口
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@RestController
@RequestMapping("sys/user/role")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 列表
     */
    @GetMapping
    public Result<IPage<SysUserRoleEntity>> list(@Validated PageParam pageParam){
        IPage<SysUserRoleEntity> page = sysUserRoleService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @GetMapping("{id}")
    public Result<SysUserRoleEntity> info(@PathVariable("id") Long id){
		SysUserRoleEntity sysUserRole = sysUserRoleService.getById(id);

        return ResultUtils.success(sysUserRole);
    }

    /**
     * 保存
     */
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysUserRoleEntity sysUserRole){
		sysUserRoleService.save(sysUserRole);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysUserRoleEntity sysUserRole){
		sysUserRoleService.updateById(sysUserRole);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysUserRoleService.removeById(id);

        return ResultUtils.success();
    }

}
