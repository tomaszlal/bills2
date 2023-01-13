package pl.cba.lalewicz.Bills2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;
import pl.cba.lalewicz.Bills2.service.PaymentCategoryService;

import java.util.List;

@RestController
public class PaymentCategoryController {

    @Autowired
    private PaymentCategoryService paymentCategoryService;

    @GetMapping("/get/categories")
    public List<PaymentCategory> getAllPaymentCategories() {
        return paymentCategoryService.getPaymentCategoryList();
    }

    @PostMapping("/add/category")
    public PaymentCategory addPaymentCategory(@RequestBody PaymentCategory paymentCategory){
        return paymentCategoryService.addPaymentCategory(paymentCategory);
    }
}
