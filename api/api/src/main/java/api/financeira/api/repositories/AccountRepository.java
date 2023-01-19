package api.financeira.api.repositories;

import api.financeira.api.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel,Long> {


}
