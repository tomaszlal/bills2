package pl.cba.lalewicz.Bills2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;

public interface PaymentCategoryDao extends JpaRepository<PaymentCategory, Long> {
}
