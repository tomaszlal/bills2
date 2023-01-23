package pl.cba.lalewicz.Bills2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cba.lalewicz.Bills2.entity.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Long> {

}
