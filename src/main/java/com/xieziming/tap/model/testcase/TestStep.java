/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.model.testcase;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;

/**
 * Created by Suny on 5/22/16.
 */
@Data
@Entity
@Table(name="test_step", uniqueConstraints = {@UniqueConstraint(columnNames={"test_case_uid", "stepNo"})})
public class TestStep {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=10)
    private Integer stepNo;

    @Column(length = 100, nullable = false)
    private String operator;

    @Column(columnDefinition="TEXT")
    private String parameter;

    @Column(length=500)
    private String remark;

    @Override
    public String toString() {
        return "TestStep{" +
                "id=" + id +
                ", stepNo=" + stepNo +
                ", operator=" + operator +
                ", parameter=" + parameter +
                ", remark=" + remark +
                "}";
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && TestStep.class.isAssignableFrom(o.getClass())){
            TestStep ts = (TestStep) o;
            equals = (new EqualsBuilder()
                    .append(stepNo, ts.getStepNo())
                    .append(operator, ts.getOperator())
                    .append(parameter, ts.getParameter())
                    .append(remark, ts.getRemark()).isEquals());
        }
        return equals;
    }
}
