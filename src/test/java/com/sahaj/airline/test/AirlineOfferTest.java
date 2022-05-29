package com.sahaj.airline.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import com.sahaj.airline.Offer;
import com.sahaj.airline.domain.AirlineOffer;
import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.enums.Cabin;
import com.sahaj.airline.enums.OfferType;


public class AirlineOfferTest {

    @Test
    public void testApplyOfferSuccess1() {
    	AirlineTicket ticket = new AirlineTicket();
    	ticket.setFareClass("A");
    	Offer offer=new AirlineOffer();
    	offer.applyOffer(ticket);
    	assertEquals(OfferType.OFFER_20.name(), ticket.getDiscountCode());
    }
    @Test
    public void testApplyOfferSuccess2() {
    	AirlineTicket ticket = new AirlineTicket();
    	ticket.setFareClass("K");
    	Offer offer=new AirlineOffer();
    	offer.applyOffer(ticket);
    	assertEquals(OfferType.OFFER_30.name(), ticket.getDiscountCode());
    }
    @Test
    public void testApplyOfferSuccess3() {
    	AirlineTicket ticket = new AirlineTicket();
    	ticket.setFareClass("O");
    	Offer offer=new AirlineOffer();
    	offer.applyOffer(ticket);
    	assertEquals(OfferType.OFFER_25.name(), ticket.getDiscountCode());
    }

    @Test
    public void testApplyOfferFailure() {
    	AirlineTicket ticket = new AirlineTicket();
    	Offer offer=new AirlineOffer();
        assertThrows(NullPointerException.class, () -> {
        	offer.applyOffer(ticket);
        });
    }
    @Test
    public void testIsOfferValidSuccess() {
    	AirlineTicket ticket = new AirlineTicket();
    	ticket.setEmail("a@a.cp");
    	ticket.setMobilePhone("87567777777");
    	ticket.setPnr("dy66dg");
    	ticket.setBookedCabin(Cabin.Business.getValue());
    	ticket.setTravelDate(new Date());
    	ticket.setTicketingDate(DateUtils.addDays(new Date(), -1));
    	Offer offer=new AirlineOffer();
    	assertEquals(true, offer.isOfferValid(ticket));
    }
    @Test
    public void testIsOfferValidFailure() {
    	AirlineTicket ticket = new AirlineTicket();
    	ticket.setEmail("aa.cp");
    	ticket.setMobilePhone("87567777777");
    	ticket.setPnr("dy66dg");
    	ticket.setBookedCabin(Cabin.Business.getValue());
    	ticket.setTravelDate(new Date());
    	ticket.setTicketingDate(DateUtils.addDays(new Date(), -1));
    	Offer offer=new AirlineOffer();
    	assertEquals(false, offer.isOfferValid(ticket));
    }
    @Test
    public void testApplyOfferFailureException() {
    	AirlineTicket ticket = new AirlineTicket();
    	ticket.setEmail("aa@ad.cp");
    	ticket.setMobilePhone("87567777777");
    	ticket.setBookedCabin(Cabin.Business.getValue());
    	ticket.setTravelDate(new Date());
    	ticket.setTicketingDate(DateUtils.addDays(new Date(), -1));
    	Offer offer=new AirlineOffer();
        assertThrows(NullPointerException.class, () -> {
        	offer.isOfferValid(ticket);
        });
    }


}
