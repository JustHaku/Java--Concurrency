import java.util.*;

public class listCount {

public static void main(String[] args)
  {
   int num_users = 0;
   int elements = 0;
   int bufferSize = 0;
   Thread[] users;
   
   Scanner scan = new Scanner(System.in);
   
   System.out.println("Enter number of users:");			//Specify number of users			
   num_users = scan.nextInt();		
   users  = new Thread[num_users];
   
   System.out.println("Enter number of elements per user:");		//Specify number of elements submitted per user	
   elements = scan.nextInt();	  
   
   bufferSize = num_users * elements;
   Buffer b = new Buffer(bufferSize);						//Create buffer
	

   
   for(int x = 0; x < num_users; x++){
	   
	   users[x] = new Thread(new user(1+x,elements,b));
	   users[x].start();
	   
   }
   
   
   for(int i = 0; i < users.length; i++)
   {        
      	 
      	 try{
      		 users[i].join();
      	 }

      	 catch(Exception e){
      		 System.out.println("Welp");
      	 }
   }
   
   b.finalSummation();							//When buffer is full, calculate SUM of elements within the buffer
   
  }
}

