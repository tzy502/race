package model;

public class Race {
	public int raceid;
	public String racename;
	public int racetype;
	//1 ���� 2��ʿ��3˫�ܣ����ǣ�
	public int racestate;
	//1��ʼǰ 2һ��ʼ3����
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
