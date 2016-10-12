package com.hloong.base.security;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密算法(使用org.apache.commons.codec.binary.Base64做转码以及辅助加密)
 * 
 */
public class AESUtil {


	public static final String encoding = "UTF-8";
	private static String iv = "0102030405060708";
	private static String key = "czabcd1234czabcd";
	/** 加密算法,可用 AES,DES,DESede,Blowfish. */
	public static final String ALGORITHM_AES = "AES/CBC/PKCS5Padding";
	// 加密
	public static String Encrypt(String sSrc) throws Exception {
		if (key == null) {
			System.out.print("Key为空null");
			return null;
		}
		// 判断Key是否为16位
		if (key.length() != 16) {
			System.out.print("Key长度不是16位");
			return null;
		}
		byte[] raw = key.getBytes(encoding);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance(ALGORITHM_AES);//"算法/模式/补码方式"
		IvParameterSpec ivps = new IvParameterSpec(iv.getBytes(encoding));//使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes(encoding));
		return Base64.encode(encrypted);//此处使用BAES64做转码功能，同时能起到2次加密的作用。
	}

	// 解密
	public static String Decrypt(String sSrc) throws Exception {
		try {
			// 判断Key是否正确
			if (key == null) {
				System.out.print("Key为空null");
				return null;
			}
			// 判断Key是否为16位
			if (key.length() != 16) {
				System.out.print("Key长度不是16位");
				return null;
			}
			byte[] raw = key.getBytes(encoding);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
			IvParameterSpec ivps = new IvParameterSpec(iv.getBytes(encoding));
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);
			byte[] encrypted1 = Base64.decode(sSrc);//先用bAES64解密
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original, encoding);
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
}