/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.dto.TestCaseFolder;
import com.xieziming.tap.search.SearchCondition;
import com.xieziming.tap.model.testcase.TestCase;

import java.util.List;

/**
 * Created by Suny on 6/11/17.
 */
public interface TestCaseSearchService {
    TestCase findOne(String uid);
    Iterable<TestCase> findAll();
    List<TestCase> findByConditions(SearchCondition searchCondition) throws Exception;
    TestCaseFolder getTestCaseFolder(String path);
}
