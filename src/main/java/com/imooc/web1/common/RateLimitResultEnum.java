package com.imooc.web1.common;

public enum RateLimitResultEnum {
    SUCCESS(1L),
    NO_LIMIT(0L),
    ACQUIRE_FAIL(-1L),
    MODIFY_ERROR(-2L),
    UNSUPPORT_METHOD(-500L),
    ERROR(-505L);

    private Long code;

    RateLimitResultEnum(Long code) {
        this.code = code;
    }


    public static RateLimitResultEnum getResult(Long code) {
        for (RateLimitResultEnum enums : RateLimitResultEnum.values()) {
            if (enums.code.equals(code)) {
                return enums;
            }
        }
        throw new IllegalArgumentException("unknown rate limit return code:" + code);
    }
}
