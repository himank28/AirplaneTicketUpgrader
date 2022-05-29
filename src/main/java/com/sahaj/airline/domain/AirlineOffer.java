package com.sahaj.airline.domain;

import java.util.ArrayList;
import java.util.List;

import com.sahaj.airline.Offer;
import com.sahaj.airline.constants.Constant;
import com.sahaj.airline.enums.Cabin;
import com.sahaj.airline.enums.OfferType;
import com.sahaj.airline.enums.TicketFileKey;
import com.sahaj.airline.utility.DataValidationUtility;

public class AirlineOffer implements Offer {

	public List<String[]> writeValidOfferData(List<AirlineTicket> tickets) {
		List<String[]> rows = new ArrayList<>();
		int colSize=11;
		String[] headerCol = new String[colSize];
		AirlineTicket.writeTicketHeader(headerCol);
		headerCol[TicketFileKey.DISCOUNT_CODE.getIndex()]=TicketFileKey.DISCOUNT_CODE.getValue();
        rows.add(headerCol);
    	for(AirlineTicket ticket:tickets)	{
    		String[] dataCol = new String[colSize];
    		ticket.writeTicketData( dataCol);
    		dataCol[TicketFileKey.DISCOUNT_CODE.getIndex()]=ticket.getDiscountCode();
    		rows.add(dataCol);
    	}
    	return rows;
}

	public List<String[]> writeInvalidOfferData(List<AirlineTicket> tickets) {
		List<String[]> rows = new ArrayList<>();
		int colSize=11;
		String[] headerCol = new String[colSize];
		AirlineTicket.writeTicketHeader(headerCol);
		headerCol[TicketFileKey.ERROR.getIndex()]=TicketFileKey.ERROR.getValue();
        rows.add(headerCol);
    	for(AirlineTicket ticket:tickets)	{
    		String[] dataCol = new String[colSize];
    		ticket.writeTicketData( dataCol);
    		dataCol[TicketFileKey.ERROR.getIndex()]=ticket.getError();
    		rows.add(dataCol);
    	}
    	return rows;
	}
	public boolean isOfferValid(AirlineTicket ticket) {
		boolean isValid = true;
		if(!DataValidationUtility.isPatternMatch(ticket.getEmail(), Constant.EMAIL_PATTERN)) {
			ticket.setError(Constant.EMAIL_INVALID);
			isValid=false;
		}else if(!DataValidationUtility.isPatternMatch(ticket.getMobilePhone(), Constant.MOBILE_PATTERN)) {
			ticket.setError(Constant.MOBILE_INVALID);
			isValid=false;
		}else if (Cabin.findByValue(ticket.getBookedCabin())==null) {
			ticket.setError(Constant.CABIN_INVALID);
			isValid=false;
		}else if (ticket.getPnr().length()!=6 || !DataValidationUtility.isPatternMatch(ticket.getPnr(), Constant.ALPHA_NUMERIC_PATTERN)) {
			ticket.setError(Constant.PNR_INVALID);
			isValid=false;
		}else if (!ticket.getTicketingDate().before(ticket.getTravelDate())) {
			ticket.setError(Constant.TICKET_DATE_INVALID);
			isValid=false;
		}
		return isValid;
	}
	
	public void applyOffer(AirlineTicket ticket) {
		char fare=ticket.getFareClass().charAt(0);
		if(fare>='A'  && fare<='E') {
			ticket.setDiscountCode(OfferType.OFFER_20.name());
		}else if(fare>='F'  && fare<='K') {
			ticket.setDiscountCode(OfferType.OFFER_30.name());
		}else if(fare>='L'  && fare<='R') {
			ticket.setDiscountCode(OfferType.OFFER_25.name());
		}else {
			ticket.setDiscountCode("");
		}
	}


}
