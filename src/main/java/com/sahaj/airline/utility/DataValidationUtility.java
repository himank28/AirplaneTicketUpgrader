package com.sahaj.airline.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidationUtility {
	
	private DataValidationUtility() {}

	public static boolean isPatternMatch(String data, String pattern) {
        if (data == null)
            return false;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(data);
        return (m.matches());
		
	}
}
