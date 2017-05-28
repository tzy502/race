package model;

public class Race {
	public int raceid;
	public String racename;
	public int racetype;
	//1 单淘 2瑞士轮3双败（考虑）
	public int racestate;
	//1开始前 2一开始3结束
	public String introduction;
	
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
