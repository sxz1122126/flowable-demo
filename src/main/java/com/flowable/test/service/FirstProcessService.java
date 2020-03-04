/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.flowable.test.service;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunxz
 * @Description:
 * @date 20/03/04
 */
@Service
public class FirstProcessService {

        @Autowired
        private RuntimeService runtimeService;

        @Autowired
        private TaskService taskService;

        @Transactional
        public void startProcess() {
            runtimeService.startProcessInstanceByKey("oneTaskProcess");
        }

        @Transactional
        public List<Task> getTasks(String assignee) {
            return taskService.createTaskQuery().taskAssignee(assignee).list();
        }
}
