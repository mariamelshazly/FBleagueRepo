/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbleague;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author 123
 */
public class Squad {
    
    String fEmail = LoggingIn.getEmail();
    
    String Sname,Gname,Dname,Mname,Fname;
    int cost;
    
    void createSquad() throws IOException{
        Integer costLine=4;
        while(true){
        	cost = 0;
            
         Scanner in = new Scanner (System.in);
         System.out.println("Please enter name of squad:\n");
         Sname = in.nextLine();
         FileWriter w2 = new FileWriter("database//squads//"  + Sname + ".txt", true);
         w2.write(Sname);
        w2.write(System.getProperty( "line.separator" ));
        System.out.println("Please enter name of players:\n");
        System.out.println("Enter 2 goalkeepers:\n ");
        w2.write("Goalkeepers: ");
        w2.write(System.getProperty( "line.separator" ));
        int i=0;
        while( i<2){
        Gname = in.nextLine();
        w2.write(Gname);
        w2.write(System.getProperty( "line.separator" ));
        //cost+=
        String pcost = Files.readAllLines(Paths.get("database//players//" + "goalkeepers//"+ Gname +".txt")).get(costLine);
        int pcost2=Integer.parseInt(pcost);
        cost+=pcost2;
          i++;
    }
        System.out.println("Enter 5 defenders:\n ");
        w2.write("Defenders: ");
        w2.write(System.getProperty( "line.separator" ));
        int j=0;
        while( j<5){
        Dname = in.nextLine();
        w2.write(Dname);
        w2.write(System.getProperty( "line.separator" ));
        String pcost = Files.readAllLines(Paths.get("database//players//" + "defenders//"+ Dname +".txt")).get(costLine);
        int pcost2=Integer.parseInt(pcost);
        cost+=pcost2;
        j++;
    }
         System.out.println("Enter 5 midfielders:\n ");
         w2.write("Midfielders: ");
         w2.write(System.getProperty( "line.separator" ));
        int k=0;
        while( k<5){
        Mname = in.nextLine();
         w2.write(Mname);
         w2.write(System.getProperty( "line.separator" ));
         String pcost = Files.readAllLines(Paths.get("database//players//" + "midfielders//"+ Mname +".txt")).get(costLine);
        int pcost2=Integer.parseInt(pcost);
        cost+=pcost2;
        k++;
    }
         System.out.println("Enter 3 forward fielders:\n ");
          w2.write("Forward Players: ");
          w2.write(System.getProperty( "line.separator" ));
        int m=0;
        while( m<3){
        Fname = in.nextLine();
         w2.write(Fname);
         w2.write(System.getProperty( "line.separator" ));
         String pcost = Files.readAllLines(Paths.get("database//players//" + "forwardplayers//"+ Fname +".txt")).get(costLine);
        int pcost2=Integer.parseInt(pcost);
        cost+=pcost2;
        m++;
    }
        if(cost <= 100000000)
        {
        	System.out.println("\nSquad " + Sname + " has been created successfully.");
        	w2.write("Cost: " + cost);
            w2.write(System.getProperty( "line.separator" ));
        w2.close();
        FileWriter w3 = new FileWriter("database//squads//" + fEmail + "//" + "squads.txt", true);
        w3.write(Sname);
        w3.write(System.getProperty( "line.separator" ));
        w3.close();
        break;
        }
        else if(cost > 100000000)
        {
            System.out.println("\nSquad cost should not exceed 100 million dollars!\n ");
            System.out.println("Please re-enter squad player names such that total cost does not exceed $100 Million.");
        	continue;
        }
        else
        {
        	System.out.println("Fatal Error!");
        System.exit(0);
        }
        }
    }
    
    void displaySquad() throws FileNotFoundException
	{
    	
    	System.out.println("\nCreated Squads: ");
    	Scanner sqd = new Scanner(System.in);
    	Scanner input4 = new Scanner(new File("database//squads//" + fEmail +"squads.txt"));
    	while (input4.hasNextLine())
		{
		   System.out.println(input4.nextLine());
		}
    	System.out.println("Please enter name of the squad you want to display: ");
    	String squadName = sqd.nextLine();
        Scanner input3 = new Scanner(new File("database//squads//" + squadName +".txt"));
		while (input3.hasNextLine())
		{
		   System.out.println(input3.nextLine());
		}
	}
}