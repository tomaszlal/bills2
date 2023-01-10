package pl.cba.lalewicz.Bills2.Utils;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AccountUtils {
    public static boolean isCorrectAccountNumber(String accountNumber) {
        if (accountNumber.length() == 26) {
            String controlSum = accountNumber.substring(0, 2);
            accountNumber = accountNumber.substring(2);
//            System.out.println(accountNumber);
//            System.out.println(controlSum);
            String pl = "2521";
            accountNumber = accountNumber + pl + controlSum;
//            System.out.println(accountNumber);
            BigInteger accountNumberBigInt = new BigInteger(accountNumber);
            BigInteger ninetySeven = new BigInteger("97");
            //System.out.println("wynik reszty z dzelenia przez 97: "+accountNumberBigInt.remainder(ninetySeven));
            if ((accountNumberBigInt.remainder(ninetySeven)).equals(BigInteger.ONE)) {
//                System.out.println("Nr konta prawidłowy");
                return true;
            } else {
//                System.out.println("nr konta błędny");
                return false;
            }
        } else {
            //System.out.println("niema 26 znakow");
            return false;
        }
    }
}

