package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysRoleDataScopeMapper;
import cn.wangruiping.user.entity.SysRoleDataScopeEntity;
import cn.wangruiping.user.service.SysRoleDataScopeService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 角色数据权限表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysRoleDataScopeService")
public class SysRoleDataScopeServiceImpl extends ServiceImpl<SysRoleDataScopeMapper, SysRoleDataScopeEntity>
        implements SysRoleDataScopeService {

    @Override
    public IPage<SysRoleDataScopeEntity> page(PageParam pageParam) {
        IPage<SysRoleDataScopeEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}