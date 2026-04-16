package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysRoleMapper;
import cn.wangruiping.user.entity.SysRoleEntity;
import cn.wangruiping.user.service.SysRoleService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity>
        implements SysRoleService {

    @Override
    public IPage<SysRoleEntity> page(PageParam pageParam) {
        IPage<SysRoleEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}