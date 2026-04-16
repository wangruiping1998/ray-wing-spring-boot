package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysOperationLogEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 操作日志表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysOperationLogService extends IService<SysOperationLogEntity> {

    IPage<SysOperationLogEntity> page(PageParam pageParam);
}

