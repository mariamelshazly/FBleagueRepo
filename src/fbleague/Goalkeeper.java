package fbleague;

import java.util.Scanner;
import java.io.*; 
import java.nio.file.Files; 
import java.nio.file.*;

public class Goalkeeper extends Player {
	
    String fEmail = LoggingIn.getEmail();
	
	void createPlayer() throws IOException{
		position = "Goalkeeper";
        Scanner in = new Scanner (System.in);
        System.out.println("Please enter new goalkeeper details:\n");
        System.out.println("Player name: ");
        pname = in.nextLine();
        System.out.println("Nationality: ");
        nationality = in.nextLine();
        System.out.println("Club: ");
        club = in.nextLine();    
        System.out.println("Player cost: ");
        cost = in.nextInt();
        String costString = cost.toString();
        points = 0;
             
             try {// D://Eclipse/FBleague/"pname".txt
        FileWriter w2 = new FileWriter("database//players//" + "goalkeepers//" + pname +".txt", true);
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
        w2.write(points);
        w2.close();
        }
              catch (Exception ae) {
      System.out.println("An error occurred.");
      System.out.println(ae);
      ae.printStackTrace();
    }
             FileWriter w3 = new FileWriter("database//players//" + "goalkeepers//" + "goalkeepers.txt", true);
             w3.write(pname);
             w3.write(System.getProperty( "line.separator" ));
             w3.close();
             System.out.println("New Goalkeeper " + pname + " created successfully.");
             
             
        //void updatePlayer(String player) throws FileNotFoundException{};
}
	void deletePlayer(String player) throws FileNotFoundException
	{
		File delF = new File("database//players//" + "goalkeepers//" + player + ".txt");
		delF.delete();
		File file3 = new File("database//players//" + "goalkeepers//goalkeepers.txt");
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
		System.out.println("Goalkeeper " + player + " removed successfully.");
	}
	void displayPlayers() throws FileNotFoundException
	{
		Scanner input3 = new Scanner(new File("database//players//" + "goalkeepers//" + "goalkeepers.txt"));
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
		int pointsLine = 5;
		String disName = Files.readAllLines(Paths.get("database//players//" + "goalkeepers//" + disPlayer + ".txt")).get(nameLine);
		String disNat = Files.readAllLines(Paths.get("database//players//" + "goalkeepers//" + disPlayer + ".txt")).get(natLine);
		String disPos = Files.readAllLines(Paths.get("database//players//" + "goalkeepers//" + disPlayer + ".txt")).get(posLine);
		String disClub = Files.readAllLines(Paths.get("database//players//" + "goalkeepers//" + disPlayer + ".txt")).get(clubLine);
		String disCost = Files.readAllLines(Paths.get("database//players//" + "goalkeepers//" + disPlayer + ".txt")).get(costLine);
		String disPoints = Files.readAllLines(Paths.get("database//players//" + "goalkeepers//" + disPlayer + ".txt")).get(pointsLine);
		System.out.println("Name: " + disName);
		System.out.println("Nationality: " + disNat);
		System.out.println("Position: " + disPos);
		System.out.println("Club: " + disClub);
		System.out.println("Cost: " + disCost);
		System.out.println("Points: " + disPoints);
	}
}
