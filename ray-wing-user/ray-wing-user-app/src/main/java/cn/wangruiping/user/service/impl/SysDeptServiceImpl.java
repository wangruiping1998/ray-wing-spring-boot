package cn.wangruiping.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.wangruiping.user.mapper.SysDeptMapper;
import cn.wangruiping.user.entity.SysDeptEntity;
import cn.wangruiping.user.service.SysDeptService;
import cn.wangruiping.web.core.domain.PageParam;

/**
 * 部门表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity>
        implements SysDeptService {

    @Override
    public IPage<SysDeptEntity> page(PageParam pageParam) {
        IPage<SysDeptEntity> page = new Page<>(pageParam.getPageNo(), pageParam.getPageSize());
        return page(page, null);
    }
}