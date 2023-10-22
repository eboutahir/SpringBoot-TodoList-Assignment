package To.Do.List.TDL_SB.Services;

import To.Do.List.TDL_SB.Models.TaskModel;

import java.util.List;

public interface TaskService {
    TaskModel addTask(TaskModel taskModel);
    TaskModel getById(Integer id);
    void deleteTask(Integer id);
    List<TaskModel> getAll();
    void update(TaskModel taskModel);
    TaskModel updateTask(Integer id, TaskModel taskModel);


}
