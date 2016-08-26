package com.fourfire.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import org.thymeleaf.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 加解密相关工具类
 * 
 * @author liuyi
 * @date 2016-08-25
 */
public class EncryptUtil {
	private static final String KEY = "QWERasdf1234";
	private static Key key;
	
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
			generator = null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static String getDecryptString(String encryptString) {
		if (StringUtils.isEmpty(encryptString)) {
			return null;
		}
		
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] strBytes= decoder.decodeBuffer(encryptString);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF-8");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IOException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			return null;
		}
	}
	
	public static String getEncryptString(String decryptString) {
		if (StringUtils.isEmpty(decryptString)) {
			return null;
		}
		
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			byte[] strBytes = decryptString.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return encoder.encode(encryptStrBytes);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String args[]) {
		String test = "ursaminor";
		System.out.println(getEncryptString(test));
	}
}
