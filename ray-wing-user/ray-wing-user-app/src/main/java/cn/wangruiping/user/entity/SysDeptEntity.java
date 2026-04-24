package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_dept", autoResultMap = true)
public class SysDeptEntity extends BaseEntity {

	/**
	 * 租户ID
	 */
	@Schema(title = "租户ID")
    private Long tenantId;
	/**
	 * 父部门ID
	 */
	@Schema(title = "父部门ID")
    private Long parentId;
	/**
	 * 部门名称
	 */
	@Schema(title = "部门名称")
    private String deptName;
	/**
	 * 部门编码
	 */
	@Schema(title = "部门编码")
    private String deptCode;
	/**
	 * 负责人
	 */
	@Schema(title = "负责人")
    private String leader;
	/**
	 * 联系电话
	 */
	@Schema(title = "联系电话")
    private String phone;
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
