package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysPermissionMapper;
import cn.wangruiping.user.entity.SysPermissionEntity;
import cn.wangruiping.user.service.SysPermissionService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 权限表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermissionEntity>
        implements SysPermissionService {

    @Override
    public IPage<SysPermissionEntity> page(PageParam pageParam) {
        IPage<SysPermissionEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}