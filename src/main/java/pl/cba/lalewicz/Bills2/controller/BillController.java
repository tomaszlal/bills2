package pl.cba.lalewicz.Bills2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.cba.lalewicz.Bills2.entity.Bill;
import pl.cba.lalewicz.Bills2.service.BillService;

import java.util.List;
@CrossOrigin
@RestController
public class BillController {

    BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/get/bill")
    public List<Bill> getBillList() {
        return billService.getBillList();
    }

    @GetMapping("/get/bill/{categoryId}")
    public List<Bill> getBillListByCategoryId(@PathVariable long categoryId){
        return billService.getBillListByCategory(categoryId);
    }

    @GetMapping("/get/billpage")
    public Page<Bill> getBillPage(@RequestParam("page") int page,@RequestParam("size") int size){
        return billService.getBillPages(page, size);
    }

    @PostMapping("/add/bill")
    public Bill addBill(@RequestBody Bill bill){
        return billService.addBill(bill);
    }

    @DeleteMapping("/del/bill/{billId}")
    public boolean deleteBill(@PathVariable("billId") long billId) {
        return billService.deleteBill(billId);
    }

    @PutMapping("/update/bill")
    public Bill updateBill(@RequestBody Bill bill){
        return billService.updateBill(bill);
    }
}
