package api.financeira.api.services;

import api.financeira.api.dtos.request.SchedulingRequest;
import api.financeira.api.dtos.response.SchedulingResponse;
import api.financeira.api.exceptions.InvalidValueException;
import api.financeira.api.exceptions.ResourceNotFoundException;
import api.financeira.api.models.AccountModel;
import api.financeira.api.models.SchedulingModel;
import api.financeira.api.repositories.AccountRepository;
import api.financeira.api.repositories.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.logging.Logger;

@Service
public class SchedulingService {

    private final Logger logger = Logger.getLogger(AccountService.class.getName());
    @Autowired
    private SchedulingRepository schedulingRepository;
    @Autowired
    private AccountRepository accountRepository;


    public SchedulingResponse postScheduling(SchedulingRequest request) {

        logger.info("Checking if account exist!");
        if(!accountRepository.existsByAccount(request.getSourceAccount())) throw new ResourceNotFoundException("Source Account not Found!");
        if(!accountRepository.existsByAccount(request.getTargetAccount())) throw new ResourceNotFoundException("Target Account not Found!");

        // Verifica se o valor valido para transferir
        if (request.getTransferValue() < 0.50) throw new InvalidValueException("Invalid value for transfer!");

        // Verifica se a saldo na conta para transferir
        AccountModel sourceAccount = accountRepository.findByAccount(request.getSourceAccount());
        if (sourceAccount.getBalance() < 0.50) throw new InvalidValueException("Insufficient balance for transfer!");

        // Verifica se a data para tranfeirir e apos a de agendamento
        SchedulingModel scheduling = new SchedulingModel();
        if(request.getTransferDate().isBefore(scheduling.getAppointmentDate())) throw new InvalidValueException("Impossible to transfer to a date before the current one!");

        // Taxas
        Double taxaA = ((3.0 * request.getTransferValue())/100) + 3;
        Double taxaB = 12.0;


        // Se a tranferências no mesmo dia do agendamento e o valor e ate 1000 tem uma taxa de $3 mais 3% do valor a ser transferido;
        if (request.getTransferDate().equals(scheduling.getAppointmentDate()) && request.getTransferValue() <= 1000.0) {
            scheduling.setRate(taxaA);
        }

        // Se a tranferências no mesmo dia do agendamento e o valor e ate 2000 tem uma taxa 12;
        else if (request.getTransferDate().equals(scheduling.getAppointmentDate()) && request.getTransferValue() <= 2000.0) {
            scheduling.setRate(taxaB);
        }

        // Se a transfencia e até 10 dias da data de agendamento possuem uma taxa de $12.
        LocalDate dataAgendamento = scheduling.getAppointmentDate();
        LocalDate dataAgendamentoMais10 = scheduling.getAppointmentDate().plusDays(10);
        Duration duracao = Duration.between(dataAgendamento, dataAgendamentoMais10);

//        else if(request.getTransferDate() <= diaAgendamento ){
//            scheduling.setRate(taxaB);
//        }

        // Se a tranferências no mesmo dia do agendamento e o valor e maior que 2000
//        else if (request.getTransferDate().equals(scheduling.getAppointmentDate()) && request.getTransferValue() > 2000.0) {
//
//        }

        scheduling.setSourceAccount(request.getSourceAccount());
        scheduling.setTargetAccount(request.getTargetAccount());
        scheduling.setTransferValue(request.getTransferValue());
        scheduling.setTransferDate(request.getTransferDate());

        return null;

    }


    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        LocalDate em10dias = hoje.plusDays(15);
        System.out.println(em10dias);
    }

}
