package pl.cba.lalewicz.Bills2.service;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cba.lalewicz.Bills2.Utils.QRCode;
import pl.cba.lalewicz.Bills2.entity.Bill;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;
import pl.cba.lalewicz.Bills2.repository.BillDao;
import pl.cba.lalewicz.Bills2.repository.PaymentCategoryDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillDao billDao;

    @Autowired
    private PaymentCategoryDao categoryDao;

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

    public List<Bill> getBillListByCategory(Long categoryId){
        PaymentCategory paymentCategory = categoryDao.findById(categoryId).get();
        if (paymentCategory==null) return billDao.findAll();
        else return billDao.findByPaymentCategory(paymentCategory);
    }

    public boolean deleteBill(Long id) {
       if (billDao.existsById(id)){
           billDao.deleteById(id);
           return true;
       }
       return false;
    }

    public Bill updateBill(Bill bill){
        return billDao.save(bill);
    }

    public Bill getBillById(Long id){
        return billDao.findById(id).get();
    }

    public byte[] getQRCodeById(Long id) throws IOException, WriterException {
        Bill bill = billDao.findById(id).get();
        String textToQRCode = "|PL|" + bill.getPaymentAccountNumber().getAccountNumber()+ "|"
                + ((int)(bill.getAmount()*1000))/10+"|"+bill.getPaymentCategory().getRecipient()+"|"
                +bill.getInvoiceNumber()+"|||";
//        System.out.println(textToQRCode);
        return QRCode.generate(textToQRCode);
    }
}
