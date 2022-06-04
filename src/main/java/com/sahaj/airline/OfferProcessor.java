package com.sahaj.airline;

import com.sahaj.airline.domain.AirlineTicket;

abstract class OfferProcessor {

    private OfferProcessor nextProcessor;
 
    OfferProcessor(OfferProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
     
    public void process(AirlineTicket ticket){
        if(nextProcessor != null)
            nextProcessor.process(ticket);
    };
}
