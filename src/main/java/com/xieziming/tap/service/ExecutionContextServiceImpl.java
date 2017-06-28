/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.model.execution.ExecutionContext;
import com.xieziming.tap.repository.ExecutionContextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Suny on 6/28/17.
 */
@Service
public class ExecutionContextServiceImpl implements ExecutionContextService {
    @Autowired
    ExecutionContextRepository executionContextRepository;

    @Override
    public ExecutionContext findOne(String name) {
        return executionContextRepository.findOne(name);
    }

    @Override
    public Iterable<ExecutionContext> findAll() {
        return executionContextRepository.findAll();
    }

    @Override
    public ExecutionContext save(ExecutionContext executionContext) {
        return executionContextRepository.save(executionContext);
    }

    @Override
    public void delete(String name) {
        executionContextRepository.delete(name);
    }
}
