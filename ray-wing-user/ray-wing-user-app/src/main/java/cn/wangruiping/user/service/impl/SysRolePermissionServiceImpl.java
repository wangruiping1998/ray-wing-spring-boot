package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysRolePermissionMapper;
import cn.wangruiping.user.entity.SysRolePermissionEntity;
import cn.wangruiping.user.service.SysRolePermissionService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色权限关联表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermissionEntity>
        implements SysRolePermissionService {

    @Override
    public IPage<SysRolePermissionEntity> page(PageParam pageParam) {
        IPage<SysRolePermissionEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}