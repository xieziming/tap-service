/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.dto;

import com.xieziming.tap.model.execution.Execution;
import lombok.Data;

import java.util.List;

/**
 * Created by Suny on 6/14/17.
 */
@Data
public class ExecutionFolder {
    private String path;
    private List<ExecutionFolder> executionFolders;
    private List<Execution> executions;
}
