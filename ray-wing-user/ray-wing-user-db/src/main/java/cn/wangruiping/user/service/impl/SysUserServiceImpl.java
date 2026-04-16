package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysUserMapper;
import cn.wangruiping.user.entity.SysUserEntity;
import cn.wangruiping.user.service.SysUserService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 用户表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity>
        implements SysUserService {

    @Override
    public IPage<SysUserEntity> page(PageParam pageParam) {
        IPage<SysUserEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}