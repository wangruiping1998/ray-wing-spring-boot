package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 操作日志表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_operation_log", autoResultMap = true)
public class SysOperationLogEntity extends BaseEntity {

	/**
	 * 租户ID
	 */
	@Schema(name = "租户ID")
    private Long tenantId;
	/**
	 * 操作用户ID
	 */
	@Schema(name = "操作用户ID")
    private Long userId;
	/**
	 * 操作用户名
	 */
	@Schema(name = "操作用户名")
    private String username;
	/**
	 * 操作描述
	 */
	@Schema(name = "操作描述")
    private String operation;
	/**
	 * 请求方法
	 */
	@Schema(name = "请求方法")
    private String method;
	/**
	 * 请求参数
	 */
	@Schema(name = "请求参数")
    private String params;
	/**
	 * IP地址
	 */
	@Schema(name = "IP地址")
    private String ip;
	/**
	 * 操作状态：0-失败 1-成功
	 */
	@Schema(name = "操作状态：0-失败 1-成功")
    private Integer status;
	/**
	 * 错误信息
	 */
	@Schema(name = "错误信息")
    private String errorMsg;
	/**
	 * 执行时长(ms)
	 */
	@Schema(name = "执行时长(ms)")
    private Long duration;

}
