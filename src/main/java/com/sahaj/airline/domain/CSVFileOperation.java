package com.sahaj.airline.domain;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.sahaj.airline.FileOperation;
import com.sahaj.airline.exception.BusinessException;

public class CSVFileOperation implements FileOperation{

	@Override
	public List<String[]> readFile(String file) throws  BusinessException {
		try {
		FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                                  .withSkipLines(1)
                                  .build();
			return csvReader.readAll();
		} catch (IOException | CsvException e) {
			throw new BusinessException(e.getMessage());
		}
	}
	public void writeFile(String filePath, List<String[]> data) throws BusinessException {
		File file = new File(filePath);
		try {
			if(file.createNewFile()) {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			writer.writeAll(data);
			writer.close();
			}else {
				System.out.println("Not created");
			}
		}
		catch (IOException e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
}
