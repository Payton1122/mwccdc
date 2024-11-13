package com.itccloud.mwccdc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.itccloud.mwccdc.mapper.CcdcPoint;
import com.itccloud.mwccdc.mapper.CcdcPointService;
import com.itccloud.mwccdc.mapper.project.PreferenceService;
import com.itccloud.mwccdc.mapper.project.projectObj.Fan;
import com.itccloud.mwccdc.mapper.project.projectObj.RewardedFan;

@RestController
public class AjaxController {
	
	@Autowired 
	CcdcPointService ccdcservice;
	
	@Autowired 
	PreferenceService prefService;

	@PostMapping("/api/savepoints")
	public String handlePointUpdate(@RequestBody String requestBody) {
		
		ObjectMapper mapper = new ObjectMapper();
		boolean ret = true;
		try {
			List<CcdcPoint> points = mapper.readValue(requestBody, 
					new TypeReference<List<CcdcPoint>>() {});
			ccdcservice.updatePoints(points);
		} catch (Exception e) {
			ret = false;
			e.printStackTrace();
		}
		
		if(ret) {
			return "{\"code\":\"success\"}";
		}
		return "{\"code\":\"failed\"}";
	}
	
	@PostMapping("/api/insertFan")
	public String handleFanAddition(@RequestBody String requestBody) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		JsonMapper.builder().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		boolean ret = true;
		
		try {
			//For Single fan due to deserialization
			
			Fan fan = mapper.readValue(requestBody, Fan.class);
			
			List<Fan> fanList = new ArrayList<Fan>();
	        fanList.add(fan);
	        
			prefService.insertFan(fanList);
		} catch (Exception e) {
			ret = false;
			e.printStackTrace();
		}
		
		if(ret) {
			System.out.println("Success");
			return "{\"code\":\"success\"}";
		} 
		System.out.println("Failure");
		return "{\"code\":\"failed\"}";
	}
	
	@PostMapping("/api/upload")
	public String handleImport(@RequestBody String requestBody) {
		
		try {
			
			System.out.println("Truncating Fan");
			prefService.truncFan();
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			JsonMapper.builder().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			
			List<Fan> fan = mapper.readValue(requestBody, 
					new TypeReference<List<Fan>>() {});
			System.out.println("Inserting Fan");
			prefService.insertFan(fan);
			
			return "{\"code\":\"success\"}";
			
		} catch(Exception e) {
			
			e.printStackTrace();
			return "{\"code\":\"failed\"}";
			
		}
		
	}
	
	@PostMapping("/api/append")
	public String handleAppend(@RequestBody String requestBody) {
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			JsonMapper.builder().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			
			List<Fan> fan = mapper.readValue(requestBody, 
					new TypeReference<List<Fan>>() {});
			prefService.insertFan(fan);
			
			System.out.println("Success");
			
			return "{\"code\":\"success\"}";
			
		} catch(Exception e) {
			
			e.printStackTrace();
			return "{\"code\":\"failed\"}";
			
		}
		
	}
	
	@PostMapping("/api/assignRewards")
	public String assignRewards() {
		
		try {
			
			prefService.assignRewards();
			System.out.println("Assigned");
			return "{\"code\":\"success\"}";
			
		} catch(Exception e) {
			
			e.printStackTrace();
			return "{\"code\":\"failed\"}";
			
		}
		
	}
	
}
