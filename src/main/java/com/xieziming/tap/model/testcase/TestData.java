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
 * Created by Suny on 5/22/16.
 */
@Data
@Entity
@Table(name="test_data")
public class TestData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 50, nullable=false)
    @NotEmpty
    private String field;

    @Column(columnDefinition="TEXT")
    private String value;

    @Column(length=500)
    private String remark;

    @Override
    public String toString() {
        return "TestData{" +
                "id=" + id +
                ", field=" + field +
                ", value=" + value +
                ", remark=" + remark +
                "}";
    }


    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && TestData.class.isAssignableFrom(o.getClass())){
            TestData td = (TestData) o;
            equals = (new EqualsBuilder()
                    .append(field, td.getField())
                    .append(value, td.getValue())
                    .append(remark, td.getRemark()).isEquals());
        }
        return equals;
    }
}
