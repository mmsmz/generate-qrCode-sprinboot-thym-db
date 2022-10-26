package com.qrcode.test.controller;

import com.google.zxing.WriterException;
import com.qrcode.test.service.PaytmQRCodeService;
import com.qrcode.test.dto.CreateAccountRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class PaytmQRCodeController {

	/*@Autowired
	private ResourceLoader resourceLoader;*/

	@Autowired
	private PaytmQRCodeService paytmQRCodeService;

	@PostMapping("/createAccountInfo")
	public String createNewAccount(CreateAccountRequestDTO request, Model model)
			throws WriterException, IOException, InterruptedException {
		String qrCodePath = paytmQRCodeService.writeQR(request);
		model.addAttribute("code", qrCodePath);
		return "QRcode";
	}
}
