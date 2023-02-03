package pl.cba.lalewicz.Bills2.controller;

import com.google.zxing.WriterException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.cba.lalewicz.Bills2.Utils.AccountUtils;
import pl.cba.lalewicz.Bills2.Utils.QRCode;
import pl.cba.lalewicz.Bills2.entity.BankAccountNumber;
import pl.cba.lalewicz.Bills2.entity.Bill;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;
import pl.cba.lalewicz.Bills2.service.BankAccountNumberService;
import pl.cba.lalewicz.Bills2.service.BillService;
import pl.cba.lalewicz.Bills2.service.PaymentCategoryService;

import java.io.IOException;
import java.time.LocalDate;

@CrossOrigin
@RestController
public class MainController {

    @Autowired
    private BankAccountNumberService bankAccountNumberService;
    @Autowired
    private PaymentCategoryService paymentCategoryService;

    @Autowired
    private BillService billService;

    @PostConstruct
    public void generateData(){
        BankAccountNumber bNb1 = bankAccountNumberService.addBankAccountNumber(new BankAccountNumber("658375634875643876538"));
        BankAccountNumber bNb2 = bankAccountNumberService.addBankAccountNumber(new BankAccountNumber("085346786869843676543", LocalDate.of(2022, 12, 14)));
        BankAccountNumber bNb3 = bankAccountNumberService.addBankAccountNumber(new BankAccountNumber("09990000000000000"));
        PaymentCategory pay1 = paymentCategoryService.addPaymentCategory(new PaymentCategory("Woda","gmina",bNb2));
        PaymentCategory pay2 = paymentCategoryService.addPaymentCategory(new PaymentCategory("Gaz","pegenige",bNb3));
        Bill bil1 = billService.addBill(new Bill(pay2,"fv 34985349/56",156.58,LocalDate.of(2022,12,26),
                LocalDate.of(2022,12,26),LocalDate.of(2023,01,01)));
        Bill bil2 = billService.addBill(new Bill(pay1,"factu 57577575",36.87,LocalDate.of(2022,12,25),
                LocalDate.of(2022,12,24),LocalDate.of(2023,01,01)));
        Bill bil3 = billService.addBill(new Bill(pay2,"43543646455",454.9,LocalDate.of(2022,12,24),
                LocalDate.of(2022,12,25),LocalDate.of(2023,01,01)));
    }

    @GetMapping("/")
    public ResponseEntity<byte[]> test() throws IOException, WriterException {
        MediaType contentType = MediaType.IMAGE_PNG;

        byte[] file = QRCode.generate();

//        return new ResponseEntity<>(file,contentType,HttpStatus.OK);  to nie
        return ResponseEntity.ok().contentType(contentType).body(file);
    }

    @GetMapping("/accountcheck/{accountnumber}")
    private boolean checkAccountNumber(@PathVariable("accountnumber") String accountnumber){
        return AccountUtils.isCorrectAccountNumber(accountnumber);
    }
}
