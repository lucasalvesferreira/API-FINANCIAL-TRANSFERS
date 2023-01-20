package api.financeira.api.dtos.request;


import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

public class SchedulingRequest {

    private String sourceAccount;          //  Conta de origem
    private String targetAccount;         //  Conta de destino
    private Double transferValue;        //  Valor da transferência
    private LocalDate transferDate;    //  Data da transferência

    public SchedulingRequest() {
    }

    public SchedulingRequest(String sourceAccount, String targetAccount, Double value, LocalDate transferDate) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transferValue = value;
        this.transferDate = transferDate;
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

    public void setTransferValue(Double value) {
        this.transferValue = value;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }


}
