package com.sahaj.airline.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sahaj.airline.FileOperation;
import com.sahaj.airline.domain.AirlineTicket;
import com.sahaj.airline.domain.CSVFileOperation;
import com.sahaj.airline.exception.InvalidFileFormatException;

public class CsvFileOperationTest {
	   @Test
	    public void testReadFileSuccess() throws  InvalidFileFormatException {
		   FileOperation fileOperation = new CSVFileOperation();
		   List<AirlineTicket> data = fileOperation.getTicketsFromFile();
		   assertEquals("Abhishek", data.get(0).getFirstName());
	    }
	 
}
