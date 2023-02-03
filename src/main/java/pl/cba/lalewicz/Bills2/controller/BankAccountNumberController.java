package pl.cba.lalewicz.Bills2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cba.lalewicz.Bills2.entity.BankAccountNumber;
import pl.cba.lalewicz.Bills2.service.BankAccountNumberService;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
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

    @PutMapping("/update/bankaccountnumber")
    public BankAccountNumber updateBankAccountNumber(@RequestBody BankAccountNumber bankAccountNumber){
        return bankAccountNumberService.updateBankAccountNumber(bankAccountNumber);
    }
}
