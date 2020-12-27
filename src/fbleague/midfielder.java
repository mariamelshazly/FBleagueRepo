package fbleague;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class midfielder extends Player {
    String fEmail = LoggingIn.getEmail();
	void createPlayer() throws IOException{
		position = "Midfielder";
        Scanner in = new Scanner (System.in);
        System.out.println("Please enter new midfielder details:\n");
        System.out.println("Player name: ");
        pname = in.nextLine();
        System.out.println("Nationality: ");
        nationality = in.nextLine();
        System.out.println("Club: ");
        club = in.nextLine();    
        System.out.println("Player cost: ");
        cost = in.nextInt();
        String costString = cost.toString();
             
             try {
        FileWriter w2 = new FileWriter("database//players//" + fEmail + "//midfielders//" + pname +".txt", true);
        w2.write(pname);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(nationality);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(position);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(club);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(costString);
        w2.write(System.getProperty( "line.separator" ));
        w2.close();
        
        }
              catch (Exception ae) {
      System.out.println("An error occurred.");
      System.out.println(ae);
    }
             FileWriter w3 = new FileWriter("database//players//" + fEmail + "//midfielders//" + "midfielders.txt", true);
             w3.write(pname);
             w3.write(System.getProperty( "line.separator" ));
             w3.close();
             System.out.println("New Midfielder " + pname + " created successfully.");


}
	void deletePlayer(String player) throws FileNotFoundException
	{
		File delF = new File("database//players//" + fEmail + "//midfielders//" + player + ".txt");
		delF.delete();
		File file3 = new File("database//players//" + fEmail + "//midfielders//midfielders.txt");
		 StringBuilder sb = new StringBuilder();
		    try (Scanner sc = new Scanner(file3)) {
		        String currentLine;
		        while(sc.hasNext()){
		            currentLine = sc.nextLine();
		            if(currentLine.equals(player)){
		                continue;
		            }
		            sb.append(currentLine).append("\n");
		        }
		    }
		    PrintWriter pw = new PrintWriter(file3);
		    pw.close();

		    BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(file3, true));
				writer.append(sb.toString());
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("Midfielder " + player + " removed successfully.");
	}
	void displayPlayers() throws FileNotFoundException
	{
		Scanner input3 = new Scanner(new File("database//players//" + fEmail + "//midfielders//" + "midfielders.txt"));
		while (input3.hasNextLine())
		{
		   System.out.println(input3.nextLine());
		}
	}
	void displayDetails(String disPlayer) throws IOException
	{
		int nameLine = 0;
		int natLine = 1;
		int posLine = 2;
		int clubLine = 3;
		int costLine = 4;
		String disName = Files.readAllLines(Paths.get("database//players//" + fEmail + "//midfielders//" + disPlayer + ".txt")).get(nameLine);
		String disNat = Files.readAllLines(Paths.get("database//players//" + fEmail + "//midfielders//" + disPlayer + ".txt")).get(natLine);
		String disPos = Files.readAllLines(Paths.get("database//players//" + fEmail + "//midfielders//" + disPlayer + ".txt")).get(posLine);
		String disClub = Files.readAllLines(Paths.get("database//players//" + fEmail + "//midfielders//" + disPlayer + ".txt")).get(clubLine);
		String disCost = Files.readAllLines(Paths.get("database//players//" + fEmail + "//midfielders//" + disPlayer + ".txt")).get(costLine);
		System.out.println("Name: " + disName);
		System.out.println("Nationality: " + disNat);
		System.out.println("Position: " + disPos);
		System.out.println("Club: " + disClub);
		System.out.println("Cost: " + disCost);		
	}
}
