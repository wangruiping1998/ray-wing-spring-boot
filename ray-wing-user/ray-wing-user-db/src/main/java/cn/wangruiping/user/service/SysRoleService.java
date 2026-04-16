package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysRoleEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    IPage<SysRoleEntity> page(PageParam pageParam);
}

