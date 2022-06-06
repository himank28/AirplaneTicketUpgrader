package com.sahaj.airline.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.sahaj.airline.TicketUpgrade;
import com.sahaj.airline.service.AirlineTicketUpgradeService;

public class TicketUpgradeTest {

	@Test
	public void testTicketUpgradeSuccess() {
		TicketUpgrade ticketUpgrade = new AirlineTicketUpgradeService();
		assertDoesNotThrow(()->
			ticketUpgrade.upgradeTickets("sahaj/TravelData.csv")
		);
	}

}
