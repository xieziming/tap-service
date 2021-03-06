/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.model.testcase;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Suny on 5/22/17.
 */
@Data
@Entity
@Table(name="test_case")
public class TestCase {
    @Id
    @Column(length = 50)
    @NotEmpty
    private String uid;

    @Column(length=100, nullable = false)
    @NotEmpty
    private String path;

    @Column(length = 100)
    @NotEmpty
    private String name;

    @Column(length=500)
    private String description;

    @Column(length=50)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private Date createdTime;

    @OneToMany(targetEntity = TestCaseMeta.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_case_uid")
    private List<TestCaseMeta> testCaseMetas;

    @OneToMany(targetEntity = TestStep.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_case_uid")
    private List<TestStep> testSteps;

    @OneToMany(targetEntity = TestData.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_case_uid")
    private List<TestData> testDatas;

    @OneToMany(targetEntity = TestCaseTag.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "test_case_uid")
    private List<TestCaseTag> testCaseTags;

    @Override
    public String toString() {
        return "TestCase{" +
                "uid=" + uid +
                ", path=" + path +
                ", name=" + name +
                ", description=" + description +
                ", status=" + status +
                ", createdTime=" + createdTime +
                "}";
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && TestCase.class.isAssignableFrom(o.getClass())){
            TestCase tc = (TestCase) o;
            equals = (new EqualsBuilder()
                    .append(path, tc.getPath())
                    .append(name, tc.getName())
                    .append(status, tc.getStatus())
                    .append(description, tc.getDescription())
                    .append(testCaseMetas, tc.getTestCaseMetas())
                    .append(testDatas, tc.getTestDatas())
                    .append(testSteps, tc.getTestSteps()).isEquals());
        }
        return equals;
    }
}
