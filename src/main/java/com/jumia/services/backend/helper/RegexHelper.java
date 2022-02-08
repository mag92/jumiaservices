package com.jumia.services.backend.helper;

import java.util.regex.Pattern;

public class RegexHelper {
	private String country;

	public RegexHelper(String country) {
		super();
		this.country = country;
	}
	
	public Pattern getRegexPattern(String country) {
		Pattern pattern;
		 
		switch(country.toUpperCase()) {
		case "CAMEROON":
			pattern = Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$");
			break;
		case "ETHIOPIA":
			pattern = Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$");
			break;
		case "UGANDA":
			pattern = Pattern.compile("\\(256\\)\\ ?\\d{9}$");
			break;
		case "MOZAMBIQUE":
			pattern = Pattern.compile("\\(258\\)\\ ?[28]\\d{7,8}$");
			break;
		case "MOROCCO":
			pattern = Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$");
			break;
		default:
			pattern = Pattern.compile("\\*");
		}
		return pattern;
	}
	
}
