package com.sahaj.airline.domain;

import com.sahaj.airline.enums.OfferType;

public class Offer20Processor extends OfferProcessor {
	public Offer20Processor(OfferProcessor nextProcessor){
        super(nextProcessor);
    }
 
    @Override
    public void process(AirlineTicket ticket)
    {
		char fare=ticket.getFareClass().charAt(0);
		if(ticket.isValid() && fare>='A'  && fare<='E') {
			ticket.setDiscountCode(OfferType.OFFER_20.name());
		}else
        {
            super.process(ticket);
        }
    }

}
