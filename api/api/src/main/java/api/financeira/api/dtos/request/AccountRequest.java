package api.financeira.api.dtos.request;

import java.io.Serializable;

public class AccountRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String owner;
    private String agency;
    private String account;
    private String bankName;
    private Double balance = 0.0;

    public AccountRequest( String owner, String agency, String account, String bankName, Double balance) {
        this.owner = owner;
        this.agency = agency;
        this.account = account;
        this.bankName = bankName;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
