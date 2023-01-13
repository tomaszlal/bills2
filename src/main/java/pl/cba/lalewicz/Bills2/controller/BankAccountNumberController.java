package pl.cba.lalewicz.Bills2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.cba.lalewicz.Bills2.entity.BankAccountNumber;
import pl.cba.lalewicz.Bills2.service.BankAccountNumberService;

import java.util.List;

@RestController
public class BankAccountNumberController {

    @Autowired
    private BankAccountNumberService bankAccountNumberService;
    @PostMapping("/add/bankaccountnumber")
    public BankAccountNumber addBankAccountNumber(@RequestBody BankAccountNumber bankAccountNumber){
        return bankAccountNumberService.addBankAccountNumber(bankAccountNumber);
    }

    @GetMapping("/get/bankaccountnumber")
    public List<BankAccountNumber> getBankAccountNumberList() {
        return bankAccountNumberService.getAllBankAccountNumberList();
    }
}
