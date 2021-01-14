package com.canyapan.sample.springredissample.controller;


import com.canyapan.sample.springredissample.service.OffsetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offset/")
@RequiredArgsConstructor
public class OffsetController {

    private final OffsetService offsetService;

    @GetMapping("/random/")
    public Long randomOffset() {
        return offsetService.randomOffset();
    }

    @GetMapping("/")
    public Long getOffset() {
        return offsetService.getOffset();
    }
}
