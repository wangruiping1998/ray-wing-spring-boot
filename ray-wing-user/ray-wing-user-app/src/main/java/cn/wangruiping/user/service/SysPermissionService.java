package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysPermissionEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 权限表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysPermissionService extends IService<SysPermissionEntity> {

    IPage<SysPermissionEntity> page(PageParam pageParam);
}

