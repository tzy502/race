import java.util.ArrayList;
import java.util.List;

import DAO.BattleTableDAO;
import DAO.RaceDAO;
import DAO.UserDAO;
import controller.RaceControl;
import model.BattleTable;
import model.Race;
import model.User;

public class Start {

	public static void main(String[] args) {
		BattleTable luckyplayer=new BattleTable();
		BattleTableDAO btd=new BattleTableDAO();
		luckyplayer=btd.search(1, "1");
		luckyplayer.setWin(666);
		btd.modify(luckyplayer);
	}
	

}
