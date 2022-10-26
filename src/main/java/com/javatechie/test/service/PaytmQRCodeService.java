package com.javatechie.test.service;

import com.google.zxing.WriterException;
import com.javatechie.test.CreateAccountRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface PaytmQRCodeService {
    String writeQR(CreateAccountRequest request) throws WriterException, IOException;
}
