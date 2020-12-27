package fbleague;

import java.io.IOException;
import java.io.*; 

public abstract class Player {
	
	String pname;
	String nationality;
	String position;
	String club;
	String owner;
	Integer cost;
	
	void createPlayer() throws IOException {}
	void deletePlayer() throws FileNotFoundException {}
	void displayPlayers() throws FileNotFoundException {}
	void displayDetails() throws IOException {}

}
