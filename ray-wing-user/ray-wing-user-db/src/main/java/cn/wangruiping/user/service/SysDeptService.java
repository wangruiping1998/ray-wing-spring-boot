package cn.wangruiping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wangruiping.user.entity.SysDeptEntity;

import cn.wangruiping.web.core.domain.PageParam;

/**
 * 部门表
 *
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
public interface SysDeptService extends IService<SysDeptEntity> {

    IPage<SysDeptEntity> page(PageParam pageParam);
}

