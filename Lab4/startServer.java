import java.util.*;
public class startServer{
  	Buffer b;										//Creation of Variables and variable arrays
  	Scanner scan = new Scanner(System.in);
  	int numUsers = 0;
  	int numServers = 0;
    int totalElements = 0;
    int bufferSize = 0;
    int splitElements;
    int splitServerElements;
    int countRemainder;
	user[] users;
	webserver[] webServers;
	Thread[] userThreads;
	Thread[] webServerThreads;
	
  	
   public startServer(){												//Constructor for server class that runs when instanciated
        
   long startTime = System.currentTimeMillis();							//Used to start time counting 
																
														

   //Takes in user input after printing and assigns the input to their corresponding variables above
   
   System.out.println("Enter buffer capacity");				

   bufferSize = scan.nextInt();	
   b = new Buffer(bufferSize);	
   
   System.out.println("Enter number of users");
   
   numUsers = scan.nextInt();
   
   System.out.println("Enter number of servers");
   
   numServers = scan.nextInt();
   
   System.out.println("Enter total number of elements");
   
   totalElements = scan.nextInt(); 
   
   
   //Used to Calculate whether there are remaining elements that need to be split, if there aren't continues on and splits the elements between the servers and users.
   
   countRemainder =  totalElements % numUsers;
   
   if(countRemainder != 0){
	   
	   numUsers = numUsers + countRemainder;
	   numServers = numServers + countRemainder;
	   
	   splitElements = totalElements / numUsers;
	   splitServerElements = totalElements / numServers;
	   
   }
   
   else{
	   
   splitElements = totalElements / numUsers;
   
   splitServerElements = totalElements / numServers;
   
   }

   System.out.println("-----------------------");
	
   //Assigns sizes to the arrays containing users,webservers,user threads and webserver threads
   
   users = new user[numUsers];
   webServers = new webserver[numServers];
   
   userThreads = new Thread[numUsers];
   webServerThreads = new Thread[numServers];   
   
   
   //populates user and webserver arrays through loops based number of users & webservers entered
   
   for(int x = 0; x < numUsers; x++){
	   
	   users[x] = new user(1+x,splitElements,b);
	   
   }
   
   for(int x = 0; x < numServers; x++){
	   
	   webServers[x] = new webserver(1+x,splitServerElements,b);
	   
   }
   
   //populates thread arrays using the user and webserver arrays then starts each thread
   
   for(int x = 0; x < userThreads.length; x++){
	   
	   userThreads[x] = new Thread(users[x]);
	   userThreads[x].start();
	   
   }
   
   for(int x = 0; x < webServerThreads.length; x++){
	   
	   webServerThreads[x] = new Thread(webServers[x]);
	   webServerThreads[x].start();
	   
   }
   
   //joins the threads in each thread array
   
   for(int x = 0; x < userThreads.length; x++){
	   
	   try{
		   
		   userThreads[x].join();
		   
	   }
	   
	   catch(Exception e){
		   
		   System.out.println("Process threw an exception");
		   
	   }
   }
   
   for(int x = 0; x < webServerThreads.length; x++){
	   
	   try{
		   
		   webServerThreads[x].join();
		   
	   }
	   
	   catch(Exception e){
		   
		   System.out.println("Process threw an exception");
		   
	   }
    }
   
   System.out.println("-----------------------");
   
   
   //displays the total amount of elements created or removed by users and webservers
   
   for(int x = 0; x < numUsers; x++){
	   
	 System.out.println("User " + users[x].getUserId() + " created a total of " + splitElements + " elements ");
	   
   }
   
   for(int x = 0; x < numServers; x++){
	   
	   System.out.println("Webserver " + webServers[x].getWebServerId() + " consumed a total of " + splitServerElements + " elements ");	   
   }
   
  
   b.finalSummation();  		 //displays the final size of the buffer after all elements have been added & removed
  
   
   //checks whether each thread in both thread arrays are alive and displays result
   
   for(int x = 0; x < userThreads.length; x++){
	   
	   System.out.println("User thread " + users[x].getUserId() + " is alive: " + userThreads[x].isAlive());
	   
   }
   
   for(int x = 0; x < webServerThreads.length; x++){
	   
	   System.out.println("Server thread " + webServers[x].getWebServerId() + " is alive: " + webServerThreads[x].isAlive());
	   
   }
				
   
   //displays how long the program took to run from start to end time
   
   long endTime = System.currentTimeMillis();
   System.out.println("-----------------------");
   System.out.println("Program took " + (endTime - startTime) + " milliseconds to complete");		
	
    }
  
   
   public static void main(String[] args){

    startServer start = new startServer();  			//instanciation runs the startServer constructor
    
   }
}
