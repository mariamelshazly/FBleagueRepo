
package fbleague;
import java.util.Scanner;

/**
Authors:
Ahmed Medhat
Abdulrahman Ayman
Mariam ElShazly
 */
public class FBLeague {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        SigningUp u1 = new SigningUp();
        LoggingIn u2 = new LoggingIn();
        int choice;
        Scanner chc = new Scanner(System.in);
        while(true)
        {
        	System.out.println("Please enter what you want to do: \n");
        	System.out.println("1. Sign Up \n");
        	System.out.println("2. Log in \n");
        	System.out.println("3. Exit \n");
        	System.out.println("Please input your choice by entering the corresponding number: ");
        	choice = chc.nextInt();
        	if(choice == 1)
        	{
        		u1.SignUp();
        		continue;
        	}
        	else if (choice == 2)
        	{
        		u2.LogIn();
        		break;
        	}
        	else if (choice == 3)
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
    }
    
}
