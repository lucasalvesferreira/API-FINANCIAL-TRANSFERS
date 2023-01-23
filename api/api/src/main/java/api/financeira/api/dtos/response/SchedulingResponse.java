package api.financeira.api.dtos.response;

import java.time.LocalDate;
import java.util.Date;

public class SchedulingResponse {
    private Long id;
    private String sourceAccount;          //  Conta de origem
    private String targetAccount;         //  Conta de destino
    private Double transferValue;        //  Valor da transferência
    private Double rate;                //  Taxa
    private LocalDate transferDate;    //  Data da transferência
    private LocalDate appointmentDate ;//  Data de agendamento

    public SchedulingResponse() {
    }

    public SchedulingResponse(Long id, String sourceAccount, String targetAccount, Double transferValue, Double rate, LocalDate transferDate, LocalDate appointmentDate) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transferValue = transferValue;
        this.rate = rate;
        this.transferDate = transferDate;
        this.appointmentDate = appointmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    public Double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(Double transferValue) {
        this.transferValue = transferValue;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
