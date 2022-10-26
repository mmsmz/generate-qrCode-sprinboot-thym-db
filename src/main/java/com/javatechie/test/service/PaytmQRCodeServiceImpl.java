package com.javatechie.test.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.javatechie.test.CreateAccountRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
public class PaytmQRCodeServiceImpl implements  PaytmQRCodeService{

     public String writeQR(CreateAccountRequest request) throws WriterException, IOException {
        String qcodePath = "src/main/resources/static/images/" + request.getName() + "-QRCode.png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(request.getName() + "\n" + request.getEmail() + "\n"
                + request.getMobile() + "\n" + request.getPassword(), BarcodeFormat.QR_CODE, 350, 350);
        Path path = FileSystems.getDefault().getPath(qcodePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return "/images/" + request.getName() + "-QRCode.png";
    }

}
