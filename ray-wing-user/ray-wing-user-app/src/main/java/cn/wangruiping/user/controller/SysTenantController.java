package cn.wangruiping.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysTenantEntity;
import cn.wangruiping.user.service.SysTenantService;
import cn.wangruiping.web.core.domain.PageParam;


/**
 * 租户表接口
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@RestController
@RequestMapping("sys/tenant")
public class SysTenantController {
    @Autowired
    private SysTenantService sysTenantService;

    /**
     * 列表
     */
    @GetMapping
    public Result<IPage<SysTenantEntity>> list(@Validated PageParam pageParam){
        IPage<SysTenantEntity> page = sysTenantService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @GetMapping("{id}")
    public Result<SysTenantEntity> info(@PathVariable("id") Long id){
		SysTenantEntity sysTenant = sysTenantService.getById(id);

        return ResultUtils.success(sysTenant);
    }

    /**
     * 保存
     */
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysTenantEntity sysTenant){
		sysTenantService.save(sysTenant);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysTenantEntity sysTenant){
		sysTenantService.updateById(sysTenant);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysTenantService.removeById(id);

        return ResultUtils.success();
    }

}
