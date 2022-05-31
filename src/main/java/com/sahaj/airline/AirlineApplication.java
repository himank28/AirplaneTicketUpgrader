package com.sahaj.airline;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sahaj.airline.domain.AirlineOffer;
import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.domain.CSVFileOperation;
import com.sahaj.airline.exception.BusinessException;

@SpringBootApplication
public class AirlineApplication {
	private static final Logger Logger = LoggerFactory.getLogger(AirlineApplication.class);
	public static void main(String[] args) {
		String inputFilePath = "sahaj/TravelData.csv";
		String validOfferFilePath = "sahaj/ValidOfferTickets";
		String invalidOfferFilePath = "sahaj/InvalidOfferTickets";
		try {
			FileOperation fileOperation = new CSVFileOperation();
			AirlineOffer offer = new AirlineOffer();
			List<String[]> fileData = fileOperation.readFile(inputFilePath);
			Logger.info("File reading completed");
			
			List<AirlineTicket> tickets=getTicketFromFileData(fileData);
			List<AirlineTicket> validOfferTickets=getValidOfferTickets(tickets,offer);
			applyOfferToTickets(validOfferTickets,offer);
			List<AirlineTicket> failedOfferTicket =getInvalidOfferTickets(tickets,offer);
			Logger.info("Valid & invalid Tickets segregated");
			
			fileOperation.writeFile(validOfferFilePath+Calendar.getInstance().getTimeInMillis()+".csv", offer.writeValidOfferData(validOfferTickets));
			fileOperation.writeFile(invalidOfferFilePath+Calendar.getInstance().getTimeInMillis()+".csv", offer.writeInvalidOfferData(failedOfferTicket));
			Logger.info("File created for valid and invalid tickets");
			
		}catch( Exception  e) {
			e.printStackTrace();
		} 
	}
	private static List<AirlineTicket> getTicketFromFileData(List<String[]> fileData) throws BusinessException{
		List<AirlineTicket> tickets = new ArrayList<>();
		for(String[] rows:fileData){
			tickets.add(new AirlineTicket(rows));
		}
		return tickets;
	}
	private static List<AirlineTicket> getValidOfferTickets(List<AirlineTicket> tickets, AirlineOffer offer ) {
		return tickets.stream().filter(offer::isOfferValid).collect(Collectors.toList());
	}
	private static void applyOfferToTickets(List<AirlineTicket> validOfferTickets, AirlineOffer offer ) {
		validOfferTickets.forEach( offer::applyOffer);
	}
	private static List<AirlineTicket> getInvalidOfferTickets(List<AirlineTicket> tickets, AirlineOffer offer ) {
		return tickets.stream().filter(x->!offer.isOfferValid(x)).collect(Collectors.toList());
	}

}
