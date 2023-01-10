package pl.cba.lalewicz.Bills2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BankAccountNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 26, nullable = false)
    private String accountNumber;

    //początek daty obowiązywania nr konta
    private LocalDate beginningDateValidityAccountNumber;

    //aktualny numer rachunku
    private Boolean currentAccountNumber;

    public BankAccountNumber() {
    }

    public BankAccountNumber(String accountNumber, LocalDate beginningDateValidityAccountNumber, Boolean currentAccountNumber) {
        this.accountNumber = accountNumber;
        this.beginningDateValidityAccountNumber = beginningDateValidityAccountNumber;
        this.currentAccountNumber = currentAccountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getBeginningDateValidityAccountNumber() {
        return beginningDateValidityAccountNumber;
    }

    public void setBeginningDateValidityAccountNumber(LocalDate beginningDateValidityAccountNumber) {
        this.beginningDateValidityAccountNumber = beginningDateValidityAccountNumber;
    }

    public Boolean getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(Boolean currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }
}
