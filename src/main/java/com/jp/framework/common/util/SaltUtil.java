package com.jp.framework.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Random;

public class SaltUtil {
	private static Logger LOG = LoggerFactory.getLogger(SaltUtil.class);

	public static String getNextSalt() {
		Random random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < salt.length; i++) {
			String hex = Integer.toHexString(0xff & salt[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	// public static void main(String[] args) {
	// System.out.println(getNextSalt().toString());
	// }
}
