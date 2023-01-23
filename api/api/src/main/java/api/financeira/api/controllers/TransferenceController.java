package api.financeira.api.controllers;

import api.financeira.api.dtos.request.SchedulingRequest;
import api.financeira.api.dtos.response.SchedulingResponse;
import api.financeira.api.models.SchedulingModel;
import api.financeira.api.services.SchedulingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transfer")
@Tag(name = "Transference",description = "Endpoints for Managing transfer")
public class TransferenceController {

    @Autowired
    private SchedulingService service;

    @GetMapping("/")
    public ResponseEntity<List<SchedulingModel>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SchedulingModel> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/date/{date}")
    public ResponseEntity<List<SchedulingModel>> findByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.ok(service.findByDate(date));
    }
    @PostMapping("/")
    public ResponseEntity<SchedulingResponse> postScheduling(@RequestBody SchedulingRequest request){
        return ResponseEntity.ok(service.postScheduling(request));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

