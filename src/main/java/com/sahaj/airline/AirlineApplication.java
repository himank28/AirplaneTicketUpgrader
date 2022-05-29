package com.sahaj.airline;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sahaj.airline.domain.AirlineOffer;
import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.domain.CSVFileOperation;

@SpringBootApplication
public class AirlineApplication {

	public static void main(String[] args) {
		try {
			FileOperation fileOperation = new CSVFileOperation();
			AirlineOffer offer = new AirlineOffer();
			List<AirlineTicket> tickets = new ArrayList<>();
			List<String[]> fileData = fileOperation.readFile("/home/neebal/TravelData.csv");
			for(String[] rows:fileData){
				tickets.add(new AirlineTicket(rows));
			}
			List<AirlineTicket> offerTicket =tickets.stream().filter(offer::isOfferValid).collect(Collectors.toList());
			offerTicket.forEach( offer::applyOffer);
			List<AirlineTicket> failedOfferTicket =tickets.stream().filter(x->!offer.isOfferValid(x)).collect(Collectors.toList());
			fileOperation.writeFile("sahaj/ValidOfferTickets"+Calendar.getInstance().getTimeInMillis()+".csv", offer.writeValidOfferData(offerTicket));
			fileOperation.writeFile("sahaj/InvalidOfferTickets"+Calendar.getInstance().getTimeInMillis()+".csv", offer.writeInvalidOfferData(failedOfferTicket));
			
		}catch( Exception  e) {
			e.printStackTrace();
		} 
	}

}
