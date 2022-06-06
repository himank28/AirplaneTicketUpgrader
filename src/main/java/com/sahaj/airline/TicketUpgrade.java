package com.sahaj.airline;

import com.sahaj.airline.exception.InvalidDataFormatException;
import com.sahaj.airline.exception.InvalidFileCreationPathException;
import com.sahaj.airline.exception.InvalidFileFormatException;

public interface TicketUpgrade {

	public void upgradeTickets(String filePath) throws InvalidFileFormatException, InvalidDataFormatException, InvalidFileCreationPathException ;
}
