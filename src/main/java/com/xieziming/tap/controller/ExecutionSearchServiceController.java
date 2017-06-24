/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import com.xieziming.tap.dto.ExecutionFolder;
import com.xieziming.tap.model.execution.Execution;
import com.xieziming.tap.search.SearchCondition;
import com.xieziming.tap.service.ExecutionSearchService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/execution/search")
public class ExecutionSearchServiceController {
    @Autowired
    ExecutionSearchService executionSearchService;

    @ApiOperation(value="Search executions", notes="Search executions via a POST/PUT request")
    @ApiImplicitParam(name = "SearchCondition", value = "the search condition", required = true, dataType = "SearchCondition")
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.PUT, RequestMethod.POST})
    public List<Execution> search(@RequestBody SearchCondition searchCondition) throws Exception {
        return executionSearchService.findByConditions(searchCondition);
    }

    @ApiOperation(value="Search execution folder", notes="Search execution folder via a POST/PUT request")
    @ApiImplicitParam(name = "path", value = "execution path", required = true, dataType = "String")
    @RequestMapping(value = "/path", method = RequestMethod.POST)
    public ExecutionFolder retrievePath(@RequestParam String path){
        return executionSearchService.getExecutionFolder(path);
    }
}
