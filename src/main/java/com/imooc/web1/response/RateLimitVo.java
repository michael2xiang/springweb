package com.imooc.web1.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateLimitVo {
    private String url;

    private boolean isLimit;

    private Double interval;

    private Integer maxPermits;

    private Integer initialPermits;

}
