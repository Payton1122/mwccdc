package com.itccloud.mwccdc.controller;

import java.io.IOException;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itccloud.mwccdc.Person;
import com.itccloud.mwccdc.Address;

import com.itccloud.mwccdc.FileHandler;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "hello");
		return "index-form";
	}
	
	
	@GetMapping("/advance")
	public String advance(Model model) throws IOException {
		String fileBasePath = "/Users/paytonzartman/eclipse-workspace/ITC475/A2FileHandling/";
        String fileName = "persons2.csv";
        String fullFileName = fileBasePath + fileName;
        
        //objects
        List<Person> people = new ArrayList<Person>();
        List<Address> addresses = new ArrayList<Address>();
        
		Map<String, List<?>> formMap = FileHandler.readCSV(fullFileName, people, addresses);
		
		model.addAttribute("users", formMap);
		
		return "advance-form";
	}

	
	@GetMapping("/home")
	public String home(Model model) {
		return "home-form";
	}
	
	
	@GetMapping("/business1")
	public String business1(Model model) {
		return "business1-form";
	}
	
	
	@GetMapping("/bootstrap")
	public String bootstrap(Model model) {
		return "bootstrap-form";
	}
	
}
