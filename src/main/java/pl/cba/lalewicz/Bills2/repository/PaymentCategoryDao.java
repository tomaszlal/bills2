package pl.cba.lalewicz.Bills2.repository;

import org.springframework.data.repository.CrudRepository;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;

public interface PaymentCategoryDao extends CrudRepository<PaymentCategory,Long> {
}
