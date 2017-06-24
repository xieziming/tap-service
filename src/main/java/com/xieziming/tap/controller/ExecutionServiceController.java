/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import com.xieziming.tap.model.execution.Execution;
import com.xieziming.tap.service.ExecutionSearchService;
import com.xieziming.tap.service.ExecutionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/execution")
public class ExecutionServiceController {
    @Autowired
    ExecutionService executionService;

    @Autowired
    ExecutionSearchService executionSearchService;

    @ApiOperation(value="Save an execution", notes="Save an execution via a POST/PUT request")
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.PUT, RequestMethod.POST})
    public Execution save(@RequestBody Execution execution){
        return executionService.save(execution);
    }

    @ApiOperation(value="Find an execution", notes="Find an execution via a GET request")
    @ApiImplicitParam(name = "id", value = "execution id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Execution find(@PathVariable Integer id){
        return executionSearchService.findOne(id);
    }

    @ApiOperation(value="Delete an execution", notes="Delete an execution via a DELETE request")
    @ApiImplicitParam(name = "id", value = "execution id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        executionService.delete(id);
    }
}
