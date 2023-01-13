package pl.cba.lalewicz.Bills2.controller;

import com.google.zxing.WriterException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cba.lalewicz.Bills2.Utils.QRCode;
import pl.cba.lalewicz.Bills2.entity.BankAccountNumber;
import pl.cba.lalewicz.Bills2.entity.PaymentCategory;
import pl.cba.lalewicz.Bills2.service.BankAccountNumberService;
import pl.cba.lalewicz.Bills2.service.PaymentCategoryService;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Date;

@RestController
public class TestController {

    @Autowired
    private BankAccountNumberService bankAccountNumberService;
    @Autowired
    private PaymentCategoryService paymentCategoryService;

    @PostConstruct
    public void generateData(){
        BankAccountNumber bNb1 = bankAccountNumberService.addBankAccountNumber(new BankAccountNumber("658375634875643876538"));
        BankAccountNumber bNb2 = bankAccountNumberService.addBankAccountNumber(new BankAccountNumber("085346786869843676543", LocalDate.of(2022, 12, 14)));
        PaymentCategory pay1 = paymentCategoryService.addPaymentCategory(new PaymentCategory("Woda","gmina",bNb2));
    }

    @GetMapping("/")
    public ResponseEntity<byte[]> test() throws IOException, WriterException {
        MediaType contentType = MediaType.IMAGE_PNG;

        byte[] file = QRCode.generate();

//        return new ResponseEntity<>(file,contentType,HttpStatus.OK);  to nie
        return ResponseEntity.ok().contentType(contentType).body(file);
    }
}
