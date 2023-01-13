package pl.cba.lalewicz.Bills2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PaymentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String recipient; //odbiorca

    @OneToOne
    private BankAccountNumber bankAccountNumber;

    public PaymentCategory(String name, String recipient, BankAccountNumber bankAccountNumber) {
        this.name = name;
        this.recipient = recipient;
        this.bankAccountNumber = bankAccountNumber;
    }

    public PaymentCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public BankAccountNumber getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(BankAccountNumber bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
