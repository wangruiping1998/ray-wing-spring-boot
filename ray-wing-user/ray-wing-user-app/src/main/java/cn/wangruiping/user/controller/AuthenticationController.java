package cn.wangruiping.user.controller;

import cn.wangruiping.user.business.auth.AuthenticationService;
import cn.wangruiping.user.param.auth.RegisterUserDTO;
import cn.wangruiping.web.core.domain.Result;
import cn.wangruiping.web.core.util.ResultUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wrp
 * @since 2026年04月24日 10:25
 **/
@Tag(name = "认证接口")
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(summary = "用户名密码注册")
    @PostMapping("register")
    public Result<Void> register(@RequestBody @Validated RegisterUserDTO registerUserDTO) {

        authenticationService.register(registerUserDTO);
        return ResultUtils.success();
    }

}
