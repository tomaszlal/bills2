package pl.cba.lalewicz.Bills2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cba.lalewicz.Bills2.entity.Bill;
import pl.cba.lalewicz.Bills2.repository.BillDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillDao billDao;

    //dodanie nowego rachunku
    public Bill addBill(Bill bill){
        return billDao.save(bill);
    }

    public List<Bill> getBillList(){
        return billDao.findAll();
    }

    public Page<Bill> getBillPages(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return billDao.findAll(pageable);
    }
}
