package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_role", autoResultMap = true)
public class SysRoleEntity extends BaseEntity {

	/**
	 * 租户ID
	 */
	@Schema(title = "租户ID")
    private Long tenantId;
	/**
	 * 角色编码
	 */
	@Schema(title = "角色编码")
    private String roleCode;
	/**
	 * 角色名称
	 */
	@Schema(title = "角色名称")
    private String roleName;
	/**
	 * 角色描述
	 */
	@Schema(title = "角色描述")
    private String description;
	/**
	 * 排序
	 */
	@Schema(title = "排序")
    private Integer sort;
	/**
	 * 状态：0-禁用 1-启用
	 */
	@Schema(title = "状态：0-禁用 1-启用")
    private Integer status;

}
