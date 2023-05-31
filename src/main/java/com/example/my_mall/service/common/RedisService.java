package com.example.my_mall.service.common;

import java.io.Serializable;

public interface RedisService {

    void set(String key, Serializable value);

    void set(String key, Serializable value, long expire);

    Serializable get(String key);

    boolean expire(String key, long expire);

    void remove(String key);

    Long increment(String key, long step);
}
