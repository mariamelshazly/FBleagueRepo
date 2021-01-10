package fbleague;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class league {
	
	String leagueName;
	Integer leagueSquads;
	Integer leagueMatches;
	Integer leagueSquadsEXT;
	
	void createLeague() throws IOException {}
	void displayLeague() throws IOException {}
	void deleteLeague() {}

}
