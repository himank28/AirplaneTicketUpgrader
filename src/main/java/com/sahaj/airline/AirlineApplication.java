package com.sahaj.airline;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.domain.CSVFileOperation;

@SpringBootApplication

public class AirlineApplication {
	private static final Logger Logger = LoggerFactory.getLogger(AirlineApplication.class);
	public static void main(String[] args) {
		try {
			FileOperation fileOperation = new CSVFileOperation();
			List<AirlineTicket> tickets=fileOperation.getTicketsFromFile();
			Logger.info("File reading completed");			
			
			fileOperation.writeValidOfferData(getValidOfferTickets(tickets));
			fileOperation.writeInvalidOfferData(getInvalidOfferTickets(tickets));
			Logger.info("File created for valid and invalid tickets");
			
		}catch( Exception  e) {
			e.printStackTrace();
		} 
	}
	private static List<AirlineTicket> getValidOfferTickets(List<AirlineTicket> tickets) {
		return tickets.stream().filter(AirlineTicket::isValid).collect(Collectors.toList());
	}
	private static List<AirlineTicket> getInvalidOfferTickets(List<AirlineTicket> tickets) {
		return tickets.stream().filter(x->!x.isValid()).collect(Collectors.toList());
	}

}
