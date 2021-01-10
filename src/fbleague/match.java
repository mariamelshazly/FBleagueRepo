package fbleague;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class match {
	
	String matchName;
	String squadName1;
	String squadName2;
	Integer squad1Points;
	Integer squad2Points;
	boolean isActive = false;
	String fEmail = LoggingIn.getEmail();
	int squadreadLine;
	
	void createMatch(String leagueType) throws IOException
	{
		int squadEntryLine = 0;
        if(leagueType.equals("Private"))
        {
        	squadEntryLine = 6;
        }
        else if(leagueType.equals("Public"))
        {
        	squadEntryLine = 5;
        }
		int squadsLine = 1;
		Scanner scm = new Scanner(System.in);
		System.out.println("\nYou must first pick a league to create the match in.");
		System.out.println("\nAvailable Leagues that you have created: ");
		Scanner Linput = new Scanner(new File("database//leagues//" + fEmail + ".txt"));
		while (Linput.hasNextLine())
		{
		   System.out.println(Linput.nextLine());
		}
		System.out.println("Please enter the league you would like to create the match in: ");
		String mLeague = scm.nextLine();
		String squadsStr = Files.readAllLines(Paths.get("database//leagues//" + mLeague + ".txt")).get(squadsLine);
		Integer squadNum = Integer.parseInt(squadsStr);
		System.out.println("Please enter match name: ");
		matchName = scm.nextLine();
		squadName1 = null;
		squadName2 = null;
		squad1Points = 0;
		squad2Points = 0;
		FileWriter m1 = new FileWriter("database//matches//" + mLeague + "//" + matchName +".txt", true);
		m1.write(matchName);
        m1.write(System.getProperty( "line.separator" ));
        System.out.println("Available Squads in League: ");
        for(int i = squadEntryLine; i <= squadNum; i++)
        {
        	String lsqDis = Files.readAllLines(Paths.get("database//leagues//" + mLeague + ".txt")).get(i);
        	System.out.println("/n" + lsqDis);
        }
        System.out.println("\nPlease enter name of the first squad in the match: ");
        squadName1 = scm.nextLine();
        m1.write(squadName1);
        m1.write(System.getProperty( "line.separator" ));
        m1.write(squad1Points);
        m1.write(System.getProperty( "line.separator" ));
        System.out.println("\nPlease enter name of the second squad in the match: ");
        m1.write(squadName2);
        m1.write(System.getProperty( "line.separator" ));
        m1.write(squad2Points);
        m1.write(System.getProperty( "line.separator" ));
        m1.close();
	}
	void matchStart()
	{
		isActive = true;
	}
	void awardPoints()
	{
		if(!isActive)
		{
			System.out.println("Unable to award points, match is not active.");
		}
		else
		{
			
		}
	}
}