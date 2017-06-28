/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import com.xieziming.tap.model.testcase.TestCase;
import com.xieziming.tap.service.TestCaseSearchService;
import com.xieziming.tap.service.TestCaseService;
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

    @ApiOperation(value="Save a test case", notes="Save a test case via a POST/PUT request")
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.PUT, RequestMethod.POST})
    public TestCase save(@RequestBody TestCase testCase){
        return testCaseService.save(testCase);
    }

    @ApiOperation(value="Find a test case", notes="Find a test case via a GET request")
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public TestCase find(@PathVariable String uid){
        return testCaseSearchService.findOne(uid);
    }

    @ApiOperation(value="Delete a test case", notes="Delete a test case via a GET request")
    @RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String uid){
        testCaseService.delete(uid);
    }
}
