package com.imooc.web1.common;

public enum RateLimitMethodEnum {
    //initialize rate limiter
    init,

    //modify rate limiter parameter
    modify,

    //delete rate limiter
    delete,

    //acquire permits
    acquire;
}
