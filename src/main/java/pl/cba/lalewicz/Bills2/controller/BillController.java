package pl.cba.lalewicz.Bills2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.cba.lalewicz.Bills2.entity.Bill;
import pl.cba.lalewicz.Bills2.service.BillService;

import java.util.List;

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

    @GetMapping("/get/billpage")
    public Page<Bill> getBillPage(@RequestParam("page") int page,@RequestParam("size") int size){
        return billService.getBillPages(page, size);
    }
}
