package To.Do.List.TDL_SB.Services;

import To.Do.List.TDL_SB.Models.TaskModel;
import To.Do.List.TDL_SB.Repositories.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {
    private TaskRepo repo;


    public List<TaskModel> getAllToDoItems() {
        ArrayList<TaskModel> todoList = new ArrayList<>();
        repo.findAll().forEach(todo -> todoList.add(todo));

        return todoList;
    }

    public TaskModel getToDoItemById(Long id) {
        return repo.findById(Math.toIntExact(id)).get();
    }

    public TaskModel addTask(TaskModel taskModel){
       return repo.save(taskModel);
    }

    @Override
    public TaskModel getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteTask(Integer id){
        repo.deleteById(id);
    }

    public List<TaskModel> getAll(){
        return repo.findAll();
    }

    public void update(TaskModel taskModel){
        TaskModel taskModel1=getById(taskModel.getId());
        if(taskModel1!=null){
            taskModel1.setTitle(taskModel.getTitle());
            repo.save(taskModel1);
        }


    }

    @Override
    public TaskModel updateTask(Integer id, TaskModel taskModel) {
        return repo.findById(id).map(task -> {
           task.setTitle(taskModel.getTitle());
           task.setDate(taskModel.getDate());
           //task.setCompleted();
            return repo.save(task);
        }).orElseThrow(()->new RuntimeException("Task not found"));
    }

//    public boolean updateStatus(Long id) {
//        TaskModel task = getToDoItemById(id);
//        task.setCompleted(Boolean.parseBoolean("Completed"));
//
//        return saveOrUpdateToDoItem(task);
//    }
//    public TaskModel addTask(TaskModel taskModel){
//        return repo.save(taskModel);
//    }
//
//    public boolean saveOrUpdateToDoItem(TaskModel task) {
//        TaskModel updatedObj = repo.save(task);
//        if (getToDoItemById(Long.valueOf(updatedObj.getId())) != null) {
//            return true;
//        }
//
//        return false;
//    }
//
//    public boolean deleteToDoItem(Integer id) {
//        repo.deleteById(Math.toIntExact(Long.valueOf(id)));
//
//        if (repo.findById(Math.toIntExact(Long.valueOf(id))).isEmpty()) {
//            return true;
//        }
//
//        return false;
//    }

}
