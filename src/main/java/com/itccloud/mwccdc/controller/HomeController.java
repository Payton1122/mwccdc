package com.itccloud.mwccdc.controller;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itccloud.mwccdc.Person;
import com.itccloud.mwccdc.mapper.CcdcPoint;
import com.itccloud.mwccdc.mapper.CcdcPointService;
import com.itccloud.mwccdc.mapper.CcdcPointView;
import com.itccloud.mwccdc.mapper.CcdcRepository;
import com.itccloud.mwccdc.mapper.CcdcTask;
import com.itccloud.mwccdc.mapper.CcdcUser;
import com.itccloud.mwccdc.mapper.project.*;
import com.itccloud.mwccdc.mapper.project.projectObj.Fan;
import com.itccloud.mwccdc.mapper.project.projectObj.RewardedFan;
import com.itccloud.mwccdc.mapper.project.projectObj.Stand;
import com.itccloud.mwccdc.Address;

import com.itccloud.mwccdc.FileHandler;

@Controller
public class HomeController {
	
	@Autowired
	private CcdcRepository repository;
	
	@Autowired
	private CcdcPointService service;
	
	@Autowired
	private PreferenceRepository fanRepo;
	
	@Autowired
	private PreferenceService fanService;
	
	
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
	
	@GetMapping("/bootstrap-point")
	public String bootstrapPoint(Model model) {
		
//		List<CcdcUser> ccdcUsers = repository.findUsers();
//		List<CcdcTask> ccdcTasks = repository.findTasks();
//		List<CcdcPoint> ccdcPoint = repository.findPoints();
//		
//		model.addAttribute("ccdcusers", ccdcUsers);
//		model.addAttribute("ccdctasks", ccdcTasks);
//		model.addAttribute("ccdcPoint", ccdcPoint);
		
		List<CcdcPointView> ccdcPointViews = service.findPointViews();
		model.addAttribute("ccdcpointview", ccdcPointViews);
		
		return "bootstrap-point";
	}
	
	@GetMapping("/Project-1-gathering")
	public String project1Gathering(Model model) {
		
		List<Stand> stand = fanService.retrieveStand();
		model.addAttribute("stand", stand);
				
		return "Project-1-summary";
	}
	
	@GetMapping("/Project-1-summary")
	public String project1Summary(Model model) {
		
		List<Fan> fan = fanService.retrieveFan();
		model.addAttribute("fan", fan);
				
		return "Project-1-gathering";
	}
	
	
	@GetMapping("/Project-1-reward")
	public String project1Reward(Model model) {
		
		List<RewardedFan> RewardedFan = fanService.retrieveReward();
		model.addAttribute("RewardedFan", RewardedFan);
				
		return "Project-1-reward";
	}
	
}
