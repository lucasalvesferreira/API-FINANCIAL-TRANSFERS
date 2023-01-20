package api.financeira.api.repositories;

import api.financeira.api.dtos.response.SchedulingResponse;
import api.financeira.api.models.AccountModel;
import api.financeira.api.models.SchedulingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SchedulingRepository extends JpaRepository<SchedulingModel,Long> {


    List<SchedulingModel> findByAppointmentDate(LocalDate date);
}
