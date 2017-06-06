package servlet;

import java.util.ArrayList;
import java.util.List;

import DAO.BattleManagerDAO;
import DAO.BattleTableDAO;
import DAO.RaceDAO;
import model.BattleTable;
import model.Race;

public class Battle {
	RaceDAO rd=new RaceDAO();
	BattleManagerDAO bmd=new BattleManagerDAO();
	BattleTableDAO btd=new BattleTableDAO();
	public List<Race> oneover(int raceid){
		List<Race> result =new ArrayList<Race>();
		result=rd.loadsigner(raceid);
		return result;
	}
}
