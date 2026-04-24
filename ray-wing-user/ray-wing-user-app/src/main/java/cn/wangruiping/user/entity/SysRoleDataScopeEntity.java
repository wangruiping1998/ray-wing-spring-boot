package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色数据权限表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_role_data_scope", autoResultMap = true)
public class SysRoleDataScopeEntity extends BaseEntity {

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
	 * 数据范围：1-全部 2-本部门 3-本部门及子部门 4-仅本人 5-自定义
	 */
	@Schema(title = "数据范围：1-全部 2-本部门 3-本部门及子部门 4-仅本人 5-自定义")
    private Integer dataScope;

}
