/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.model.execution.ExecutionContext;

/**
 * Created by Suny on 6/28/17.
 */
public interface ExecutionContextService {
    ExecutionContext findOne(String name);
    Iterable<ExecutionContext> findAll();
    ExecutionContext save(ExecutionContext executionContext);
    void delete(String name);
}
