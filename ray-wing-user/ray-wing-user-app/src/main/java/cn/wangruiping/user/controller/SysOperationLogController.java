package cn.wangruiping.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import cn.wangruiping.user.entity.SysOperationLogEntity;
import cn.wangruiping.user.service.SysOperationLogService;

import cn.wangruiping.web.core.domain.PageParam;


/**
 * 操作日志表接口
 *
 * @author wrp
 * @since 2026-04-17 10:27:12
 */
@Tag(name = "操作日志表接口")
@RestController
@RequestMapping("sys/operation/log")
public class SysOperationLogController {
    @Autowired
    private SysOperationLogService sysOperationLogService;

    /**
     * 列表
     */
    @Operation(summary = "列表")
    @GetMapping
    public Result<IPage<SysOperationLogEntity>> list(@Validated PageParam pageParam){
        IPage<SysOperationLogEntity> page = sysOperationLogService.page(pageParam);

        return ResultUtils.success(page);
    }

    /**
     * 信息
     */
    @Operation(summary = "信息")
    @GetMapping("{id}")
    public Result<SysOperationLogEntity> info(@PathVariable("id") Long id){
		SysOperationLogEntity sysOperationLog = sysOperationLogService.getById(id);

        return ResultUtils.success(sysOperationLog);
    }

    /**
     * 保存
     */
    @Operation(summary = "保存")
    @PostMapping
    public Result<Void> save(@RequestBody @Validated SysOperationLogEntity sysOperationLog){
		sysOperationLogService.save(sysOperationLog);

        return ResultUtils.success();
    }

    /**
     * 修改
     */
    @Operation(summary = "修改")
    @PutMapping
    public Result<Void> update(@RequestBody @Validated SysOperationLogEntity sysOperationLog){
		sysOperationLogService.updateById(sysOperationLog);

        return ResultUtils.success();
    }

    /**
     * 删除
     */
    @Operation(summary = "删除")
    @DeleteMapping("{id}")
    public Result<Void> delete(@PathVariable("id") Long id){
		sysOperationLogService.removeById(id);

        return ResultUtils.success();
    }

}
