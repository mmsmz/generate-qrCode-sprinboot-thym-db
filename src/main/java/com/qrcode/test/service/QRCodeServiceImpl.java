package com.qrcode.test.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrcode.test.dto.CreateAccountRequestDTO;
import com.qrcode.test.util.QRCodeCommon;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static com.qrcode.test.util.QRCodeCommon.IMAGESIZE;
import static com.qrcode.test.util.QRCodeCommon.IMGBASEPATH;
import static com.qrcode.test.util.QRCodeCommon.IMGFORMAT;
import static com.qrcode.test.util.QRCodeCommon.PNG;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    public String writeQR(CreateAccountRequestDTO request) throws WriterException, IOException {
        String accountNo = request.getAccountNo();
        String qrCodePath = IMGBASEPATH + accountNo + IMGFORMAT;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        StringBuilder content = new StringBuilder();
        content.append(request.getPolicyNo()).append(System.lineSeparator());
        content.append(request.getBankName()).append("\n");
        content.append(accountNo).append("\n");
        content.append(request.getAccountType()).append("\n");

        BitMatrix bitMatrix = qrCodeWriter.encode(content.toString(), BarcodeFormat.QR_CODE, IMAGESIZE, IMAGESIZE);
        Path path = FileSystems.getDefault().getPath(qrCodePath);
        MatrixToImageWriter.writeToPath(bitMatrix, PNG, path);
        return "/" + accountNo + IMGFORMAT;
    }

}
