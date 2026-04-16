package cn.wangruiping.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysPermissionEntity;
import cn.wangruiping.user.service.SysPermissionService;
import java.util.List;
import cn.wangruiping.web.core.domain.PageParam;


/**
 * 权限表接口
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@RestController
@RequestMapping("sys/permission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 列表
     */
    @GetMapping
    public Result<IPage<SysPermissionEntity>> list(@Validated PageParam pageParam){
        IPage<SysPermissionEntity> page = sysPermissionService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @GetMapping("{id}")
    public Result<SysPermissionEntity> info(@PathVariable("id") Long id){
		SysPermissionEntity sysPermission = sysPermissionService.getById(id);

        return ResultUtils.success(sysPermission);
    }

    /**
     * 保存
     */
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysPermissionEntity sysPermission){
		sysPermissionService.save(sysPermission);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysPermissionEntity sysPermission){
		sysPermissionService.updateById(sysPermission);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysPermissionService.removeById(id);

        return ResultUtils.success();
    }

}
