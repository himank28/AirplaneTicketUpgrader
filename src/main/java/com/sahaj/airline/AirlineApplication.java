package com.sahaj.airline;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sahaj.airline.service.AirlineTicketUpgradeService;

@SpringBootApplication

public class AirlineApplication {
	public static void main(String[] args) {
		AirlineTicketUpgradeService upgradeService = new  AirlineTicketUpgradeService();
		upgradeService.upgradeTickets() ;
	}

}
