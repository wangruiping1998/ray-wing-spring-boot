package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色数据权限明细表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_role_data_scope_detail", autoResultMap = true)
public class SysRoleDataScopeDetailEntity extends BaseEntity {

	/**
	 * 租户ID
	 */
	@Schema(name = "租户ID")
    private Long tenantId;
	/**
	 * 角色数据权限ID
	 */
	@Schema(name = "角色数据权限ID")
    private Long roleDataScopeId;
	/**
	 * 部门ID（自定义范围时使用）
	 */
	@Schema(name = "部门ID（自定义范围时使用）")
    private Long deptId;

}
