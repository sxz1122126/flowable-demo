/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.flowable.test.controller;

import com.flowable.test.service.FirstProcessService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunxz
 * @Description:
 * @date 20/03/04
 */
@RestController
public class FirstProcessController {

        @Autowired
        private FirstProcessService myService;

        @PostMapping(value="/process")
        public void startProcessInstance() {
            myService.startProcess();
        }

        @GetMapping(value="/tasks", produces= MediaType.APPLICATION_JSON_VALUE)
        public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
            List<Task> tasks = myService.getTasks(assignee);
            List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
            for (Task task : tasks) {
                dtos.add(new TaskRepresentation(task.getId(), task.getName()));
            }
            return dtos;
        }

        static class TaskRepresentation {

            private String id;
            private String name;

            public TaskRepresentation(String id, String name) {
                this.id = id;
                this.name = name;
            }

            public String getId() {
                return id;
            }
            public void setId(String id) {
                this.id = id;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }

        }
}
