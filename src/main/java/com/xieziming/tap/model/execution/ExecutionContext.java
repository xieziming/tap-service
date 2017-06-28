/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.model.execution;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Suny on 5/8/16.
 */
@Data
@Entity
@Table(name="execution_context")
public class ExecutionContext {
    @Id
    @Column(length = 50)
    @NotEmpty
    private String name;

    @Column(columnDefinition="TEXT")
    private String context;

    @Column(length=200)
    private String remark;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;

    @Override
    public String toString() {
        return "ExecutionContext{" +
                "name=" + name +
                ", context=" + context +
                ", remark=" + remark +
                ", lastModified=" + lastModified +
                '}';
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && ExecutionContext.class.isAssignableFrom(o.getClass())){
            ExecutionContext executionContext = (ExecutionContext) o;
            equals = (new EqualsBuilder()
                    .append(name, executionContext.getName())
                    .append(context, executionContext.getContext())
                    .append(remark, executionContext.getRemark())
                    .append(lastModified, executionContext.getLastModified())
                    .isEquals());
        }
        return equals;
    }
}
