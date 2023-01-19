package api.financeira.api.services;

import api.financeira.api.exceptions.RequiredObjectIsNullException;
import api.financeira.api.exceptions.ResourceNotFoundException;
import api.financeira.api.models.AccountModel;
import api.financeira.api.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService {

    private final Logger logger = Logger.getLogger(AccountService.class.getName());

    @Autowired
    private AccountRepository repository;


    public List<AccountModel> findAll(){
       return repository.findAll();
    }

    public AccountModel findById(Long id){

        AccountModel account = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));

       return account ;
    }

    public AccountModel create (AccountModel account){
        return repository.save(account);
    }

    public AccountModel update (AccountModel account){
        if (account == null) throw new RequiredObjectIsNullException();

        AccountModel entity = repository.findById(account.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));

        entity.setOwner(account.getOwner());
        entity.setAccount(account.getAccount());
        entity.setAgency(account.getAgency());
        entity.setBankName(account.getBankName());

        return repository.save(entity);
    }

    public void delete(Long id){
        AccountModel entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));

        repository.delete(entity);
    }


}
