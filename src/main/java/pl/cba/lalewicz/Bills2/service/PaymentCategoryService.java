package pl.cba.lalewicz.Bills2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;
import pl.cba.lalewicz.Bills2.repository.PaymentCategoryDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentCategoryService {

    @Autowired
    private PaymentCategoryDao paymentCategoryDao;

    public List<PaymentCategory> getPaymentCategoryList() {
        List<PaymentCategory> paymentCategories = new ArrayList<>();
        paymentCategoryDao.findAll().forEach(paymentCategory -> {
            paymentCategories.add(paymentCategory);
        });
        return paymentCategories;
    }

    public PaymentCategory addPaymentCategory (PaymentCategory paymentCategory){
        return paymentCategoryDao.save(paymentCategory);
    }

}
