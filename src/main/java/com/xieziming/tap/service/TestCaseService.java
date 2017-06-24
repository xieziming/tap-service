/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.model.testcase.TestCase;

/**
 * Created by Suny on 5/31/17.
 */
public interface TestCaseService {
    TestCase save(TestCase testCase);
    void delete(String uid);
}
