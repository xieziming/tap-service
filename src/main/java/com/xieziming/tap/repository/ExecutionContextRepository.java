/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.repository;
import com.xieziming.tap.model.execution.ExecutionContext;
import org.springframework.data.repository.CrudRepository;

public interface ExecutionContextRepository extends CrudRepository<ExecutionContext, String> {

}
