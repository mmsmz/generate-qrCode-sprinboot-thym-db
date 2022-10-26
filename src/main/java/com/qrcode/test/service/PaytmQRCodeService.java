package com.qrcode.test.service;

import com.google.zxing.WriterException;
import com.qrcode.test.dto.CreateAccountRequestDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface PaytmQRCodeService {
    String writeQR(CreateAccountRequestDTO request) throws WriterException, IOException;
}
