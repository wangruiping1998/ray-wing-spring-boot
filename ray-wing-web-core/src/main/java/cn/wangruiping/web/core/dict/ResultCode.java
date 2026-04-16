package cn.wangruiping.web.core.dict;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wrp
 * @since 2025年07月04日 20:38
 */
@AllArgsConstructor
@Getter
public enum ResultCode implements BaseDict {
    ERROR(0, "失败"),
    SUCCESS(1, "成功"),
    ;

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String desc;
}
