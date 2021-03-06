/*
 * Copyright 2012-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not
 * use this file except in compliance with the License. A copy of the License is
 * located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.cron;

import com.amazonaws.services.simpleworkflow.flow.ActivityExecutionContext;
import com.amazonaws.services.simpleworkflow.flow.ActivityExecutionContextProvider;
import com.amazonaws.services.simpleworkflow.flow.ActivityExecutionContextProviderImpl;
import com.amazonaws.services.simpleworkflow.model.ActivityTask;

public class CronExampleActivitiesImpl implements CronExampleActivities {

    final ActivityExecutionContextProvider contextProvider;

    public CronExampleActivitiesImpl() {
        this(new ActivityExecutionContextProviderImpl());
    }

    /**
     * Useful for unit testing activities.
     */
    public CronExampleActivitiesImpl(ActivityExecutionContextProvider contextProvider) {
        this.contextProvider = contextProvider;
    }

    /**
     * 
     */
    @Override
    public void doSomeWork(String parameter) {
        ActivityExecutionContext context = contextProvider.getActivityExecutionContext();
        ActivityTask task = context.getTask();
        String taskid = task.getActivityId();
        System.out.println("Processed activity task with id: " + taskid);
    }

}
