package api.financeira.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Scheduling")
public class SchedulingModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "source_account",nullable = false,length = 10)
    private String sourceAccount;          //  Conta de origem
    @Column(name = "target_account",nullable = false,length = 10)
    private String targetAccount;         //  Conta de destino
    @Column(name = "value",nullable = false,length = 9999)
    private Double value;                //  Valor da transferência
    @Column(name = "rate",nullable = false,length = 999)
    private Double rate;                //  Taxa
    @Column(name = "transfer_date",nullable = false)
    private LocalDate transferDate;    //  Data da transferência
    @Column(name = "appointment_date",nullable = false)
    private LocalDate appointmentDate;//  Data de agendamento

    public SchedulingModel() {
    }

    public SchedulingModel(Long id, String sourceAccount, String targetAccount, Double value, Double rate, LocalDate transferDate, LocalDate appointmentDate) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.value = value;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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
