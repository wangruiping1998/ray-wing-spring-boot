package cn.wangruiping.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysRoleEntity;
import cn.wangruiping.user.service.SysRoleService;
import cn.wangruiping.web.core.domain.PageParam;


/**
 * 角色表接口
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@RestController
@RequestMapping("sys/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表
     */
    @GetMapping
    public Result<IPage<SysRoleEntity>> list(@Validated PageParam pageParam){
        IPage<SysRoleEntity> page = sysRoleService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @GetMapping("{id}")
    public Result<SysRoleEntity> info(@PathVariable("id") Long id){
		SysRoleEntity sysRole = sysRoleService.getById(id);

        return ResultUtils.success(sysRole);
    }

    /**
     * 保存
     */
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysRoleEntity sysRole){
		sysRoleService.save(sysRole);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysRoleEntity sysRole){
		sysRoleService.updateById(sysRole);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysRoleService.removeById(id);

        return ResultUtils.success();
    }

}
