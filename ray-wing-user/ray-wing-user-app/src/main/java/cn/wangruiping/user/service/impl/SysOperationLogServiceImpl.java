package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysOperationLogMapper;
import cn.wangruiping.user.entity.SysOperationLogEntity;
import cn.wangruiping.user.service.SysOperationLogService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 操作日志表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysOperationLogService")
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLogEntity>
        implements SysOperationLogService {

    @Override
    public IPage<SysOperationLogEntity> page(PageParam pageParam) {
        IPage<SysOperationLogEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}