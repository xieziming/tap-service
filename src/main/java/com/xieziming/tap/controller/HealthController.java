/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/health")
public class HealthController {
    @ApiOperation(value="Health check", notes="Check whether service is up via a GET request")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String health(){
        return "{\"status\" : \"ok\"}";
    }
}
