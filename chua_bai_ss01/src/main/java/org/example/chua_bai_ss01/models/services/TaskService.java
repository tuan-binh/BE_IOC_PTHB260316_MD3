package org.example.chua_bai_ss01.models.services;

import lombok.RequiredArgsConstructor;
import org.example.chua_bai_ss01.models.dto.req.AssignmentReq;
import org.example.chua_bai_ss01.models.entities.Task;
import org.example.chua_bai_ss01.models.entities.User;
import org.example.chua_bai_ss01.models.repositories.TaskRepository;
import org.example.chua_bai_ss01.models.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public Task addTask(Task task) throws IllegalArgumentException {
        // kiểm tra assgin có tồn tại hay không
        boolean isExist = userRepository.users.stream().anyMatch(user -> user.getId().equals(task.getAssignedTo()));
        // tồn tại thì lưu không thì trả về null
        if (!isExist) {
            throw new IllegalArgumentException("User not found");
        }
        return taskRepository.addTask(task);
    }

    // có công việc, có người dùng nhưng muốn assign
    public Task assignTask(AssignmentReq req) throws IllegalArgumentException {

        Task task = taskRepository.tasks.stream().filter(t -> t.getId().equals(req.getTaskId())).findFirst().orElse(null);

        if(task == null) {
            throw new IllegalArgumentException("Task not found");
        }

        boolean isExist = userRepository.users.stream().anyMatch(user -> user.getId().equals(req.getUserId()));

        if(!isExist) {
            throw new IllegalArgumentException("User not found");
        }

        task.setAssignedTo(req.getUserId());
        return task;
    }

}
