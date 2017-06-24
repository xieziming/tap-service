/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.model.execution.Execution;
import com.xieziming.tap.repository.ExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Suny on 5/31/17.
 */
@Service
public class ExecutionServiceImpl implements ExecutionService{
    @Autowired
    ExecutionRepository executionRepository;

    @Override
    public Execution save(Execution execution) {
        Execution executionSaved = executionRepository.save(execution);
        return executionSaved;
    }

    @Override
    public void delete(Integer id){
        executionRepository.delete(id);
    }

}
