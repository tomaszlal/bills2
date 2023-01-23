package pl.cba.lalewicz.Bills2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;
import pl.cba.lalewicz.Bills2.service.PaymentCategoryService;

import java.util.List;

@CrossOrigin
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

    @PutMapping("/update/category")
    public PaymentCategory updatePaymentCategory(@RequestBody PaymentCategory paymentCategory){
        return paymentCategoryService.updatePaymentCategory(paymentCategory);
    }
}
