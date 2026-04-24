package cn.wangruiping.web.core.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;
import tools.jackson.datatype.jsr310.JavaTimeModule;
import tools.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import tools.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import tools.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import tools.jackson.datatype.jsr310.ser.LocalDateSerializer;
import tools.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import tools.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        // 配置 LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));

        // 配置 LocalDate
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));

        // 配置 LocalTime
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));

        // 2. 配置 Long 类型转 String（防止前端精度丢失）
        SimpleModule longModule = new SimpleModule();
        longModule.addSerializer(Long.class, ToStringSerializer.instance);
        longModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        // 3. 构建 JsonMapper
        JsonMapper mapper = JsonMapper.builder()
                // 禁用时间戳格式
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                // 注册模块
                .addModule(javaTimeModule)
                .addModule(longModule)
                .build();

        return mapper;
    }

}
