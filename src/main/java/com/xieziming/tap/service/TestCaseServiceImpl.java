/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.model.execution.Execution;
import com.xieziming.tap.model.testcase.TestCase;
import com.xieziming.tap.repository.ExecutionRepository;
import com.xieziming.tap.repository.TestCaseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Suny on 5/31/17.
 */
@Service
public class TestCaseServiceImpl implements TestCaseService {
    @Autowired
    TestCaseRepository testCaseRepository;

    @Autowired
    ExecutionRepository executionRepository;

    @Override
    public TestCase save(TestCase testCase) {

        String path = testCase.getPath();
        if(path.endsWith("/")) testCase.setPath(StringUtils.chop(path));

        TestCase executionSaved = testCaseRepository.save(testCase);
        return executionSaved;
    }

    @Override
    @Transactional
    public void delete(String uid){
        List<Execution> executions = executionRepository.findByTestCase(uid);
        for(Execution execution : executions){
            executionRepository.delete(execution);
        }

        testCaseRepository.delete(uid);
    }
}
