package com.sahaj.airline.constants;

public class Constant {
	
	private Constant() {}
	
	public static final String ALPHA_NUMERIC_PATTERN="[a-zA-Z0-9 ]*";

	public static final String MOBILE_PATTERN="[0-9]*";

	public static final String EMAIL_PATTERN="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	public static final String EMAIL_INVALID = "Email invalid";
	public static final String MOBILE_INVALID = "Mobile invalid";
	public static final String PNR_INVALID = "PNR invalid";
	public static final String CABIN_INVALID = "Booked Cabin invalid";
	public static final String TICKET_DATE_INVALID = "Ticketing date is after travel date";
	public static final String FILE_DATE_FORMAT = "yyyy-MM-dd";
	

}
