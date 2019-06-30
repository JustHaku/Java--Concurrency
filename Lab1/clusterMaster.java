import java.util.*;
import java.lang.*;


public class clusterMaster{
/* clusterMaster calls servers 1-4, and prints the total time taken to complete the entire program.*/
	public static void main (String arg[]) { 
         
    long startTime = System.currentTimeMillis();
    
	 slaveCall call = new slaveCall();	

     Thread server1 = new Thread(call);
	 Thread server2 = new Thread(call);
	 Thread server3 = new Thread(call);
	 Thread server4 = new Thread(call);
	  
	 server1.start();
	 server2.start();
	 server3.start();
	 server4.start();

	 try{
		
    	 server1.join();
	     server2.join();
	     server3.join();
         server4.join();
	}
	catch(Exception e){
		System.out.println("weeeew");
}


 	
	 long endTime = System.currentTimeMillis();
	 System.out.println("Threads for servers took " + (endTime - startTime) + " milliseconds to 	      complete");


	}
	
}
