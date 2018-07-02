package com.example.demoswagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zenglw
 * @date 2018/7/2
 */
@RestController
@Api(tags = "Hello Swagger")
public class Hello {

    @ApiOperation("Hello")
    @GetMapping("/hello")
    public String hello () {
        return "Hello";
    }
}
