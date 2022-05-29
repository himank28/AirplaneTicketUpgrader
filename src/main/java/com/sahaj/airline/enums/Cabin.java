package com.sahaj.airline.enums;

public enum Cabin {

	Economy("Economy"), PremiumEconomy("Premium Economy"),Business("Business"),First("First");
	
	private final String value;
	
	Cabin(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}
	public static Cabin findByValue(String value) {
		Cabin  result = null;
	    for (Cabin  day : values()) {
	        if (day.getValue().equalsIgnoreCase(value)) {
	            result = day;
	            break;
	        }
	    }
	    return result;
	}
}
