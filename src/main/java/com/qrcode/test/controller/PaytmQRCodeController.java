package com.qrcode.test.controller;

import java.io.IOException;

import com.javatechie.test.service.PaytmQRCodeService;
import com.qrcode.test.dto.CreateAccountRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.zxing.WriterException;

@Controller
public class PaytmQRCodeController {

	/*@Autowired
	private ResourceLoader resourceLoader;*/

	@Autowired
	private PaytmQRCodeService paytmQRCodeService;

	@PostMapping("/createAccount")
	public String createNewAccount(CreateAccountRequestDTO request, Model model)
			throws WriterException, IOException {
		String qrCodePath = paytmQRCodeService.writeQR(request);
		model.addAttribute("code", qrCodePath);
		return "QRcode";
	}

	/**@GetMapping("/readQR")
	public String verifyQR(@RequestParam("qrImage") String qrImage, Model model) throws Exception {
	model.addAttribute("content", readQR(qrImage));
	model.addAttribute("code", qrImage);
	return "QRcode";
	}*/

	/**private String readQR(String qrImage) throws Exception {
		final Resource fileResource = resourceLoader.getResource("classpath:static/" + qrImage);
		File QRfile = fileResource.getFile();
		BufferedImage bufferedImg = ImageIO.read(QRfile);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImg);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result = new MultiFormatReader().decode(bitmap);
		System.out.println("Barcode Format: " + result.getBarcodeFormat());
		System.out.println("Content: " + result.getText());
		return result.getText();

	}*/
}
