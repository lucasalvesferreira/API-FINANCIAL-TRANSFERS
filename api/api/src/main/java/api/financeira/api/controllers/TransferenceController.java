package api.financeira.api.controllers;

import api.financeira.api.dtos.request.SchedulingRequest;
import api.financeira.api.dtos.response.SchedulingResponse;
import api.financeira.api.services.AccountService;
import api.financeira.api.services.SchedulingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transfer")
@Tag(name = "Transference",description = "Endpoints for Managing transfer")
public class TransferenceController {

    @Autowired
    private SchedulingService service;

    @PostMapping("/")
    public ResponseEntity<SchedulingResponse> postScheduling(@RequestBody SchedulingRequest request){
        return ResponseEntity.ok(service.postScheduling(request));
    }


}

