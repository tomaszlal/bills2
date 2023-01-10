package pl.cba.lalewicz.Bills2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.cba.lalewicz.Bills2.entity.BankAccountNumber;

@Repository
public interface BankAccountNumberDao extends PagingAndSortingRepository<BankAccountNumber,Long> {

}
