package com.sahaj.airline.interfaces;

import java.util.List;

import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.exception.InvalidDataFormatException;
import com.sahaj.airline.exception.InvalidFileCreationPathException;
import com.sahaj.airline.exception.InvalidFileFormatException;

public interface FileOperation {
	
	public  List<AirlineTicket> getTicketsFromFile(String file) throws  InvalidFileFormatException,InvalidDataFormatException;

	public void writeInvalidOfferData(List<AirlineTicket> tickets) throws  InvalidFileCreationPathException ;
	
	public void writeValidOfferData(List<AirlineTicket> tickets) throws InvalidFileCreationPathException ;

}
