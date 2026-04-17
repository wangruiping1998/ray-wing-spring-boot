package cn.wangruiping.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;



import cn.wangruiping.web.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 用户表
 * 
 * @author wrp
 * @since 2026-04-16 16:06:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_user", autoResultMap = true)
public class SysUserEntity extends BaseEntity {

	/**
	 * 租户ID
	 */
	@Schema(name = "租户ID")
    private Long tenantId;
	/**
	 * 用户名
	 */
	@Schema(name = "用户名")
    private String username;
	/**
	 * 密码（加密存储）
	 */
	@Schema(name = "密码（加密存储）")
    private String password;
	/**
	 * 昵称
	 */
	@Schema(name = "昵称")
    private String nickname;
	/**
	 * 邮箱
	 */
	@Schema(name = "邮箱")
    private String email;
	/**
	 * 手机号
	 */
	@Schema(name = "手机号")
    private String phone;
	/**
	 * 头像URL
	 */
	@Schema(name = "头像URL")
    private String avatar;
	/**
	 * 性别：0-未知 1-男 2-女
	 */
	@Schema(name = "性别：0-未知 1-男 2-女")
    private Integer gender;
	/**
	 * 状态：0-禁用 1-启用
	 */
	@Schema(name = "状态：0-禁用 1-启用")
    private Integer status;
	/**
	 * 是否租户管理员：0-否 1-是
	 */
	@Schema(name = "是否租户管理员：0-否 1-是")
    private Integer isAdmin;
	/**
	 * 最后登录时间
	 */
	@Schema(name = "最后登录时间")
    private LocalDateTime lastLoginTime;
	/**
	 * 最后登录IP
	 */
	@Schema(name = "最后登录IP")
    private String lastLoginIp;

}
