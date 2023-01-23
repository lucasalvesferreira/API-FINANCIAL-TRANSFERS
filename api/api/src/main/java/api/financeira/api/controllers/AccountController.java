package api.financeira.api.controllers;

import api.financeira.api.dtos.request.AccountRequest;
import api.financeira.api.models.AccountModel;
import api.financeira.api.services.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@Tag(name = "Account",description = "Endpoints for Managing account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/")
    public ResponseEntity<List<AccountModel>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountModel> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<AccountModel> create(@RequestBody AccountRequest account){
        return ResponseEntity.ok(service.create(account));
    }

    @PutMapping("/")
    public ResponseEntity<AccountModel> update(@RequestBody AccountModel accountModel){
        return ResponseEntity.ok(service.update(accountModel));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
