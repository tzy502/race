package model;

public class BattleTable {
	public String userid;
	public int key;
	public String username;
	public int raceid;
	public int win;
	public int lose;
	public String battlenum;
	public int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRaceid() {
		return raceid;
	}
	public void setRaceid(int raceid) {
		this.raceid = raceid;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}

	public String getBattlenum() {
		return battlenum;
	}
	public void setBattlenum(String battlenum) {
		this.battlenum = battlenum;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
}
