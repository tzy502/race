package model;

public class BattleLog {
	public int raceid;
	public String battleuserid1;
	public String battleuserid2;
	public String battleusername1;
	public String battleusername2;
	public int whowin;
	public int keyword;

	public int getKeyword() {
		return keyword;
	}
	public void setKeyword(int keyword) {
		this.keyword = keyword;
	}
	public int getRaceid() {
		return raceid;
	}
	public void setRaceid(int raceid) {
		this.raceid = raceid;
	}
	public String getBattleuserid1() {
		return battleuserid1;
	}
	public void setBattleuserid1(String battleuserid1) {
		this.battleuserid1 = battleuserid1;
	}
	public String getBattleuserid2() {
		return battleuserid2;
	}
	public void setBattleuserid2(String battleuserid2) {
		this.battleuserid2 = battleuserid2;
	}
	public String getBattleusername1() {
		return battleusername1;
	}
	public void setBattleusername1(String battleusername1) {
		this.battleusername1 = battleusername1;
	}
	public String getBattleusername2() {
		return battleusername2;
	}
	public void setBattleusername2(String battleusername2) {
		this.battleusername2 = battleusername2;
	}
	public int getWhowin() {
		return whowin;
	}
	public void setWhowin(int whowin) {
		this.whowin = whowin;
	}
	
}
