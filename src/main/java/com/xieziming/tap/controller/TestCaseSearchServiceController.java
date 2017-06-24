/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import com.xieziming.tap.dto.TestCaseFolder;
import com.xieziming.tap.model.testcase.TestCase;
import com.xieziming.tap.search.SearchCondition;
import com.xieziming.tap.service.TestCaseSearchService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/testcase/search")
public class TestCaseSearchServiceController {
    @Autowired
    TestCaseSearchService testCaseSearchService;

    @ApiOperation(value="Search test cases", notes="Search test cases via a POST/PUT request")
    @ApiImplicitParam(name = "SearchCondition", value = "the search condition", required = true, dataType = "SearchCondition")
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.PUT, RequestMethod.POST})
    public List<TestCase> search(@RequestBody SearchCondition searchCondition) throws Exception {
        return testCaseSearchService.findByConditions(searchCondition);
    }

    @ApiOperation(value="Search test case folder", notes="Search test case folder via a POST/PUT request")
    @ApiImplicitParam(name = "path", value = "test case path", required = true, dataType = "String")
    @RequestMapping(value = "/path", method = RequestMethod.POST)
    public TestCaseFolder retrievePath(@RequestParam String path){
        return testCaseSearchService.getTestCaseFolder(path);
    }
}
