package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysRoleDataScopeDetailMapper;
import cn.wangruiping.user.entity.SysRoleDataScopeDetailEntity;
import cn.wangruiping.user.service.SysRoleDataScopeDetailService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色数据权限明细表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysRoleDataScopeDetailService")
public class SysRoleDataScopeDetailServiceImpl extends ServiceImpl<SysRoleDataScopeDetailMapper, SysRoleDataScopeDetailEntity>
        implements SysRoleDataScopeDetailService {

    @Override
    public IPage<SysRoleDataScopeDetailEntity> page(PageParam pageParam) {
        IPage<SysRoleDataScopeDetailEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}