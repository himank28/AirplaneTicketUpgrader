package com.sahaj.airline.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.sahaj.airline.OfferChain;
import com.sahaj.airline.constants.Constant;
import com.sahaj.airline.enums.Cabin;
import com.sahaj.airline.enums.TicketFileKey;
import com.sahaj.airline.exception.InvalidFileFormatException;
import com.sahaj.airline.utility.DataValidationUtility;

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
	private boolean isValid;

	public AirlineTicket(TicketBuilder builder) {
		this.firstName=builder.firstName;
		this.lastName=builder.lastName;
		this.pnr=builder.pnr;
		this.fareClass=builder.fareClass;
		this.travelDate=builder.travelDate;
		this.pax=builder.pax;
		this.ticketingDate=builder.ticketingDate;
		this.email=builder.email;
		this.mobilePhone=builder.mobilePhone;
		this.bookedCabin=builder.bookedCabin;
	}
	public AirlineTicket(String[] data) throws InvalidFileFormatException {
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
			throw new InvalidFileFormatException("Invalid format data in file");
		}
	}
	public AirlineTicket() {}

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

	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	

	public static class TicketBuilder {
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
	
		public TicketBuilder(String email, String mobilePhone, String bookedCabin,String pnr, Date travelDate, Date ticketingDate ) {
			this.email = email;
			this.mobilePhone = mobilePhone;
			this.bookedCabin = bookedCabin;
			this.pnr = pnr;
			this.travelDate = travelDate;
			this.ticketingDate = ticketingDate;
	
		}
		public TicketBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public TicketBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public TicketBuilder fareClass(String fareClass) {
			this.fareClass = fareClass;
			return this;
		}
		public TicketBuilder pax(String pax) {
			this.pax = pax;
			return this;
		}
	
		public AirlineTicket build() {
			AirlineTicket ticket =  new AirlineTicket(this);
			validateTicket(ticket);
			new OfferChain().process(ticket);
			return ticket;
		}
		private void validateTicket(AirlineTicket ticket) {
				if(StringUtils.isEmpty(ticket.getEmail()) || !DataValidationUtility.isPatternMatch(ticket.getEmail(), Constant.EMAIL_PATTERN)) {
					setError(ticket,Constant.EMAIL_INVALID);
				}else if(StringUtils.isEmpty(ticket.getMobilePhone()) || !DataValidationUtility.isPatternMatch(ticket.getMobilePhone(), Constant.MOBILE_PATTERN)) {
					setError(ticket,Constant.MOBILE_INVALID);
				}else if (StringUtils.isEmpty(ticket.getBookedCabin()) || Cabin.findByValue(ticket.getBookedCabin())==null) {
					setError(ticket,Constant.CABIN_INVALID);
				}else if (StringUtils.isEmpty(ticket.getPnr()) || this.pnr.length()!=6 || !DataValidationUtility.isPatternMatch(this.pnr, Constant.ALPHA_NUMERIC_PATTERN)) {
					setError(ticket,Constant.PNR_INVALID);
				}else if (ticket.getTicketingDate()==null || ticket.getTravelDate()==null || !this.ticketingDate.before(this.travelDate)) {
					setError(ticket,Constant.TICKET_DATE_INVALID);
				}else {
					ticket.setValid(true);
				}
		}
		private void setError(AirlineTicket ticket,String error) {
			ticket.setError(error);
			ticket.setValid(false);
		}
	}
}
