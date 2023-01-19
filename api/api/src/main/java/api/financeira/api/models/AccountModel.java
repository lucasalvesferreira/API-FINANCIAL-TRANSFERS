package api.financeira.api.models;




import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class AccountModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner",nullable = false,length = 100)
    private String owner;
    @Column(name = "agency",nullable = false,length = 4)
    private String agency;
    @Column(name = "account",nullable = false,length = 10)
    private String account;
    @Column(name = "bank_name",nullable = false,length = 50)
    private String bankName;
    @Column(name = "balance")
    private Double balance = 0.0;

    public AccountModel() {
    }

    public AccountModel(Long id, String titular, String numeroConta, String agencia, String nomeBanco) {
        this.id = id;
        this.owner = titular;
        this.account = numeroConta;
        this.agency = agencia;
        this.bankName = nomeBanco;
        this.balance = 0.0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String titular) {
        this.owner = titular;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String numeroConta) {
        this.account = numeroConta;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agencia) {
        this.agency = agencia;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String nomeBanco) {
        this.bankName = nomeBanco;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double saldo) {
        this.balance = saldo;
    }
}
