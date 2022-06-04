package com.sahaj.airline;

import com.sahaj.airline.domain.AirlineTicket;

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
