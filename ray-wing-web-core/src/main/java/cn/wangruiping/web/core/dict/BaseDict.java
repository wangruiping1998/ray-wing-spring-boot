package cn.wangruiping.web.core.dict;

/**
 * @author wrp
 * @since 2025年07月04日 21:18
 */
public interface BaseDict {

    /**
     * 获取编码，编码尽量在Int缓存间-128 and 127 (inclusive)
     */
    Integer getCode();

    /**
     * 获取值
     */
    String getDesc();
}
