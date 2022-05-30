package com.sahaj.airline.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sahaj.airline.FileOperation;
import com.sahaj.airline.domain.CSVFileOperation;
import com.sahaj.airline.exception.BusinessException;

public class CsvFileOperationTest {
	   @Test
	    public void testReadFileSuccess() throws BusinessException {
		   String filePath = "src/test/java/resources/TravelData.csv";
		   FileOperation fileOperation = new CSVFileOperation();
		   List<String []> data = fileOperation.readFile(filePath);
		   assertEquals("Abhishek", data.get(0)[0]);
	    }
	 
}
