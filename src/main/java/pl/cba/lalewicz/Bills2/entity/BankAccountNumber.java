package pl.cba.lalewicz.Bills2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BankAccountNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 26, nullable = false)
    private String accountNumber;

    //początek daty obowiązywania nr konta
    private LocalDate beginningDateValidityAccountNumber;


    public BankAccountNumber() {
    }

    public BankAccountNumber(String accountNumber, LocalDate beginningDateValidityAccountNumber) {
        this.accountNumber = accountNumber;
        this.beginningDateValidityAccountNumber = beginningDateValidityAccountNumber;
    }

    public BankAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        this.beginningDateValidityAccountNumber = LocalDate.now();
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


}
