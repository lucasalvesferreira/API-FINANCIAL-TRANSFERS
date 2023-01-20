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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SchedulingService {

    private final Logger logger = Logger.getLogger(AccountService.class.getName());
    @Autowired
    private SchedulingRepository schedulingRepository;
    @Autowired
    private AccountRepository accountRepository;


    public List<SchedulingModel> findAll() {
        return schedulingRepository.findAll();
    }

    public SchedulingModel findById(Long id) {

        SchedulingModel account = schedulingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));

        return account;
    }

    public List<SchedulingModel> findByDate(LocalDate date) {
        return schedulingRepository.findByAppointmentDate(date);
    }

    public SchedulingResponse postScheduling(SchedulingRequest request) {

        logger.info("Checking if account exist!");
        if (!accountRepository.existsByAccount(request.getSourceAccount()))
            throw new ResourceNotFoundException("Source Account not Found!");
        if (!accountRepository.existsByAccount(request.getTargetAccount()))
            throw new ResourceNotFoundException("Target Account not Found!");

        // Verifica se o valor valido para transferir
        if (request.getTransferValue() < 0.50) throw new InvalidValueException("Invalid value for transfer!");

        // Verifica se a saldo na conta para transferir
        AccountModel sourceAccount = accountRepository.findByAccount(request.getSourceAccount());
        if (sourceAccount.getBalance() < 0.50) throw new InvalidValueException("Insufficient balance for transfer!");

        // Verifica se a data para tranfeirir e apos a de agendamento
        SchedulingModel scheduling = new SchedulingModel();
        if (request.getTransferDate().isBefore(scheduling.getAppointmentDate()))
            throw new InvalidValueException("Impossible to transfer to a date before the current one!");

        scheduling.setSourceAccount(request.getSourceAccount());
        scheduling.setTargetAccount(request.getTargetAccount());
        scheduling.setTransferValue(request.getTransferValue());
        scheduling.setTransferDate(request.getTransferDate());
        scheduling.setRate(getTaxa(request.getTransferValue(), request.getTransferDate(), scheduling.getAppointmentDate()));

        schedulingRepository.save(scheduling);

        return new SchedulingResponse(
                scheduling.getId(),
                scheduling.getSourceAccount(),
                scheduling.getTargetAccount(),
                scheduling.getTransferValue(),
                scheduling.getRate(),
                scheduling.getTransferDate(),
                scheduling.getAppointmentDate());

    }

    private Double getTaxa(Double value, LocalDate transferDate, LocalDate appointmentDate) {
        LocalDate today = LocalDate.now();
        Double taxA = (0.03 * value) + 3;
        Double taxB = 12.0;
        Double taxaC = 0.0;
        int qtdDiasTaxa = 0;

        for (int i = 0; i < 100; i++) {
            LocalDate currenDays = today.plusDays(i);
            if (transferDate.equals(currenDays)) {
                qtdDiasTaxa = i;
                break;
            }
            if (i == 41) {
                qtdDiasTaxa = i;
                break;
            }
        }

        if (qtdDiasTaxa <= 10) {
            if (value > 1000.0 && value <= 2000.0) {
                taxaC = taxB;
            } else {
                taxaC = taxA;
            }
        }
        if (qtdDiasTaxa > 10) {
            taxaC = 0.082 * value;
        }
        if (qtdDiasTaxa > 20) {
            taxaC = 0.069 * value;
        }
        if (qtdDiasTaxa > 30) {
            taxaC = 0.047 * value;
        }
        if (qtdDiasTaxa > 40) {
            taxaC = 0.017 * value;
        }


        // Taxas
//        Se o valor e ate 1000
        if (value <= 1000.0) {
            // Se a tranferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a ser transferido;
            if (transferDate.equals(appointmentDate)) {
                return taxA;
            }
            // Se a transfencia e até 10 dias da data de agendamento tem uma taxa de $3 mais 3% do valor a ser transferido;
            // Se nao tem uma taxa proporcional a quantidade de dias
            else {
                return taxaC;
            }
        }
//        Se o valor e ate 2000
        else if (value <= 2000.0) {
            // Se a tranferências no mesmo dia do agendamento tem uma taxa 12;
            if (transferDate.equals(appointmentDate)) {
                return taxB;
            } else {
                return taxaC;
            }
        }
//        Se o valor e maior que 2000
        else {
            return taxaC;
        }

    }
    public void delete(Long id){
        SchedulingModel entity = schedulingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id!"));
        schedulingRepository.delete(entity);
    }

}
