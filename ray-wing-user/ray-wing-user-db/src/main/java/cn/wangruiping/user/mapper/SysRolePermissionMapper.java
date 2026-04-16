package cn.wangruiping.user.mapper;

import cn.wangruiping.user.entity.SysRolePermissionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色权限关联表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermissionEntity> {
	
}
