/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import com.xieziming.tap.service.TestCaseSearchService;
import com.xieziming.tap.service.TestCaseService;
import com.xieziming.tap.model.testcase.TestCase;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/testcase")
public class TestCaseServiceController {
    @Autowired
    TestCaseService testCaseService;

    @Autowired
    TestCaseSearchService testCaseSearchService;

    @ApiOperation(value="Save an test case", notes="Save an test case via a POST/PUT request")
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.PUT, RequestMethod.POST})
    public TestCase save(@RequestBody TestCase testCase){
        return testCaseService.save(testCase);
    }

    @ApiOperation(value="Find an test case", notes="Find an test case via a GET request")
    @ApiImplicitParam(name = "uid", value = "test case uid", required = true, dataType = "String")
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public TestCase find(@PathVariable String uid){
        return testCaseSearchService.findOne(uid);
    }

    @ApiOperation(value="Delete an test case", notes="Delete an test case via a GET request")
    @ApiImplicitParam(name = "id", value = "test case uid", required = true, dataType = "String")
    @RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String uid){
        testCaseService.delete(uid);
    }
}
