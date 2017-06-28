/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.controller;

import com.xieziming.tap.model.execution.ExecutionContext;
import com.xieziming.tap.service.ExecutionContextService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/execution/context")
public class ExecutionContextController {
    @Autowired
    ExecutionContextService executionContextService;

    @ApiOperation(value="Save an execution context", notes="Save an execution context via a POST/PUT request")
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.PUT, RequestMethod.POST})
    public ExecutionContext save(@RequestBody ExecutionContext executionContext){
        return executionContextService.save(executionContext);
    }

    @ApiOperation(value="Find an execution context", notes="Find an execution context via a GET request")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ExecutionContext find(@PathVariable String name){
        return executionContextService.findOne(name);
    }

    @ApiOperation(value="Delete an execution context", notes="Delete an execution context via a GET request")
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String name){
        executionContextService.delete(name);
    }

    @ApiOperation(value="Find all execution contexts", notes="Find all execution contexts via a GET request")
    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public Iterable<ExecutionContext> findAll(){
        return executionContextService.findAll();
    }
}
