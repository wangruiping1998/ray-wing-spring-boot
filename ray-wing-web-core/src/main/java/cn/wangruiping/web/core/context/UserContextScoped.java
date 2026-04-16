package cn.wangruiping.web.core.context;


import org.apache.catalina.User;

import java.lang.ScopedValue;
import java.util.function.Supplier;

/**
 *
 * 用户信息上下文
 * @author wrp
 * @since 2026年04月16日 16:27
 **/
public class UserContextScoped {

    // ScopedValue 是 Java 21 的预览特性，需要启用预览功能
    private static final ScopedValue<UserContext> CURRENT_USER = ScopedValue.newInstance();

    public static <T> T runWithUser(UserContext user, Supplier<T> operation) {
        return ScopedValue.where(CURRENT_USER, user).call(operation::get);
    }

    public static UserContext getCurrentUser() {
        return CURRENT_USER.get();
    }
}
