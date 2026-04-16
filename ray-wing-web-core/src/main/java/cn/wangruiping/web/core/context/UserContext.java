package cn.wangruiping.web.core.context;

import lombok.Data;

import java.util.Set;

/**
 *
 * @author wrp
 * @since 2026年04月16日 16:30
 **/
@Data
public class UserContext {
    private Long userId;
    private String username;
    private Long tenantId;
    private Set<String> roles;
    private Set<String> permissions;
}
