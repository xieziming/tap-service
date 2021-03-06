/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.model.testcase;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Suny on 5/22/17.
 */
@Data
@Entity
@Table(name="test_case_relation", uniqueConstraints = {@UniqueConstraint(columnNames={"test_case_uid", "related_test_case_uid", "relation"})})
public class TestCaseRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private TestCase testCase;

    @ManyToOne(cascade = CascadeType.ALL)
    private TestCase relatedTestCase;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String relation;

    @Override
    public String toString() {
        return "TestCaseRelation{" +
                "id=" + id +
                ", testCase=" + testCase +
                ", relatedTestCase=" + relatedTestCase +
                ", relation=" + relation +
                "}";
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && TestCaseRelation.class.isAssignableFrom(o.getClass())){
            TestCaseRelation tr = (TestCaseRelation) o;
            equals = (new EqualsBuilder()
                    .append(testCase.getUid(), tr.testCase.getUid())
                    .append(relatedTestCase.getUid(), tr.relatedTestCase.getUid())
                    .append(relation, tr.getRelation()).isEquals());
        }
        return equals;
    }
}
