package pl.cba.lalewicz.Bills2.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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




}
