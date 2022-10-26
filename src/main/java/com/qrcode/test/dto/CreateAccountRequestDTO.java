package com.qrcode.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateAccountRequestDTO {

//	PolicyNo, BankName, AccountNo, AccountType
	String PolicyNo; //fullname
	String BankName; // mobile
	String AccountNo; //email
	String AccountType; //password
}
