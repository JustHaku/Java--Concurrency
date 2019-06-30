/*Week 2 Exercise - Crowd funding

This exercise you will show an implementation of a lock (mutex)*/

import java.util.*;
import java.lang.*;

public class deposit {

  /*Increment the donation account as donators contribute */

   int accountBalance = 0;	
	
  public int readAccount()						//Reads the current account balance
  {    
       
	return accountBalance;
    
  }
  
  public synchronized void deposit_funds()					//Increments when a funder provides a donation
  {
	  
	accountBalance = readAccount() + 5;
    
  }      
  
}

