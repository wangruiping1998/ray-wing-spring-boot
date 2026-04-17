package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysRolePermissionEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色权限关联表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysRolePermissionService extends IService<SysRolePermissionEntity> {

    IPage<SysRolePermissionEntity> page(PageParam pageParam);
}

