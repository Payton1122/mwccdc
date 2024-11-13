package com.itccloud.mwccdc.mapper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CcdcPointService {
	
	@Autowired
	private CcdcRepository ccdcRepository;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public List<CcdcPointView> findPointViews(){
		
		List<CcdcPointView> rets = new ArrayList<CcdcPointView>();
		
		List<CcdcUser> users = ccdcRepository.findUsers();
		List<CcdcTask> tasks = ccdcRepository.findTasks();
		List<CcdcPoint> points = ccdcRepository.findPoints();
		
		Map<String, CcdcPoint> pointsMap = new HashMap<String, CcdcPoint>();
		for(CcdcPoint point: points) {
			pointsMap.put(point.getuName()+"-"+point.gettName(), point);
		}
		
		for(CcdcUser user: users) {
			for(CcdcTask task: tasks) {
				String userName = user.getuName();
				String taskName = task.gettName();
				CcdcPoint point = pointsMap.get(userName + "-" + taskName);
				CcdcPointView pointView = new CcdcPointView();
				
				pointView.settDate(task.getCreatedDate());
				pointView.settDesc(task.gettDesc());
				pointView.settName(task.gettName());
				pointView.settType(task.gettType());
				pointView.setuName(user.getuName());
				
				if(point == null) {
					pointView.setScore(0.0f);
					pointView.setRemark("N/A");
				} else {
					pointView.setScore(point.getScore());
					pointView.setRemark(point.getRemark());
				}
			}
		}
		
		return rets;
	}

	public void updatePoints(List<CcdcPoint> points) {
		// TODO Auto-generated method stub
		for(CcdcPoint point:points) {
			int count = ccdcRepository.updatePoint(point);
		}
		
	}
}
