package To.Do.List.TDL_SB.Repositories;

import To.Do.List.TDL_SB.Models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<TaskModel, Integer> {

}