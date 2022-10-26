package com.qrcode.test.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrcode.test.dto.CreateAccountRequestDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
public class PaytmQRCodeServiceImpl implements  PaytmQRCodeService{

     public String writeQR(CreateAccountRequestDTO request) throws WriterException, IOException {
        String qcodePath = "src/main/webapp/" + request.getAccountNo() + "-QRCode.png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(request.getPolicyNo()).append("\n");
        stringBuilder.append(request.getBankName()).append("\n");;
        stringBuilder.append(request.getAccountNo()).append("\n");;
        stringBuilder.append(request.getAccountType()).append("\n");;

        BitMatrix bitMatrix = qrCodeWriter.encode(stringBuilder.toString(), BarcodeFormat.QR_CODE, 350, 350);
        Path path = FileSystems.getDefault().getPath(qcodePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return "/" + request.getAccountNo() + "-QRCode.png";
    }

}
