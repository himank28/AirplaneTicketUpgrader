package com.sahaj.airline.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.sahaj.airline.domain.AirlineTicket;

public class AirlineTicketTest {
    @Test
    public void testWriteTicketDataNoException() {
    	AirlineTicket ticket = new AirlineTicket();
    	ticket.setFirstName("Abhishek");
    	ticket.setLastName("Kumar");
    	ticket.setPnr("ABC123");
    	ticket.setFareClass("F");
    	ticket.setTravelDate(new Date());
    	ticket.setPax("2");
    	ticket.setTicketingDate(new Date());
    	ticket.setEmail("abhishek@zzz.com");
    	ticket.setMobilePhone("5757575757");
    	ticket.setBookedCabin("Economy");
    	String[] data = new String[10];
    	assertDoesNotThrow(() -> {
    		ticket.writeTicketData(data);
        });  
    }
    @Test
    public void testTicketConstructorNoException() {
    	String [] data = {"Abhishek"," Kumar","ABC123","F",	"2019-07-31","2","2019-05-21","abhishek@zzz.com","9876543210","Economy"};
    	assertDoesNotThrow(() -> {
    		AirlineTicket ticket = new AirlineTicket(data);
    		assertEquals("Abhishek", ticket.getFirstName());
    	});  
    }
    	

}
