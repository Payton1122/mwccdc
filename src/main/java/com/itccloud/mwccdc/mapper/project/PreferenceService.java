package com.itccloud.mwccdc.mapper.project;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itccloud.mwccdc.mapper.project.projectObj.*;

@Service
public class PreferenceService {
	
	@Autowired
	private PreferenceRepository fanPrefrepository;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	public List<Stand> retrieveStand(){
		
		List<Stand> stand = fanPrefrepository.findStand();
		
		return stand;
	}
	
	public List<Fan> retrieveFan(){
			
		List<Fan> fan = fanPrefrepository.findFan();
		
		return fan;
	}
	
	public void insertFan(List<Fan> fans) {
		
		for (Fan fan: fans) {
			fanPrefrepository.insertFan(fan);
		}
	}
	
	public void truncFan() {
		fanPrefrepository.truncFan();
	}

	public List<RewardedFan> retrieveReward() {
		
		List<RewardedFan> rewardedFan = fanPrefrepository.findRewardedFan();
		
		return rewardedFan;
	}

	public void assignRewards() {
		
		List<RewardedFansView> rewardedFans = fanPrefrepository.findRewardedView();
		List<ReservedSeats> reservedSeats = fanPrefrepository.findReservedSeats();

		Collections.shuffle(reservedSeats);

		int size = Math.min(rewardedFans.size(), reservedSeats.size());
		
		fanPrefrepository.truncReward();

		for (int i = 0; i < size; i++) {
		    RewardedFansView fan = rewardedFans.get(i);
		    ReservedSeats seat = reservedSeats.get(i);
		    
		    Reward rw = new Reward();
		    rw.setFanId(fan.getFanId());
		    rw.setStandPosition(fan.getStandPosition());
		    rw.setSeatNumber(seat.getSeatNumber());
		    
		    fanPrefrepository.insertRewards(rw);
		}
		
	}

	
}
