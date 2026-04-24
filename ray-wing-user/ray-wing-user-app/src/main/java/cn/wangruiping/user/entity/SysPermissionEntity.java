package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_permission", autoResultMap = true)
public class SysPermissionEntity extends BaseEntity {

	/**
	 * 租户ID（0表示系统内置权限）
	 */
	@Schema(title = "租户ID（0表示系统内置权限）")
    private Long tenantId;
	/**
	 * 父权限ID
	 */
	@Schema(title = "父权限ID")
    private Long parentId;
	/**
	 * 权限编码（如：user:add）
	 */
	@Schema(title = "权限编码（如：user:add）")
    private String permissionCode;
	/**
	 * 权限名称
	 */
	@Schema(title = "权限名称")
    private String permissionName;
	/**
	 * 类型：1-菜单 2-按钮 3-接口
	 */
	@Schema(title = "类型：1-菜单 2-按钮 3-接口")
    private Integer permissionType;
	/**
	 * 路由路径（菜单类型）
	 */
	@Schema(title = "路由路径（菜单类型）")
    private String path;
	/**
	 * 组件路径（菜单类型）
	 */
	@Schema(title = "组件路径（菜单类型）")
    private String component;
	/**
	 * 图标
	 */
	@Schema(title = "图标")
    private String icon;
	/**
	 * API接口地址（接口类型）
	 */
	@Schema(title = "API接口地址（接口类型）")
    private String apiUrl;
	/**
	 * API请求方法
	 */
	@Schema(title = "API请求方法")
    private String apiMethod;
	/**
	 * 排序
	 */
	@Schema(title = "排序")
    private Integer sort;
	/**
	 * 是否可见
	 */
	@Schema(title = "是否可见")
    private Integer visible;
	/**
	 * 状态：0-禁用 1-启用
	 */
	@Schema(title = "状态：0-禁用 1-启用")
    private Integer status;

}
