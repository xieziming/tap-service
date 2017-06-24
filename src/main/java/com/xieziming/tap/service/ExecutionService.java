/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;


import com.xieziming.tap.model.execution.Execution;

/**
 * Created by Suny on 5/31/17.
 */
public interface ExecutionService {
    Execution save(Execution execution);
    void delete(Integer id);
}
