package api.financeira.api.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Scheduling")
public class SchedulingModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "source_account",nullable = false,length = 10) //  Conta de origem
    private String sourceAccount;
    @Column(name = "target_account",nullable = false,length = 10)  //  Conta de destino
    private String targetAccount;
    @Column(name = "transfer_value",nullable = false) //  Valor da transferência
    private Double transferValue;
    @Column(name = "rate",nullable = false)  //  Taxa
    private Double rate;
    @Column(name = "transfer_date",nullable = false) //  Data da transferência
    private LocalDate transferDate;
    @Column(name = "appointment_date",nullable = false) //  Data de agendamento
    private LocalDate appointmentDate = LocalDate.now() ;

    public SchedulingModel() {
    }

    public SchedulingModel(Long id, String sourceAccount, String targetAccount, Double value, Double rate, LocalDate transferDate) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transferValue = value;
        this.rate = rate;
        this.transferDate = transferDate;
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

    public void setTransferValue(Double value) {
        this.transferValue = value;
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
