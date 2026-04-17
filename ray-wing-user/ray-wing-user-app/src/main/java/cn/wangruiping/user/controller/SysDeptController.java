package cn.wangruiping.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysDeptEntity;
import cn.wangruiping.user.service.SysDeptService;

import cn.wangruiping.web.core.domain.PageParam;


/**
 * 部门表接口
 *
 * @author wrp
 * @since 2026-04-17 10:27:12
 */
@Tag(name = "部门表接口")
@RestController
@RequestMapping("sys/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @Operation(summary = "列表")
    @GetMapping
    public Result<IPage<SysDeptEntity>> list(@Validated PageParam pageParam){
        IPage<SysDeptEntity> page = sysDeptService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @Operation(summary = "信息")
    @GetMapping("{id}")
    public Result<SysDeptEntity> info(@PathVariable("id") Long id){
		SysDeptEntity sysDept = sysDeptService.getById(id);

        return ResultUtils.success(sysDept);
    }

    /**
     * 保存
     */
    @Operation(summary = "保存")
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysDeptEntity sysDept){
		sysDeptService.save(sysDept);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @Operation(summary = "修改")
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysDeptEntity sysDept){
		sysDeptService.updateById(sysDept);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @Operation(summary = "删除")
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysDeptService.removeById(id);

        return ResultUtils.success();
    }

}
