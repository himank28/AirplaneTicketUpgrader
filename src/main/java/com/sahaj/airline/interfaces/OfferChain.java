package com.sahaj.airline.interfaces;

import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.domain.Offer20Processor;
import com.sahaj.airline.domain.Offer25Processor;
import com.sahaj.airline.domain.Offer30Processor;
import com.sahaj.airline.domain.OfferProcessor;

public class OfferChain {

		OfferProcessor chain;
		 
		public OfferChain(){
		    buildChain();
		}
		 
		private void buildChain(){
		    chain = new Offer20Processor(new Offer30Processor(new Offer25Processor(null)));
		}
		 
		public void process(AirlineTicket request) {
		    chain.process(request);
		}
}
