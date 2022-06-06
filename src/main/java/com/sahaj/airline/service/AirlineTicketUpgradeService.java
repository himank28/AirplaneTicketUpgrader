package com.sahaj.airline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sahaj.airline.FileOperation;
import com.sahaj.airline.TicketUpgrade;
import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.domain.CSVFileOperation;
import com.sahaj.airline.exception.InvalidDataFormatException;
import com.sahaj.airline.exception.InvalidFileCreationPathException;
import com.sahaj.airline.exception.InvalidFileFormatException;

public class AirlineTicketUpgradeService implements TicketUpgrade{

	FileOperation fileOperation = new CSVFileOperation();
	private static final Logger Logger = LoggerFactory.getLogger(AirlineTicketUpgradeService.class);

	public void upgradeTickets(String file) throws InvalidFileFormatException, InvalidDataFormatException, InvalidFileCreationPathException {
			List<AirlineTicket> tickets=fileOperation.getTicketsFromFile(file);
			Logger.info("File reading completed");			
			createFilesForValidAndInvalidTickets(tickets);
			Logger.info("File created for valid and invalid tickets");
	}

	private static List<AirlineTicket> getValidOfferTickets(List<AirlineTicket> tickets) {
		return tickets.stream().filter(AirlineTicket::isValid).collect(Collectors.toList());
	}
	private static List<AirlineTicket> getInvalidOfferTickets(List<AirlineTicket> tickets) {
		return tickets.stream().filter(x->!x.isValid()).collect(Collectors.toList());
	}
	private void createFilesForValidAndInvalidTickets(List<AirlineTicket> tickets) throws InvalidFileCreationPathException {
		fileOperation.writeValidOfferData(getValidOfferTickets(tickets));
		fileOperation.writeInvalidOfferData(getInvalidOfferTickets(tickets));

	}

}
