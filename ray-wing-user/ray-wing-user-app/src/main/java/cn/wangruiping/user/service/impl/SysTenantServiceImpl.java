package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysTenantMapper;
import cn.wangruiping.user.entity.SysTenantEntity;
import cn.wangruiping.user.service.SysTenantService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 租户表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysTenantService")
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenantEntity>
        implements SysTenantService {

    @Override
    public IPage<SysTenantEntity> page(PageParam pageParam) {
        IPage<SysTenantEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}