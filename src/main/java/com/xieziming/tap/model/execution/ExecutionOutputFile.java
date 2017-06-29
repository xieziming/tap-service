/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.model.execution;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Suny on 5/8/17.
 */
@Data
@Entity
@Table(name="execution_output_file", uniqueConstraints = {@UniqueConstraint(columnNames={"execution_id", "path"})})
public class ExecutionOutputFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=100)
    @NotEmpty
    private String path;

    @Column(length=100)
    private String remark;

    @Override
    public String toString() {
        return "ExecutionOutputFile{" +
                "id=" + id +
                ", path=" + path +
                ", remark=" + remark +
                '}';
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && ExecutionOutputFile.class.isAssignableFrom(o.getClass())){
            ExecutionOutputFile executionOutputFile = (ExecutionOutputFile) o;
            equals = (new EqualsBuilder()
                    .append(path, executionOutputFile.getPath())
                    .append(remark, executionOutputFile.getRemark())
                    .isEquals());
        }
        return equals;
    }
}
