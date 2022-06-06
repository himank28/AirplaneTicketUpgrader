package com.sahaj.airline.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.enums.OfferType;

public class AirlineTicketTest {
    @Test
    public void testTicketBuilderNoException() {
    	assertDoesNotThrow(() -> {
    		AirlineTicket ticket = new AirlineTicket.TicketBuilder("abhishek@zzz.com","5757575757","Economy","ABC123",new Date(),DateUtils.addDays(new Date(), -1))
    				.firstName("Abhishek").fareClass("A").pax("2").lastName("Kumarr").build();
    		assertEquals("Abhishek", ticket.getFirstName());
        });  
    }
    @Test
    public void testTicketValidateNoException() {
    	assertDoesNotThrow(() -> {
    		AirlineTicket ticket = new AirlineTicket.TicketBuilder("abhishek@zzz.com","5757575757","Economy","ABC123",new Date(),DateUtils.addDays(new Date(), -1))
    				.firstName("Abhhishek").fareClass("A").pax("2").lastName("Kumarr").build();
    		assertEquals(OfferType.OFFER_20.name(), ticket.getDiscountCode());
        });  
    }

}
