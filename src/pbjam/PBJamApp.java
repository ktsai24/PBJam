package pbjam;

import menu.MenuHandler;
import abstracts.Person;
import pbjam.beans.Player;
import enums.Sex;
import logic.PBJamFacade;

public class PBJamApp {
    public static void main(String[] args) {
    	PBJamFacade tempFacade = new PBJamFacade(new Player());
    	Player loaded = tempFacade.loadPlayerData();
    	Player player = (loaded != null) ? loaded : new Player("Kevin Tsai", "kevin@email.com", "Potomac, MD",
                "301-233-1241", Sex.MALE, 4.1, 4.2);
    	MenuHandler menu = new MenuHandler(player);
    	menu.displayMenu();
    }
}