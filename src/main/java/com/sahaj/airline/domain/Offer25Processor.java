package com.sahaj.airline.domain;

import com.sahaj.airline.enums.OfferType;

public class Offer25Processor extends OfferProcessor{
	public Offer25Processor(OfferProcessor nextProcessor){
        super(nextProcessor);
    }
 
    @Override
    public void process(AirlineTicket ticket)
    {
		char fare=ticket.getFareClass().charAt(0);
		if(ticket.isValid() && fare>='L'  && fare<='R') {
			ticket.setDiscountCode(OfferType.OFFER_25.name());
		}else
        {
            super.process(ticket);
        }
    }

}
