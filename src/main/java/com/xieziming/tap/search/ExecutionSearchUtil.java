/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.search;


import com.xieziming.tap.model.execution.Execution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Suny on 6/11/17.
 */
public class ExecutionSearchUtil {

    public static List<Execution> executionsAnd(List<Execution> executions1, List<Execution> executions2){
        List<Execution> executions = new LinkedList<>();

        Set<Integer> executionIds = new HashSet<>();
        for(Execution execution : executions1){
            executionIds.add(execution.getId());
        }

        for(Execution execution : executions2){
            if(executionIds.contains(execution.getId())) {
                executions.add(execution);
            }
        }
        return executions;
    }

    public static List<Execution> executionsOr(List<Execution> executions1, List<Execution> executions2){
        List<Execution> executions = new LinkedList<>();

        Set<Integer> executionIds = new HashSet<>();
        for(Execution execution : executions1){
            executionIds.add(execution.getId());
            executions.add(execution);
        }

        for(Execution execution : executions2){
            if(!executionIds.contains(execution.getId())) {
                executions.add(execution);
            }
        }
        return executions;
    }
}
