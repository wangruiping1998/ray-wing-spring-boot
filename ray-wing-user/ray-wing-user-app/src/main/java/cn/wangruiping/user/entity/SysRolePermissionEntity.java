package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色权限关联表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_role_permission", autoResultMap = true)
public class SysRolePermissionEntity extends BaseEntity {

	/**
	 * 租户ID
	 */
	@Schema(title = "租户ID")
    private Long tenantId;
	/**
	 * 角色ID
	 */
	@Schema(title = "角色ID")
    private Long roleId;
	/**
	 * 权限ID
	 */
	@Schema(title = "权限ID")
    private Long permissionId;

}
