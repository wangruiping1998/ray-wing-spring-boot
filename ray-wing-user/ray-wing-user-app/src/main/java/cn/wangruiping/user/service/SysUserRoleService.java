package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysUserRoleEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 用户角色关联表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    IPage<SysUserRoleEntity> page(PageParam pageParam);
}

