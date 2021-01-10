package fbleague;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class privateLeague extends league {
    
    String fEmail = LoggingIn.getEmail();
    String leaguePass = null;
	
	void createLeauge() throws IOException
	{
		//leagueSquadsEXT = 0;
		Scanner scl = new Scanner(System.in);
		Scanner scl2 = new Scanner(System.in);
		System.out.println("\nPlease enter league name: ");
		leagueName = scl.nextLine();
        leagueSquadsEXT = 0;
		while(true)
		{
		System.out.println("\nPlease enter number of participants in league: ");
		leagueSquads = scl.nextInt();
		if(leagueSquads%2!=0)
		{
			System.out.println("\nUnable to set number of participants to an odd number. Please retry.");
			continue;
		}
		else
		{
			break;
		}
		}
		System.out.println("\nPlease enter number of matches in league: ");
		leagueMatches = scl.nextInt();
		System.out.println("\nPlease enter league password: ");
		leaguePass = scl2.nextLine();
		FileWriter lg = new FileWriter("database//leagues//" + leagueName + ".txt");
		lg.write(leagueName);
        lg.write(System.getProperty( "line.separator" ));
        lg.write(leagueSquads.toString());
        lg.write(System.getProperty( "line.separator" ));
        lg.write(leagueMatches.toString());
        lg.write(System.getProperty( "line.separator" ));
        lg.write(leagueSquadsEXT.toString());
        lg.write(System.getProperty( "line.separator" ));
        lg.write(leaguePass);
        lg.write(System.getProperty( "line.separator" ));
        lg.write("Squads: ");
        lg.write(System.getProperty( "line.separator" ));
        lg.close();
        FileWriter lp = new FileWriter("database//leagues//" + "leagues.txt", true);
        lp.write(leagueName + " [Private]");
        lp.write(System.getProperty( "line.separator" ));
        lp.close();
        FileWriter ul = new FileWriter("database//leagues//" + fEmail +  ".txt", true);
        ul.write(leagueName);
        ul.write(System.getProperty( "line.separator" ));
        ul.close();
        System.out.println("League " + leagueName + " created successfully.");
	}
	void enterLeaguePriv(String leagueName) throws IOException
	{
		while(true)
		{
		int squadLimitLine = 3;
		int squadsLine = 1;
		String squadLimit = Files.readAllLines(Paths.get("database//leagues//" + leagueName + ".txt")).get(squadLimitLine);
		String squadNo = Files.readAllLines(Paths.get("database//leagues//" + leagueName + ".txt")).get(squadsLine);
		Integer squadLimitNo = Integer.parseInt(squadLimit);
		Integer squadsNo = Integer.parseInt(squadNo);
		if(squadLimitNo == squadsNo)
		{
			System.out.println("\nThis private league is full, unable to join.");
			break;
		}
		else
		{
			while(true)
			{
			int passLine = 4;
			String mPass = Files.readAllLines(Paths.get("database//leagues//" + leagueName + ".txt")).get(passLine);
			Scanner lpass = new Scanner(System.in);
			System.out.println("\nPlease enter private league password: ");
			String passEnt = lpass.nextLine();
			if(passEnt.equals(mPass))
			{
				System.out.println("\nLeague password accepted. Access Granted.");
				break;
			}
			else
			{
				System.out.println("\nLeague password incorrect. Access Denied. Please try again. ");
				continue;
			}
		}
		FileWriter le = new FileWriter("database//leagues//" + leagueName + ".txt");
		Scanner sel = new Scanner(System.in);
		System.out.println("\nAvailable squads: ");
		Scanner sInput = new Scanner(new File("database//squads//" + fEmail + "//squads.txt"));
		while (sInput.hasNextLine())
		{
		   System.out.println(sInput.nextLine());
		}
		System.out.println("\nPlease enter the name of the squad you would like to use to enter: ");
		String entrySquad = sel.nextLine();
		le.write(entrySquad);
        le.write(System.getProperty( "line.separator" ));
        le.close();
        String leagueSquadsCOMP = leagueSquadsEXT.toString();
        Integer leagueSquadsP = leagueSquadsEXT + 1;
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("database//leagues//" + leagueName + ".txt")));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(leagueSquadsCOMP)) 
            {
                fileContent.set(i, leagueSquadsP.toString());
                break;
            }
        }
	}
}
}
	void displayLeague() throws IOException
	{
		int lNameLine = 0;
		int lmaxSquads = 1;
		int lMatches = 2;
		int lextSquads = 3;
		int squadEntryLine = 6;
		Scanner dlg = new Scanner(System.in);
		System.out.println("\nAvailable created leagues: ");
		Scanner Linput = new Scanner(new File("database//leagues//" + "leagues.txt"));
		while (Linput.hasNextLine())
		{
		   System.out.println(Linput.nextLine());
		}
		System.out.println("Please type the name of the league you wish to view the details of: ");
		String disLg = dlg.nextLine();
		String dislName = Files.readAllLines(Paths.get("database//leagues//" + disLg + ".txt")).get(lNameLine);
		String dislmSquads = Files.readAllLines(Paths.get("database//leagues//" + disLg + ".txt")).get(lmaxSquads);
		String dislMatches = Files.readAllLines(Paths.get("database//leagues//" + disLg + ".txt")).get(lMatches);
		String dislextSquads = Files.readAllLines(Paths.get("database//leagues//" + disLg + ".txt")).get(lextSquads);
		System.out.println("\nLeague Name: " + dislName);
		System.out.println("\nLeague Squad Limit: " + dislmSquads);
		System.out.println("\nLeague Total Matches: " + dislMatches);
		System.out.println("\nLeague Existing Squads: " + dislextSquads);
		System.out.println("\nLeague Participant Squads: ");
		Integer squadNum = Integer.parseInt(dislmSquads);
		for(int i = squadEntryLine; i <= squadNum; i++)
        {
        	String lsqDis = Files.readAllLines(Paths.get("database//leagues//" + disLg + ".txt")).get(i);
        	System.out.println("\n" + lsqDis);
        }
		
	}
        void fun(){
            System.out.println("hi..");
        }
}