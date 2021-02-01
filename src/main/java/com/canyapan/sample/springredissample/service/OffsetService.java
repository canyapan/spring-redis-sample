package com.canyapan.sample.springredissample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class OffsetService {
    private Long offset = -1L;

    @Cacheable(cacheNames = "offset")
    public Long getOffset() {
        log.info("Get offset");
        return offset;
    }

    @CachePut(cacheNames = "offset")
    public Long randomOffset() {
        offset = new Random().nextLong();
        return offset;
    }
}
