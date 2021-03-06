/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.search;

import com.xieziming.tap.model.testcase.TestCase;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Suny on 6/11/17.
 */
public class TestCaseSearchUtil {

    public static List<TestCase> testCasesAnd(List<TestCase> testCases1, List<TestCase> testCases2){
        List<TestCase> testCases = new LinkedList<>();

        Set<String> testCaseUids = new HashSet<>();
        for(TestCase testCase : testCases1){
            testCaseUids.add(testCase.getUid());
        }

        for(TestCase testCase : testCases2){
            if(testCaseUids.contains(testCase.getUid())) {
                testCases.add(testCase);
            }
        }
        return testCases;
    }

    public static List<TestCase> testCasesOr(List<TestCase> testCases1, List<TestCase> testCases2){
        List<TestCase> testCases = new LinkedList<>();

        Set<String> testCaseUids = new HashSet<>();
        for(TestCase testCase : testCases1){
            testCaseUids.add(testCase.getUid());
            testCases.add(testCase);
        }

        for(TestCase testCase : testCases2){
            if(!testCaseUids.contains(testCase.getUid())) {
                testCases.add(testCase);
            }
        }
        return testCases;
    }
}
