package cn.wangruiping.user.param.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * 用户注册参数
 * @author wrp
 * @since 2026年04月24日 10:18
 **/
@Data
public class RegisterUserDTO {
    /**
     * 用户名
     */
    @NotEmpty
    @Schema(title = "用户名")
    private String username;
    /**
     * 密码（加密存储）
     */
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "密码必须包含字母、数字，最短8个字符")
    @Schema(title = "密码（加密存储）")
    private String password;
    /**
     * 昵称
     */
    @Schema(title = "昵称")
    private String nickname;
    /**
     * 邮箱
     */
    @Email
    @NotEmpty
    @Schema(title = "邮箱")
    private String email;
    /**
     * 手机号
     */
    @Schema(title = "手机号")
    private String phone;
    /**
     * 头像URL
     */
    @Schema(title = "头像URL")
    private String avatar;
    /**
     * 性别：0-未知 1-男 2-女
     */
    @Schema(title = "性别：0-未知 1-男 2-女")
    private Integer gender;
}
