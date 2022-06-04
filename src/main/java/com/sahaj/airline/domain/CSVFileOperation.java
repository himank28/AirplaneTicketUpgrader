package com.sahaj.airline.domain;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.sahaj.airline.FileOperation;
import com.sahaj.airline.constants.Constant;
import com.sahaj.airline.enums.TicketFileKey;
import com.sahaj.airline.exception.InvalidFileFormatException;

public class CSVFileOperation implements FileOperation{

    @Value("${srcFile}")
	private String srcFile="sahaj/TravelData.csv";

    @Value("${destValidFile}")
	private String destValidFile="sahaj/ValidOfferTickets";
    
    @Value("${destInvalidFile}")
	private String destInvalidFile="sahaj/InvalidOfferTickets";

	private List<String[]> readFile(String file) throws  InvalidFileFormatException {
		try {
		FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                                  .withSkipLines(1)
                                  .build();
			return csvReader.readAll();
		} catch (IOException | CsvException e) {
			throw new InvalidFileFormatException(e.getMessage());
		}
	}
	public  List<AirlineTicket> getTicketsFromFile() throws InvalidFileFormatException{
		List<AirlineTicket> tickets = new ArrayList<>();
		try {
			for(String[] rows:readFile(srcFile)){
				tickets.add(getTicket(rows));
			}
		}catch(ParseException e) {
			e.printStackTrace();
			throw new InvalidFileFormatException("Invalid format data in file");
		}
		return tickets;
	}
	private AirlineTicket getTicket(String [] rows) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(Constant.FILE_DATE_FORMAT);
		return  new AirlineTicket.TicketBuilder(rows[TicketFileKey.EMAIL.getIndex()].trim(),
				rows[TicketFileKey.MOBILE.getIndex()].trim(),
				rows[TicketFileKey.BOOKED_CABIN.getIndex()].trim(),
				rows[TicketFileKey.PNR.getIndex()].trim(),
				sdf.parse(rows[TicketFileKey.TRAVEL_DATE.getIndex()].trim()),
				sdf.parse(rows[TicketFileKey.TICKET_DATE.getIndex()].trim())
				)
				.fareClass(rows[TicketFileKey.FARE_CLASS.getIndex()].trim())
				.firstName(rows[TicketFileKey.FIRST_NAME.getIndex()].trim())
				.lastName(rows[TicketFileKey.LAST_NAME.getIndex()].trim())
				.pax(rows[TicketFileKey.PAX.getIndex()].trim())
				.build();
	}
	
	private void writeFile(String filePath, List<String[]> data) throws InvalidFileFormatException {
		File file = new File(filePath);
		try {
			if(file.createNewFile()) {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			writer.writeAll(data);
			writer.close();
			}else {
				throw new InvalidFileFormatException("Unable to create file");
			}
		}
		catch (IOException e) {
			throw new InvalidFileFormatException(e.getMessage());
		}
	}
	public void writeValidOfferData(List<AirlineTicket> tickets) throws InvalidFileFormatException {
		List<String[]> rows = new ArrayList<>();
		int colSize=11;
		String[] headerCol = new String[colSize];
		AirlineTicket.writeTicketHeader(headerCol);
		headerCol[TicketFileKey.DISCOUNT_CODE.getIndex()]=TicketFileKey.DISCOUNT_CODE.getValue();
        rows.add(headerCol);
    	for(AirlineTicket ticket:tickets)	{
    		String[] dataCol = new String[colSize];
    		writeTicketData( dataCol,ticket);
    		dataCol[TicketFileKey.DISCOUNT_CODE.getIndex()]=ticket.getDiscountCode();
    		rows.add(dataCol);
    	}
    	writeFile(getFileNameWithTimestamp(destValidFile),rows);
	}

	public void writeInvalidOfferData(List<AirlineTicket> tickets) throws InvalidFileFormatException {
		List<String[]> rows = new ArrayList<>();
		int colSize=11;
		String[] headerCol = new String[colSize];
		AirlineTicket.writeTicketHeader(headerCol);
		headerCol[TicketFileKey.ERROR.getIndex()]=TicketFileKey.ERROR.getValue();
        rows.add(headerCol);
    	for(AirlineTicket ticket:tickets)	{
    		String[] dataCol = new String[colSize];
    		writeTicketData( dataCol,ticket);
    		dataCol[TicketFileKey.ERROR.getIndex()]=ticket.getError();
    		rows.add(dataCol);
    	}
    	writeFile(getFileNameWithTimestamp(destInvalidFile),rows);
	}
	private String getFileNameWithTimestamp(String file) {
		return file+Calendar.getInstance().getTimeInMillis()+".csv";
	}
	private void writeTicketData(String[] dataCol, AirlineTicket ticket) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constant.FILE_DATE_FORMAT);
		dataCol[TicketFileKey.FIRST_NAME.getIndex()]=ticket.getFirstName();
		dataCol[TicketFileKey.LAST_NAME.getIndex()]=ticket.getLastName();
		dataCol[TicketFileKey.PNR.getIndex()]=ticket.getPnr();
		dataCol[TicketFileKey.FARE_CLASS.getIndex()]=ticket.getFareClass();
		dataCol[TicketFileKey.TRAVEL_DATE.getIndex()]=sdf.format(ticket.getTravelDate());
		dataCol[TicketFileKey.PAX.getIndex()]=ticket.getPax();
		dataCol[TicketFileKey.TICKET_DATE.getIndex()]=sdf.format(ticket.getTicketingDate());
		dataCol[TicketFileKey.EMAIL.getIndex()]=ticket.getEmail();
		dataCol[TicketFileKey.MOBILE.getIndex()]=ticket.getMobilePhone();
		dataCol[TicketFileKey.BOOKED_CABIN.getIndex()]=ticket.getBookedCabin();
	}

}
