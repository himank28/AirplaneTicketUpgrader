package com.sahaj.airline;

import java.util.List;

import com.sahaj.airline.domain.AirlineTicket;

public interface Offer {

	public List<String[]> writeValidOfferData(List<AirlineTicket> tickets) ;
	
	public List<String[]> writeInvalidOfferData(List<AirlineTicket> tickets) ;

	public boolean isOfferValid(AirlineTicket ticket) ;
	
	public void applyOffer(AirlineTicket ticket) ;

}
