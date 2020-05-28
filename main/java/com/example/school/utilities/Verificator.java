package com.example.school.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificator {
	private static final String EMAIL_REGEX = "@.*?\\.";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	
	public static boolean verifyEmail(String email) {
		if (email == null) {
			return false;
		}

		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}
}
