/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbleague;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        FileWriter w1 = new FileWriter(email + ".txt", true);
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

        //File user1 = new File("user1.txt");
       
    
    }
    
}
