package com.sahaj.airline;

import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.enums.OfferType;

public class Offer30Processor extends OfferProcessor {
	public Offer30Processor(OfferProcessor nextProcessor){
        super(nextProcessor);
    }
	
	@Override
    public void process(AirlineTicket ticket)
    {
		char fare=ticket.getFareClass().charAt(0);
		if(ticket.isValid() && fare>='F'  && fare<='K') {
			ticket.setDiscountCode(OfferType.OFFER_30.name());
		}else
        {
            super.process(ticket);
        }
    }
}
