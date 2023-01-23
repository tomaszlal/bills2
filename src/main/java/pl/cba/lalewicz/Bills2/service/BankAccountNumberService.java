package pl.cba.lalewicz.Bills2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cba.lalewicz.Bills2.entity.BankAccountNumber;
import pl.cba.lalewicz.Bills2.repository.BankAccountNumberDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountNumberService {

    @Autowired
    private BankAccountNumberDao bankAccountNumberDao;


    //add new or account number
    public BankAccountNumber addBankAccountNumber (BankAccountNumber bankAccountNumber){
        if (bankAccountNumber.getBeginningDateValidityAccountNumber() == null){
            bankAccountNumber.setBeginningDateValidityAccountNumber(LocalDate.now());
        }

//        System.out.println(bankAccountNumber);
        return bankAccountNumberDao.save(bankAccountNumber);
    }

    //update account number
    public BankAccountNumber updateBankAccountNumber (BankAccountNumber bankAccountNumber){
        return bankAccountNumberDao.save(bankAccountNumber);
    }

    public List<BankAccountNumber> getAllBankAccountNumberList() {
        List<BankAccountNumber> bankAccountList = new ArrayList<>();
        bankAccountNumberDao.findAll().forEach(bankAccountNumber -> {
            bankAccountList.add(bankAccountNumber);
        });
        return bankAccountList;
    }




}
