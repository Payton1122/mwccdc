package com.itccloud.mwccdc.mapper.project;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.itccloud.mwccdc.mapper.project.projectObj.*;


@Mapper
public interface PreferenceRepository {

	
	@Select("SELECT * FROM FAN_PREF_DATA.FAN ORDER BY FAN_ID")
	@Results(id="fan", value={
		@Result(column="FAN_ID", property="fanId"),
		@Result(column="FIRST_NAME", property="firstName"), 
		@Result(column="LAST_NAME", property="lastName"),
		@Result(column="EMAIL", property="email"),
		@Result(column="PHONE", property="phone"),
		@Result(column="FIRST_OCCUPATION", property="firstOccupation"),
		@Result(column="PREFERRED_STAND", property="preferredStand"),
		@Result(column="RESERVATION_TIME", property="reservationTime")}
	)
	public List<Fan> findFan();
	
		
	@Select("SELECT * FROM FAN_PREF_DATA.RESERVED_SEATS")
	@Results(id="reservedSeats", value={
		@Result(column="SEAT_NUMBER", property="seatNumber"),
		@Result(column="STAND_POSITION", property="standPosition")
	})
	public List<ReservedSeats> findReservedSeats();
	
	
	@Select("SELECT * FROM FAN_PREF_DATA.REWARD ORDER BY REWARD_ID")
	@Results(id="reward", value={
		@Result(column="REWARD_ID", property="rewardId"),
		@Result(column="FAN_ID", property="fandId"),
		@Result(column="STAND_POSITION", property="standPosition"),
		@Result(column="SEAT_NUMBER", property="seatNumber")
	})
	public List<Reward> findReward();
	
	
	@Select("SELECT * FROM FAN_PREF_DATA.STAND ORDER BY STAND_POSITION")
	@Results(id="stand", value={
		@Result(column="STAND_POSITION", property="standPosition"),
		@Result(column="AVAILABLE_SEATS", property="availableSeats"),
		@Result(column="PREFERRED_SEAT", property="preferredSeat"),
		@Result(column="DISCOUNT_PRICE_PER_TICKET", property="discountPPTicket"),
		@Result(column="ESTIMATED_TOTAL_EARNINGS", property="estTotalEarnings")
	})
	public List<Stand> findStand();
	
	@Insert("INSERT INTO FAN_PREF_DATA.FAN (FIRST_NAME, LAST_NAME,"
			+ " EMAIL, PHONE, FIRST_OCCUPATION, PREFERRED_STAND, RESERVATION_TIME)"
			+ "VALUES (#{firstName}, #{lastName}, #{email}, #{phone}, "
			+ "#{firstOccupation}, #{preferredStand}, #{reservationTime})")
	public void insertFan(Fan fan);
	
	@Delete("TRUNCATE TABLE FAN_PREF_DATA.FAN CASCADE")
	public void truncFan();
	
	@Delete("TRUNCATE TABLE FAN_PREF_DATA.REWARD")
	public void truncReward();

	@Select("SELECT \n"
			+ "	F.FAN_ID, \n"
			+ "	F.FIRST_NAME,\n"
			+ "	F.LAST_NAME, \n"
			+ "	F.EMAIL,\n"
			+ "	F.PHONE,\n"
			+ "	R.STAND_POSITION,\n"
			+ "	F.RESERVATION_TIME,\n"
			+ "	R.SEAT_NUMBER\n"
			+ "FROM FAN_PREF_DATA.FAN F\n"
			+ "JOIN FAN_PREF_DATA.REWARD R\n"
			+ "	ON F.FAN_ID = R.FAN_ID \n"
			+ "ORDER BY R.STAND_POSITION")
	@Results(id="RewardedFan", value={
		@Result(column="FAN_ID", property="fanId"),
		@Result(column="FIRST_NAME", property="firstName"), 
		@Result(column="LAST_NAME", property="lastName"),
		@Result(column="EMAIL", property="email"),
		@Result(column="PHONE", property="phone"),
		@Result(column="STAND_POSITION", property="standPosition"),
		@Result(column="SEAT_NUMBER", property="seatNumber")}
	)
	public List<RewardedFan> findRewardedFan();

	
	@Insert("INSERT INTO FAN_PREF_DATA.REWARD (FAN_ID, STAND_POSITION,"
			+ " SEAT_NUMBER)"
			+ "VALUES (#{fanId}, #{standPosition}, #{seatNumber})")
	public void insertRewards(Reward reward);
	
	@Select("SELECT * FROM FAN_PREF_DATA.REWARDED_FANS ORDER BY RESERVATION_TIME DESC")
	@Results(id="RewardedFansView", value={
		@Result(column="FAN_ID", property="fanId"),
		@Result(column="FIRST_NAME", property="firstName"),
		@Result(column="LAST_NAME", property="lastName"),
		@Result(column="EMAIL", property="email"),
		@Result(column="STAND_POSITION", property="standPosition"),
		@Result(column="RESERVATION_TIME", property="reservationTime")
	})
	public List<RewardedFansView> findRewardedView();

}
