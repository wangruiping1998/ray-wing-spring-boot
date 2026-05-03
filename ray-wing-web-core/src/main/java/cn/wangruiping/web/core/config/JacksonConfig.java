package cn.wangruiping.web.core.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

/**
 * 序列化配置
 * @author wrp
 * @since 2025年08月18日 16:14
 **/
@Configuration
public class JacksonConfig {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";

    @Bean
    @Primary
    public JsonMapper jsonMapper() {
        // 1. 配置时间模块

        // 2. 配置 Long 类型转 String（防止前端精度丢失）
        SimpleModule longModule = new SimpleModule();
        longModule.addSerializer(Long.class, ToStringSerializer.instance);
        longModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        // 3. 构建 JsonMapper
        JsonMapper mapper = JsonMapper.builder()
                .addModule(longModule)
                .build();

        return mapper;
    }

}
