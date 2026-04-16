package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysRoleDataScopeEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色数据权限表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysRoleDataScopeService extends IService<SysRoleDataScopeEntity> {

    IPage<SysRoleDataScopeEntity> page(PageParam pageParam);
}

