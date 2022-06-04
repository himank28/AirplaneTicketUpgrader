package com.sahaj.airline;

import java.util.List;

import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.exception.InvalidFileFormatException;

public interface FileOperation {
	
	public  List<AirlineTicket> getTicketsFromFile() throws InvalidFileFormatException;

	public void writeInvalidOfferData(List<AirlineTicket> tickets) throws InvalidFileFormatException ;
	
	public void writeValidOfferData(List<AirlineTicket> tickets) throws InvalidFileFormatException ;

}
