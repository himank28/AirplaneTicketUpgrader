package com.sahaj.airline;

import java.util.List;

import com.sahaj.airline.exception.BusinessException;

public interface FileOperation {

	public List<String[]> readFile(String path) throws BusinessException;

	public void writeFile(String filePath, List<String[]> data) throws BusinessException ;
	
}
