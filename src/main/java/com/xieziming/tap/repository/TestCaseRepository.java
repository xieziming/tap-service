/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */
package com.xieziming.tap.repository;

import com.xieziming.tap.model.testcase.TestCase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * A repository to manage {@link TestCase} instances.
 *
 * @author Suny Xie
 */
public interface TestCaseRepository extends PagingAndSortingRepository<TestCase, String>, CrudRepository<TestCase, String> {
    List<TestCase> findByName(String name);
    List<TestCase> findByPath(String path);
    List<TestCase> findByPathStartingWith(String path);
    List<TestCase> findByStatus(String status);
    List<TestCase> findByNameContaining(String name);
    List<TestCase> findByDescriptionContaining(String description);
    Integer countByPath(String path);
    Integer countByPathStartingWith(String path);

    @Query("SELECT DISTINCT path FROM TestCase WHERE path LIKE ?1%")
    List<String> findPathStartingWith(String path);
}
