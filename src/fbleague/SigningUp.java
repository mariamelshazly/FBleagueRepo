/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbleague;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Ahmed Medhat
 * Abdulrahman Ayman
 * Mariam ElShazly
 */
public class SigningUp extends User {
	
	String pass2;
	
     void SignUp() throws IOException{
        Scanner in = new Scanner (System.in);
        System.out.println("Please enter details:\n");
        System.out.println("Username: ");
        name = in.nextLine ();
        System.out.println("Email: ");
        email = in.nextLine ();
        System.out.println("Enter your favorite league team: ");
        favplt = in.nextLine ();    
        System.out.println("Password: ");
        pass = in.nextLine ();
        System.out.println("Re-enter password: ");
        pass2=in.nextLine ();
        int i=0;
        while(i<=3) {
        if(pass.equals(pass2)){
             System.out.println("Sign Up successful\n");
             
             try {
        FileWriter w1 = new FileWriter("database//users//" + email +".txt", true);
        w1.write(email);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(pass);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(name);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(favplt);
        w1.write(System.getProperty( "line.separator" ));
        w1.close();
        
        }
              catch (Exception ae) {
      System.out.println("An error occurred.");
      System.out.println(ae);
    }
        Path path = Paths.get("database//players//" + email + "//");
        Path path2 = Paths.get("database//players//" + email + "//goalkeepers");
        Path path3 = Paths.get("database//players//" + email + "//forwardplayers");
        Path path4 = Paths.get("database//players//" + email + "//defenders");
        Path path5 = Paths.get("database//players//" + email + "//midfielders");
        Files.createDirectories(path);
        Files.createDirectories(path2);
        Files.createDirectories(path3);
        Files.createDirectories(path4);
        Files.createDirectories(path5);
        break;
        }
        else
        {
            System.out.println("Passwords do not match! please re-enter password:\n");
            System.out.println("Password:\n");
            pass = in.nextLine ();
            System.out.println("Re-enter password:\n");
            pass2=in.nextLine ();
            i++;
            continue;
           
        }
        }

        
       
    
    }
    
}
