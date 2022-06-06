package com.sahaj.airline.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import com.sahaj.airline.FileOperation;
import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.domain.CSVFileOperation;
import com.sahaj.airline.enums.Cabin;
import com.sahaj.airline.exception.InvalidDataFormatException;
import com.sahaj.airline.exception.InvalidFileFormatException;

public class CsvFileOperationTest {

	@Test
	public void testGetTicketsFromFileSuccess() throws  InvalidFileFormatException, InvalidDataFormatException {
		   FileOperation fileOperation = new CSVFileOperation();
		   List<AirlineTicket> data = fileOperation.getTicketsFromFile("sahaj/TravelData.csv");
		   assertEquals("Abhishek", data.get(0).getFirstName());
	}
	@Test
	public void testWriteInvalidOfferDataSuccess() {
    	
		List<AirlineTicket> tickets = new ArrayList<>();
		AirlineTicket ticket1 = new AirlineTicket.TicketBuilder("abhishek@zzz.com","5757575757",Cabin.Business.name(),"ABC12",new Date(),new Date())
				.firstName("Abhiishek").fareClass("A").pax("2").lastName("Kumarr").build();
		AirlineTicket ticket2 = new AirlineTicket.TicketBuilder("abhishek.com","5753333757",Cabin.Economy.name(),"ABC123",new Date(),new Date())
				.firstName("Abbhishek").fareClass("A").pax("2").lastName("Kumar").build();
		tickets.add(ticket1);
		tickets.add(ticket2);
		assertDoesNotThrow(()->{
			FileOperation fileOperation = new CSVFileOperation();
			fileOperation.writeInvalidOfferData(tickets);
		});
	}
	@Test
	public void testWriteValidOfferDataSuccess() {
    	
		List<AirlineTicket> tickets = new ArrayList<>();
		AirlineTicket ticket1 = new AirlineTicket.TicketBuilder("abhishek@ags.zzz.com","5757575757","Economy","ABC423",new Date(),DateUtils.addDays(new Date(), -1))
				.firstName("Abhishekk").fareClass("A").pax("2").lastName("Kumarr").build();
		AirlineTicket ticket2 = new AirlineTicket.TicketBuilder("abhishek@ahbdh.com","5753333757","Economy","ABC423",new Date(),DateUtils.addDays(new Date(), -1))
				.firstName("Abhishek").fareClass("A").pax("2").lastName("Kumar").build();
		tickets.add(ticket1);
		tickets.add(ticket2);
		assertDoesNotThrow(()->{
			FileOperation fileOperation = new CSVFileOperation();
			fileOperation.writeValidOfferData(tickets);
		});
	}
}
