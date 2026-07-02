package org.example.chua_bai_ss01.models.repositories;

import org.example.chua_bai_ss01.models.entities.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TaskRepository {

    public List<Task> tasks = new ArrayList<>(
            Arrays.asList(
                    new Task(1, "[API] Chức năng đăng nhập", "Người dùng nhập username và password", "high", null)
            )
    );

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }


}
