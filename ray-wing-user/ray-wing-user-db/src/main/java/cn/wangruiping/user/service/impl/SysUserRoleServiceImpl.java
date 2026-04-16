package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysUserRoleMapper;
import cn.wangruiping.user.entity.SysUserRoleEntity;
import cn.wangruiping.user.service.SysUserRoleService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 用户角色关联表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity>
        implements SysUserRoleService {

    @Override
    public IPage<SysUserRoleEntity> page(PageParam pageParam) {
        IPage<SysUserRoleEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}