package com.itccloud.mwccdc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CcdcRepository {
	

	@Select("SELECT * FROM t_user where status='A'")
	@Results(id="UserDataResult", value={
		@Result(column="user_name", property="uName"),
		@Result(column="status", property="status"), 
		@Result(column="created_date", property="createdDate")}
	)
	public List<CcdcUser> findUsers();
		
	@Select("SELECT * FROM t_task")
	@Results(id="TaskDataResult", value={
		@Result(column="task_name", property="tName"),
		@Result(column="task_type", property="tType"),
		@Result(column="task_desc", property="tDesc"),
		@Result(column="created_date", property="createdDate")
	})
	public List<CcdcTask> findTasks();
	
	@Select("SELECT * FROM t_point")
		@Results(id="PointDataResult", value={
		@Result(column="user_name", property="uName"),
		@Result(column="task_name", property="tName"),
		@Result(column="score", property="score"),
		@Result(column="remark", property="remark"),
		@Result(column="created_date", property="createdDate")
	})
	public List<CcdcPoint> findPoints();
	
	@Update("UPDATE t_point set score=#{score}, remark=#{remark}, created_date=now()"  
			+ "WHERE user_name=#{uName} and task_name=#{tName}")
	public int updatePoint(CcdcPoint point);
}


