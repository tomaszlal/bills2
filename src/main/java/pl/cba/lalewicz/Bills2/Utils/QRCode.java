package pl.cba.lalewicz.Bills2.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

@Service
public class QRCode {
    private final static String data = "Ala ma kota pies ma Ule a romek robi dobrze";


    public static byte[] generate() throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE,400,400);

//        MatrixToImageWriter.writeToPath(matrix,"png", Paths.get("temp_qrcode.png"));
//        byte[] file = Files.readAllBytes(new File("temp_qrcode.png").toPath());

        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix);
        ByteArrayOutputStream imageOutput=new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", imageOutput );
        byte[] file=imageOutput.toByteArray();
        return file;
    }

    public static byte[] generate(String textToQRCode) throws WriterException, IOException  {
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  //Polskie znaki w UTF-8
        BitMatrix matrix = new MultiFormatWriter().encode(textToQRCode, BarcodeFormat.QR_CODE,300,300,hints);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix);
        ByteArrayOutputStream imageOutput=new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", imageOutput );
        byte[] file=imageOutput.toByteArray();
        return file;
    }




}
