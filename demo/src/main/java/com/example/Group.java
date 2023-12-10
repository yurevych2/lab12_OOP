package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group<T> extends Task<T> {
    private List<Task<T>> tasks;
    private String groupUuid;

    public Group() {
        this.groupUuid = UUID.randomUUID().toString();
    }

    public Group<T> addTask(Task<T> task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        for (Task<T> task : tasks) {
            task.setHeader("groupId", this.groupUuid);
            task.freeze();
        }
        this.setHeader("stamps", this.groupUuid);
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        tasks = Collections.unmodifiableList(tasks);
        for (Task<T> task : tasks) {
            task.apply(arg);
        }
    }
}
