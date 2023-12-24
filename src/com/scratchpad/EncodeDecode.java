package com.scratchpad;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;

import java.io.IOException;

public class EncodeDecode {
	public static void main(String[] args) {
		String pplCode = "OTI0MTE2NQ==";
		String decodedPplCode = null;
		try {
			if (Base64.isBase64(pplCode.getBytes("UTF-8"))) {
				decodedPplCode = new EncodeDecode().testEncodedCredentials(pplCode);
			} else {
				decodedPplCode = pplCode;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(decodedPplCode);
	}

	public String testEncodedCredentials(String encodedString) throws IOException {
		byte[] encodedStringBytes = encodedString.getBytes("UTF-8");
		byte[] decodedStringBytes = Base64Utils.decode(encodedStringBytes);
		return new String(decodedStringBytes, "UTF-8");
	}
}
