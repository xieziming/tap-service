/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.dto;

import com.xieziming.tap.model.testcase.TestCase;
import lombok.Data;

import java.util.List;

/**
 * Created by Suny on 6/14/17.
 */
@Data
public class TestCaseFolder {
    private String path;
    private List<TestCaseFolder> testCaseFolders;
    private List<TestCase> testCases;
}
