package api.financeira.api.repositories;

import api.financeira.api.models.AccountModel;
import api.financeira.api.models.SchedulingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<SchedulingModel,Long> {


}
