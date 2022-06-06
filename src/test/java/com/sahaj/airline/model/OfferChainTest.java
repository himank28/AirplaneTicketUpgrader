package com.sahaj.airline.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.enums.Cabin;
import com.sahaj.airline.enums.OfferType;
import com.sahaj.airline.interfaces.OfferChain;

public class OfferChainTest {
	@Test
	public void testOfferChainSuccess() {
    	
		OfferChain chain = new OfferChain();
		AirlineTicket ticket = new AirlineTicket.TicketBuilder("abhishek@agas.zzz.com","5757875757",Cabin.Economy.name(),"ABC453",new Date(),DateUtils.addDays(new Date(), -1))
				.firstName("Abhhishek").fareClass("A").pax("2").lastName("Kumwarr").build();
		chain.process(ticket);
		assertEquals(OfferType.OFFER_20.name(), ticket.getDiscountCode());
	}
	@Test
	public void testOfferChainSuccess2() {
    	
		OfferChain chain = new OfferChain();
		AirlineTicket ticket = new AirlineTicket.TicketBuilder("abhishek@agmais.zzz.com","5753475757",Cabin.Economy.name(),"ABC223",new Date(),DateUtils.addDays(new Date(), -1))
				.firstName("Abhishhek").fareClass("H").pax("2").lastName("Kumsarr").build();
		chain.process(ticket);
		assertEquals(OfferType.OFFER_30.name(), ticket.getDiscountCode());
	}
	@Test
	public void testOfferChainSuccess3() {
    	
		OfferChain chain = new OfferChain();
		AirlineTicket ticket = new AirlineTicket.TicketBuilder("abhishek@ags.zzz.com","5757575757","Economy","ABC423",new Date(),DateUtils.addDays(new Date(), -1))
				.firstName("Abhishek").fareClass("N").pax("2").lastName("Kumarr").build();
		chain.process(ticket);
		assertEquals(OfferType.OFFER_25.name(), ticket.getDiscountCode());
	}
	@Test
	public void testOfferChainSuccess4() {
    	
		OfferChain chain = new OfferChain();
		AirlineTicket ticket = new AirlineTicket.TicketBuilder("abhishek@ags.zzz.com","5757575757","Economy","ABC423",new Date(),DateUtils.addDays(new Date(), -1))
				.firstName("Abhishek").fareClass("U").pax("2").lastName("Kumarr").build();
		chain.process(ticket);
		assertEquals(null, ticket.getDiscountCode());
	}


}
