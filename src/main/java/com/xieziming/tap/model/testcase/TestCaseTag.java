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
 * Created by Suny on 5/8/17.
 */
@Data
@Entity
@Table(name="test_case_tag", uniqueConstraints = {@UniqueConstraint(columnNames={"test_case_uid", "tag"})})
public class TestCaseTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String tag;

    @Override
    public String toString() {
        return "TestCaseMeta{" +
                "id=" + id +
                ", tag=" + tag + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && TestCaseTag.class.isAssignableFrom(o.getClass())){
            TestCaseTag tcg = (TestCaseTag) o;
            equals = (new EqualsBuilder().append(tag, tcg.getTag()).isEquals());
        }
        return equals;
    }
}
