package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysRoleDataScopeDetailEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色数据权限明细表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysRoleDataScopeDetailService extends IService<SysRoleDataScopeDetailEntity> {

    IPage<SysRoleDataScopeDetailEntity> page(PageParam pageParam);
}

