/*Week 2 Exercise - Crowd funding


This exercise you will show an implementation of a lock (mutex)*/

import java.util.*;
import java.lang.*;

public class Crowdfund { 
  /* The first class called in the program - creates number of donators, predicted funds, and final outcome*/
   public static void main (String arg[]) 
   {      								
     int predictedDonations = 0;			//Variable declarations that can be potentially use
     int numUsers = 0;
     int donation = 5;	 				//The amount (£) that donators are able to contribute
     int counter = 0;
     
     
     Scanner scan = new Scanner(System.in);		
     funder boop = new funder();
     
     System.out.println("Please enter the total number of backers");
     numUsers = scan.nextInt();
     Thread[] users = new Thread[numUsers];	
     			    
     predictedDonations = numUsers * donation;
     
     /*The developer wants to implement three things: 
     
     1) Allow the user to specify the number of donators participating in the crowd sourcing
     2) Predict the total funds given a certain amount of users
     3) Emulate numerous funders actively providing donations, which subsequently update the total funding account
     4) Provide a numerial comparison between the predicted donations and actual donations
        
        Successful completion of this exercise will see predicted == actual donations, irrespective of thread generation and execution runs
     */   
     for(int i = 0; i < users.length; i++)
     {
         users[i] = new Thread(boop);
         users[i].start();
     }   
     
     for(int i = 0; i < users.length; i++)
     {        
         if(i > 0){
        	 
        	 try{
        		 users[i].join();
        	 }
        	 catch(Exception e){
        		 System.out.println("Welp");
        	 }
         }
     }   
     
     System.out.println("Num. of Contributors: " + numUsers);
     System.out.println("----------------");
     System.out.println("Predicted Donations: " + predictedDonations);
     System.out.println("Actual Donations: " + boop.account.readAccount());
	}																				
}
