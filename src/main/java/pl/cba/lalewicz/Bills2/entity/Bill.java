package pl.cba.lalewicz.Bills2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private PaymentCategory paymentCategory;
    @Column(nullable = false)
    private String invoiceNumber;   //nr faktury i lub tytuł zapłaty
    private double amount;          //kwota
    private LocalDate dateOfIssue;       // data wystawienia
    private LocalDate dueDate;           // termin płatności
    private LocalDate dateOfPayment;     // data zaplaty z afakture
    private boolean wasPaid;        //czy został opłacony domyślnnie false
    @ManyToOne
    private BankAccountNumber paymentAccountNumber;    //nr konta do płatności

    public Bill(PaymentCategory paymentCategory, String invoiceNumber, double amount, LocalDate dateOfIssue, LocalDate dueDate, LocalDate dateOfPayment, boolean wasPaid, BankAccountNumber paymentAccountNumber) {
        this.paymentCategory = paymentCategory;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
        this.dueDate = dueDate;
        this.dateOfPayment = dateOfPayment;
        this.wasPaid = wasPaid;
        this.paymentAccountNumber = paymentAccountNumber;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentCategory getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(PaymentCategory paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public boolean isWasPaid() {
        return wasPaid;
    }

    public void setWasPaid(boolean wasPaid) {
        this.wasPaid = wasPaid;
    }

    public BankAccountNumber getPaymentAccountNumber() {
        return paymentAccountNumber;
    }

    public void setPaymentAccountNumber(BankAccountNumber paymentAccountNumber) {
        this.paymentAccountNumber = paymentAccountNumber;
    }
}
