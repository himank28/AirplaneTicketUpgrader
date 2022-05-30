package com.sahaj.airline.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sahaj.airline.constants.Constant;
import com.sahaj.airline.enums.TicketFileKey;
import com.sahaj.airline.exception.BusinessException;

public class AirlineTicket {
	
	private String firstName;
	
	private String lastName;
	
	private String pnr;

	private String fareClass;

	private Date travelDate;
	
	private String pax;
	
	private Date ticketingDate;

	private String email;

	private String mobilePhone;

	private String bookedCabin;
	
	private String discountCode;
	
	private String error;

	public AirlineTicket(String[] data) throws BusinessException {
		try {
				SimpleDateFormat sdf = new SimpleDateFormat(Constant.FILE_DATE_FORMAT);
				this.firstName=data[TicketFileKey.FIRST_NAME.getIndex()].trim();
				this.lastName=data[TicketFileKey.LAST_NAME.getIndex()].trim();
				this.pnr=data[TicketFileKey.PNR.getIndex()].trim();
				this.fareClass=data[TicketFileKey.FARE_CLASS.getIndex()].trim();
				this.travelDate=sdf.parse(data[TicketFileKey.TRAVEL_DATE.getIndex()].trim());
				this.pax=data[TicketFileKey.PAX.getIndex()].trim();
				this.ticketingDate=sdf.parse(data[TicketFileKey.TICKET_DATE.getIndex()].trim());
				this.email=data[TicketFileKey.EMAIL.getIndex()].trim();
				this.mobilePhone=data[TicketFileKey.MOBILE.getIndex()].trim();
				this.bookedCabin=data[TicketFileKey.BOOKED_CABIN.getIndex()].trim();
		}catch(Exception e) {
			throw new BusinessException("Invalid format data in file");
		}
	}
	public AirlineTicket() {};

	public void writeTicketData(String[] dataCol) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constant.FILE_DATE_FORMAT);
		dataCol[TicketFileKey.FIRST_NAME.getIndex()]=this.firstName;
		dataCol[TicketFileKey.LAST_NAME.getIndex()]=this.lastName;
		dataCol[TicketFileKey.PNR.getIndex()]=this.pnr;
		dataCol[TicketFileKey.FARE_CLASS.getIndex()]=this.fareClass;
		dataCol[TicketFileKey.TRAVEL_DATE.getIndex()]=sdf.format(this.travelDate);
		dataCol[TicketFileKey.PAX.getIndex()]=this.pax;;
		dataCol[TicketFileKey.TICKET_DATE.getIndex()]=sdf.format(this.ticketingDate);
		dataCol[TicketFileKey.EMAIL.getIndex()]=this.email;
		dataCol[TicketFileKey.MOBILE.getIndex()]=this.mobilePhone;
		dataCol[TicketFileKey.BOOKED_CABIN.getIndex()]=this.bookedCabin;
	}
	
	public static void writeTicketHeader(String[] headerCol) {
		headerCol[TicketFileKey.FIRST_NAME.getIndex()]= TicketFileKey.FIRST_NAME.getValue();
		headerCol[TicketFileKey.LAST_NAME.getIndex()]= TicketFileKey.LAST_NAME.getValue();
		headerCol[TicketFileKey.PNR.getIndex()]= TicketFileKey.PNR.getValue();
		headerCol[TicketFileKey.FARE_CLASS.getIndex()]= TicketFileKey.FARE_CLASS.getValue();
		headerCol[TicketFileKey.TRAVEL_DATE.getIndex()]= TicketFileKey.TRAVEL_DATE.getValue();
		headerCol[TicketFileKey.PAX.getIndex()]= TicketFileKey.PAX.getValue();
		headerCol[TicketFileKey.TICKET_DATE.getIndex()]= TicketFileKey.TICKET_DATE.getValue();
		headerCol[TicketFileKey.EMAIL.getIndex()]= TicketFileKey.EMAIL.getValue();
		headerCol[TicketFileKey.MOBILE.getIndex()]= TicketFileKey.MOBILE.getValue();
		headerCol[TicketFileKey.BOOKED_CABIN.getIndex()]= TicketFileKey.BOOKED_CABIN.getValue();
		headerCol[TicketFileKey.FIRST_NAME.getIndex()]= TicketFileKey.FIRST_NAME.getValue();
		headerCol[TicketFileKey.FIRST_NAME.getIndex()]= TicketFileKey.FIRST_NAME.getValue();
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getFareClass() {
		return fareClass;
	}

	public void setFareClass(String fareClass) {
		this.fareClass = fareClass;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getBookedCabin() {
		return bookedCabin;
	}

	public void setBookedCabin(String bookedCabin) {
		this.bookedCabin = bookedCabin;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPax() {
		return pax;
	}
	public void setPax(String pax) {
		this.pax = pax;
	}
	public Date getTicketingDate() {
		return ticketingDate;
	}
	public void setTicketingDate(Date ticketingDate) {
		this.ticketingDate = ticketingDate;
	}

	@Override
	public String toString() {
		return (firstName != null ? firstName + ", " : "") + (lastName != null ? lastName + ", " : "")
				+ (pnr != null ? pnr + ", " : "") + (fareClass != null ? fareClass + ", " : "")
				+ (travelDate != null ? travelDate + ", " : "") + (pax != null ? pax + ", " : "")
				+ (ticketingDate != null ? ticketingDate + ", " : "") + (email != null ? email + ", " : "")
				+ (mobilePhone != null ? mobilePhone + ", " : "") + (bookedCabin != null ? bookedCabin + ", " : "")
				+ (discountCode != null ? discountCode + ", " : "") + (error != null ? error : "");
	}




	
}
