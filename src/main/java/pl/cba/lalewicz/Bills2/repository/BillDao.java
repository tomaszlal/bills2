package pl.cba.lalewicz.Bills2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cba.lalewicz.Bills2.entity.Bill;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;

import java.util.List;

@Repository
public interface BillDao extends JpaRepository<Bill, Long> {

    public List<Bill> findByPaymentCategory(PaymentCategory category);
}
