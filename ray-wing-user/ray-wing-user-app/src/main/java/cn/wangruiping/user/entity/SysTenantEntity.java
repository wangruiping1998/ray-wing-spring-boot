package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 租户表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_tenant", autoResultMap = true)
public class SysTenantEntity extends BaseEntity {

	/**
	 * 租户编码
	 */
	@Schema(title = "租户编码")
    private String tenantCode;
	/**
	 * 租户名称
	 */
	@Schema(title = "租户名称")
    private String tenantName;
	/**
	 * 联系人
	 */
	@Schema(title = "联系人")
    private String contactName;
	/**
	 * 联系电话
	 */
	@Schema(title = "联系电话")
    private String contactPhone;
	/**
	 * 状态：0-禁用 1-启用
	 */
	@Schema(title = "状态：0-禁用 1-启用")
    private Integer status;
	/**
	 * 过期时间
	 */
	@Schema(title = "过期时间")
    private LocalDateTime expireTime;

}
