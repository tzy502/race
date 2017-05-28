package model;

public class BattleManager {
	public String userid;
	public int raceid;
	public boolean isboss;
	public int key;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getRaceid() {
		return raceid;
	}
	public void setRaceid(int raceid) {
		this.raceid = raceid;
	}
	public boolean isIsboss() {
		return isboss;
	}
	public void setIsboss(boolean isboss) {
		this.isboss = isboss;
	}
	
}
