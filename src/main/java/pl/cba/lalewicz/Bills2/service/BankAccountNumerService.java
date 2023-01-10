package pl.cba.lalewicz.Bills2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cba.lalewicz.Bills2.repository.BankAccountNumberDao;

@Service
public class BankAccountNumerService {

    @Autowired
    private BankAccountNumberDao bankAccountNumberDao;

}
