package fbleague;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files ;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
Authors:
Ahmed Medhat
Abdulrahman Ayman
Mariam ElShazly
 */
@SuppressWarnings("unused")
public class FBLeague {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
        SigningUp u1 = new SigningUp();
        LoggingIn u2 = new LoggingIn();
        int choice;
        Scanner chc = new Scanner(System.in);
        String userType;
        while(true)
        {
        	System.out.println("\nPlease enter what you want to do: \n");
        	System.out.println("0. DATABASE INITIALIZATION (!!!PLEASE SELECT THIS OPTION ON THE FIRST EXECUTION ON YOUR LOCAL MACHINE!!!) \n");
        	System.out.println("1. Sign Up \n");
        	System.out.println("2. Log in \n");
        	System.out.println("3. Log in as admin \n");
        	System.out.println("4. Exit \n");
        	System.out.println("Please input your choice by entering the corresponding number: ");
        	choice = chc.nextInt();
        	if(choice == 0)
        	{
        		Scanner initS = new Scanner(System.in);
        		int initChoice;
        		System.out.println("\nWARNING: This option is intended to be run ONLY ONCE on the first run on your local machine.");
        		System.out.println("\nThis option initializes the software's database on your local machine in order to run properly and without errors.");
        		System.out.println("\nThis option may cause unintended side effects if run more than once on the same local machine or while the database is already initialized.");
        		System.out.println("\nSide effects include but are not limited to partial or complete loss of user data, use at your own discretion.");
        		System.out.println("\nBegin initialization process (Y/N)? ");
        		System.out.println("\n1. Yes");
        		System.out.println("\n2. No");
        		initChoice = initS.nextInt();
        		if(initChoice == 1)
        		{
        			dbInit initMain = new dbInit();
        			initMain.init();
        			continue;
        		}
        		else if (initChoice == 2)
        		{
        			System.out.println("Returning to previous menu...");
        			continue;
        		}
        		
        	}
        	if(choice == 1)
        	{
        		u1.SignUp();
        		continue;
        	}
        	else if (choice == 2)
        	{
        		u2.LogIn();
        		userType = "Standard";
                String fEmail = LoggingIn.getEmail();
        		break;
        	}
        	else if (choice == 3)
        	{
        		adminClass admin1 = new adminClass();
        		admin1.adminLogin();
        		userType = "Admin";
        		break;
        	}
        	else if (choice == 4)
        	{
        		System.out.println("Program has been terminated successfully.");
        		System.exit(0);
        	}
        	else
        	{
        		System.out.println("Invalid Input! Please re-enter your choice.");
        		continue;
        	}
        }
        int choice1;
        Scanner chc1 = new Scanner(System.in);
        System.out.println("\nWelcome to Fantasy Premier League!");
        System.out.println("\nTo begin, please select a feature from the following:");
        while(true)
        {
        	if(userType.equals("Admin"))
        	{
        	System.out.println("\n1. Create Player");
        	System.out.println("\n2. Remove Player");
        	System.out.println("\n3. Display Players");
        	System.out.println("\n4. Create Squad");
        	System.out.println("\n5. Display Squad");
        	System.out.println("\n6. Create Public League");
        	System.out.println("\n7. Create League Match");
        	System.out.println("\n8. Exit");
        	}
        	else if(userType.equals("Standard"))
        	{
            	System.out.println("\n1. Display Players");
            	System.out.println("\n2. Create Squad");
            	System.out.println("\n3. Display Squad");
                System.out.println("\n4. Create Private League");
                System.out.println("\n5. Create League Match");
            	System.out.println("\n6. Exit");
        	}
        	choice1 = chc1.nextInt();
        	if(userType.equals("Standard"))
        	{
        		if(choice1 == 1)
        		{
        			choice1 = 3;
        		}
        		else if(choice1 == 2)
        		{
        			choice1 = 4;
        		}
        		else if(choice1 == 3)
        		{
        			choice1 = 5;
        		}
                else if(choice1 == 4)
        		{
        			choice1 = 6;
        		}
        		else if(choice1 == 5)
        		{
        			choice1 = 8;
        		}
        		else if(choice1 == 6)
        		{
        			choice1 = 7;
        		}
                        
        	}
        	else if(userType.equals("Admin"))
        	{
        		if(choice1 == 7)
        		{
        			choice1 = 8;
        		}
        		else if(choice == 8)
        		{
        			choice1 = 7;
        		}
        	}
        	if (choice1==1)
        	{
        		while(true) {
        	String Position = null;
        	int phc;
        	Scanner ps = new Scanner(System.in);
        	System.out.println("\nAvailable player types: ");
        	System.out.println("\n1. Goalkeeper");
        	System.out.println("\n2. Forward Player");
        	System.out.println("\n3. Defender");
        	System.out.println("\n4. Midfielder");
        	System.out.println("\n5. If you wish to return to the previous menu, select this option instead.");
        	System.out.println("\nPlease input new player type: ");
        	phc = ps.nextInt();
        	if(phc == 1)
        	{
        		Position = "Goalkeeper";
        	}
        	else if (phc == 2)
        	{
        		Position = "Forward Player";
        	}
        	else if (phc == 3)
        	{
        		Position = "Defender";
        	}
        	else if (phc == 4)
        		Position = "Midfielder";
        	else if (phc == 5)
        		break;
        	else
        	{
        		System.out.println("Invalid selection, Please retry.");
        	}
        	if(Position.equals("Goalkeeper"))
        	{
        	playerFactory f1 = new playerFactory();
        	f1.makePlayer(Position);
        	Goalkeeper p1 = new Goalkeeper();
        	p1.createPlayer();
        	continue;
        	}
        	else if(Position.equals("Forward Player"))
        	{
        	playerFactory f1 = new playerFactory();
        	f1.makePlayer(Position);
        	forwardPlayer p1 = new forwardPlayer();
        	p1.createPlayer();
        	continue;
        	}
        	else if(Position.equals("Defender"))
        	{
        	playerFactory f1 = new playerFactory();
        	f1.makePlayer(Position);
        	defender p1 = new defender();
        	p1.createPlayer();
        	continue;
        	}
        	else if(Position.equals("Midfielder"))
        	{
        	playerFactory f1 = new playerFactory();
        	f1.makePlayer(Position);
        	midfielder p1 = new midfielder();
        	p1.createPlayer();
        	continue;
        	}
        }
        	}
        	else if (choice1 == 2)
        	{
        		while(true)
        		{
        		int rhc;
        		String rpos;
        		Scanner rs = new Scanner(System.in);
        		System.out.println("\nPlease enter the type of player you wish to remove from this list: ");
        		System.out.println("\n1. Goalkeeper");
            	System.out.println("\n2. Forward Player");
            	System.out.println("\n3. Defender");
            	System.out.println("\n4. Midfielder");
            	System.out.println("\n5. If you wish to return to the previous menu, select this option instead.");
            	rhc = rs.nextInt();
            	if(rhc == 1)
            	{
            		System.out.println("\nListing all Goalkeepers: ");
            		Scanner input1 = new Scanner(System.in);
            		Scanner input = new Scanner(new File("database//players//" + "goalkeepers//" + "goalkeepers.txt"));
            		while (input.hasNextLine())
            		{
            		   System.out.println(input.nextLine());
            		}
            		System.out.println("\nPlease enter the name of the goalkeeper you wish to delete: ");
            		String delP = input1.nextLine();
            		Goalkeeper p2 = new Goalkeeper();
            		p2.deletePlayer(delP);
            		continue;
            		
            	}
            	else if (rhc == 2)
            	{
            		System.out.println("\nListing all Forward Players: ");
            		Scanner input1 = new Scanner(System.in);
            		Scanner input = new Scanner(new File("database//players//" + "forwardplayers//" + "forwardplayers.txt"));
            		while (input.hasNextLine())
            		{
            		   System.out.println(input.nextLine());
            		}
            		System.out.println("\nPlease enter the name of the forward player you wish to delete: ");
            		String delP = input1.nextLine();
            		forwardPlayer p2 = new forwardPlayer();
            		p2.deletePlayer(delP);
            		continue;
            	}
            	else if (rhc == 3)
            	{
            		System.out.println("\nListing all Defenders: ");
            		Scanner input1 = new Scanner(System.in);
            		Scanner input = new Scanner(new File("database//players//" + "defenders//" + "defenders.txt"));
            		while (input.hasNextLine())
            		{
            		   System.out.println(input.nextLine());
            		}
            		System.out.println("\nPlease enter the name of the defender you wish to delete: ");
            		String delP = input1.nextLine();
            		defender p2 = new defender();
            		p2.deletePlayer(delP);
            		continue;
            	}
            	else if (rhc == 4)
            	{
            		System.out.println("\nListing all Midfielders: ");
            		Scanner input1 = new Scanner(System.in);
            		Scanner input = new Scanner(new File("database//players//" + "midfielders//" + "midfielders.txt"));
            		while (input.hasNextLine())
            		{
            		   System.out.println(input.nextLine());
            		}
            		System.out.println("\nPlease enter the name of the midfielder you wish to delete: ");
            		String delP = input1.nextLine();
            		midfielder p2 = new midfielder();
            		p2.deletePlayer(delP);
            		continue;
            	}
            	else if (rhc == 5)
            		break;
            	else
            	{
            		System.out.println("Invalid Selection. Please retry.");
            		continue;
            	}
        		}
            	
        		
        	}
        	else if(choice1 == 3)
        	{
        		while(true)
        		{
        		int rdc;
        		Scanner rs = new Scanner(System.in);
        		System.out.println("\nPlease enter the type of player you wish to display from this list: ");
        		System.out.println("\n1. Goalkeeper");
            	System.out.println("\n2. Forward Player");
            	System.out.println("\n3. Defender");
            	System.out.println("\n4. Midfielder");
            	System.out.println("\n5. If you wish to return to the previous menu, select this option instead.");
            	rdc = rs.nextInt();
            	if(rdc == 1)
            	{
            		System.out.println("\nListing all Goalkeepers: ");
            		String dis;
            		Scanner input2 = new Scanner(System.in);
            		Goalkeeper g3 = new Goalkeeper();
            		g3.displayPlayers();
            		System.out.println("\nEnter player name to display their details: ");
            		dis = input2.nextLine();
            		g3.displayDetails(dis);
            		continue;
            	}
            	else if (rdc == 2)
            	{
            		System.out.println("\nListing all Forward Players: ");
            		String dis;
            		Scanner input2 = new Scanner(System.in);
            		forwardPlayer g3 = new forwardPlayer();
            		g3.displayPlayers();
            		System.out.println("\nEnter player name to display their details: ");
            		dis = input2.nextLine();
            		g3.displayDetails(dis);
            		continue;
            	}
            	else if (rdc == 3)
            	{
            		System.out.println("\nListing all Defenders: ");
            		String dis;
            		Scanner input2 = new Scanner(System.in);
            		defender g3 = new defender();
            		g3.displayPlayers();
            		System.out.println("\nEnter player name to display their details: ");
            		dis = input2.nextLine();
            		g3.displayDetails(dis);
            		continue;
            	}
            	else if(rdc == 4)
            	{
            		System.out.println("\nListing all Midfielders: ");
            		String dis;
            		Scanner input2 = new Scanner(System.in);
            		midfielder g3 = new midfielder();
            		g3.displayPlayers();
            		System.out.println("\nEnter player name to display their details: ");
            		dis = input2.nextLine();
            		g3.displayDetails(dis);
            		continue;
            	}
            	else if(rdc == 5)
            	{
            		break;
            	}
        		}
        	}
                else if(choice1 == 4)
                {
                	Squad s1 = new Squad();
                    s1.createSquad();
                }
                else if(choice1 == 5)
                {
                	Squad s2 = new Squad();
                	s2.displaySquad();
                }
                else if(choice1 == 7)
                {
                	System.out.println("\nProgram has been terminated successfully.");
            		System.exit(0);
                }
                else if (choice1==6)
                {
                	if(userType.equals("Standard"))
                	{
                		privateLeague privLeauge = new privateLeague();
                		privLeauge.createLeague();
                	}
                	else if(userType.equals("Admin"))
                	{
                		publicLeague pubLeague = new publicLeague();
                		pubLeague.createLeague();
                	}
                }
                else if(choice1==8)
                {
                	String leagueType;
                	if(userType.equals("Standard"))
                	{
                		leagueType = "Private";
                		match privMatch = new match();
                		privMatch.createMatch(leagueType);
                	}
                	else if(userType.equals("Admin"))
                	{
                		leagueType = "Public";
                		match pubMatch = new match();
                		pubMatch.createMatch(leagueType);
                	}
                }
               // System.out.println("Display squad ?");
            	else
            	{
            		System.out.println("\nInvalid Selection. Please retry.");
            		continue;
            	}
            	
        	}
    }  
    }