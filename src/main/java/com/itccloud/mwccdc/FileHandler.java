package com.itccloud.mwccdc;

import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;


public class FileHandler {
	
	
	public static Map<String, List<?>> readCSV(
			String fullFileName, 
			List<Person> people,
			List<Address> addresses) throws IOException {
       
        //Setting up Readers
        FileReader reader = new FileReader(fullFileName);
        CSVParser parser = CSVParser.parse(reader, CSVFormat.DEFAULT);
        
        
        for (CSVRecord record: parser) {
        	
        	//Build Person Object
        	Person person = new Person(record.get(0), record.get(1), record.get(2));
        	people.add(person);
        	
        	//Build Address Object 
        	String addressString = record.get(3);
        	
        	Address address = new Address(
        			record.get(3).replace("\"", ""), 
        			record.get(4), 
        			record.get(5), 
        			record.get(6).replace("\"", ""));
        	addresses.add(address);
        }
        
        Map<String, List<?>> fullMap = new HashMap<>();
        fullMap.put("People", people);
        fullMap.put("Address", addresses);
            
        return fullMap;
           
    }
	
	
	public static String writeCSV(
			String fileBasePath, 
			String newFileName,
			Map<String, List<?>> completeMap) throws IOException{
		
		//Setting up writers
		FileWriter writer = new FileWriter(fileBasePath + newFileName);
		CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
		
		//setting up objects
		StringBuilder wBuild = new StringBuilder();
		List<?> persons = completeMap.get("People");
		List<?> addresses = completeMap.get("Address");
		
		
		for (int i = 0; i < completeMap.size(); i++) {
			
			//using String Builder to limit concatenations and writing for performance
			wBuild.append(persons.get(i).toString())
				.append(addresses.get(i).toString())
				.append("\r\n");
			
		}
		
		String webString = wBuild.toString();
		
		printer.printRecord();
		printer.flush();
		printer.close();
		
		return webString;
		
	}
	
}

