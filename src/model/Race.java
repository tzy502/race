package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Race implements Serializable{
	public int raceid;
	public String racename;
	public int racetype;
	//1单败 2双败 3瑞士轮 4kof 5征服
	public int racestate;
	//1没开始 2开始 3结束 4取消
	public String raceaddress;
	public String introduction;
	public Timestamp  raceopendate;
	
	public Timestamp getRaceopendate() {
		return raceopendate;
	}
	public void setRaceopendate(Timestamp raceopendate) {
		this.raceopendate = raceopendate;
	}
	public String getRaceaddress() {
		return raceaddress;
	}
	public void setRaceaddress(String raceaddress) {
		this.raceaddress = raceaddress;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getRaceid() {
		return raceid;
	}
	public void setRaceid(int raceid) {
		this.raceid = raceid;
	}
	public String getRacename() {
		return racename;
	}
	public void setRacename(String racename) {
		this.racename = racename;
	}
	public int getRacetype() {
		return racetype;
	}
	public void setRacetype(int racetype) {
		this.racetype = racetype;
	}
	public int getRacestate() {
		return racestate;
	}
	public void setRacestate(int racestate) {
		this.racestate = racestate;
	}
	
}
