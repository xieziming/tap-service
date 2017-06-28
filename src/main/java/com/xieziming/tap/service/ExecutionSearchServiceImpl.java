/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.service;

import com.xieziming.tap.dto.ExecutionFolder;
import com.xieziming.tap.model.execution.Execution;
import com.xieziming.tap.repository.ExecutionRepository;
import com.xieziming.tap.search.ExecutionSearchUtil;
import com.xieziming.tap.search.SearchCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Suny on 6/8/17.
 */
@Service
public class ExecutionSearchServiceImpl implements ExecutionSearchService{
    @Autowired
    ExecutionRepository executionRepository;


    @Override
    @Cacheable(value = "execution_search", key = "#id")
    public Execution findOne(Integer id) {
        return executionRepository.findOne(id);
    }

    @Override
    @Cacheable(value = "execution_search", key = "'find_all'")
    public Iterable<Execution> findAll() {
        return executionRepository.findAll();
    }


    @Override
    @Cacheable(value = "execution_search", key = "'execution_folder_'+#path")
    public ExecutionFolder getExecutionFolder(String path) {
        ExecutionFolder executionFolder = new ExecutionFolder();
        executionFolder.setPath(path);
        List<Execution> executions = executionRepository.findByPath(path);
        for(Execution execution : executions){
            execution.setExecutionLogs(null);
            execution.setExecutionOutputTexts(null);
            execution.setExecutionOutputFiles(null);
        }
        executionFolder.setExecutions(executions);

        List<ExecutionFolder> subFolders = new ArrayList<>();
        Set<String> subTestCaseFolderPaths = getSubExecutionFolderPaths(path);
        for(String subTestCaseFolderPath : subTestCaseFolderPaths){
            subFolders.add(getExecutionFolder(subTestCaseFolderPath));
        }
        executionFolder.setExecutionFolders(subFolders);
        return executionFolder;
    }

    @Override
    @Cacheable(value = "execution_search")
    public List<Execution> findByConditions(SearchCondition searchCondition) throws Exception {
        List<Execution> executions = findByCondition(searchCondition);

        if(searchCondition.getOtherCondition() != null){
            List<Execution> otherExecutions = findByConditions(searchCondition.getOtherCondition());
            if("And".equalsIgnoreCase(searchCondition.getAndOr())){
                return ExecutionSearchUtil.executionsAnd(executions, otherExecutions);
            }else if("Or".equalsIgnoreCase(searchCondition.getAndOr())){
                return ExecutionSearchUtil.executionsOr(executions, otherExecutions);
            }else {
                throw new Exception("bad condition relation, only 'And' or 'Or' allowed!");
            }
        }

        return executions;
    }

    private List<Execution> findByCondition(SearchCondition searchCondition){
        String condition = searchCondition.getCondition();
        String value = searchCondition.getValue();

        if(condition == null || condition.isEmpty()) return null;
        if("Status".equalsIgnoreCase(condition)){
            return executionRepository.findByStatus(value);
        }else if("Result".equalsIgnoreCase(condition)){
            return executionRepository.findByResult(value);
        }else if("Path".equalsIgnoreCase(condition)){
            return executionRepository.findByPath(value);
        }else if("TestCase".equalsIgnoreCase(condition)){
            return executionRepository.findByTestCase(value);
        }
        return null;
    }

    private Set<String> getSubExecutionFolderPaths(String currentPath){
        if(currentPath.endsWith("/")) currentPath = StringUtils.chop(currentPath);
        List<String> subPaths = executionRepository.findPathStartingWith(currentPath + "/");

        Set<String> uniquePaths = new HashSet<>();
        for(String thePath : subPaths){
            String folder = thePath.replace(currentPath,"").replaceFirst("/","");
            String path = currentPath + "/" + folder.split("/")[0];
            uniquePaths.add(path);
        }

        return uniquePaths;
    }
}
