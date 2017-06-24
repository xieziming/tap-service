/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.dto.ExecutionFolder;
import com.xieziming.tap.model.execution.Execution;
import com.xieziming.tap.search.SearchCondition;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Suny on 6/8/17.
 */
@Service
public interface ExecutionSearchService {
    Execution findOne(Integer id);
    Iterable<Execution> findAll();
    List<Execution> findByConditions(SearchCondition searchCondition) throws Exception;
    ExecutionFolder getExecutionFolder(String path);
}
