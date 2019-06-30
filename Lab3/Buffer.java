import java.util.*;

public class Buffer 						//Provides data and operations onto the fixed-length queue
 {     									
  private LinkedList<Object> buf_list;		
  private int elements;						//Number of elements currently on the queue
  private int buf_size;						//Maximum number of elements allowed on queue
  public int numCount = 0;
  semaphore check = new semaphore(1);	

  public Buffer(int n)						//Queue creation, with n indicating the maximum capacity
   {
     buf_list = new LinkedList<Object>();
     elements = 0;
     buf_size = n;
   }

  public void finalSummation()				
   {								//Calculates the total sum of element value within the buffer
	
	  int sum = 0;
	  
	  sum = sum + numCount;
         System.out.println("--------------------------");
    System.out.println("Count total: " + sum); 
    System.out.println("--------------------------");
    }
  
  public void addToList(int i, int id){
	  
	  check.P();
	  buf_list.add(i);
	  numCount = numCount + i;
	  elements++;
	  System.out.println("User " + id + " adds element " + elements  + " / " + buf_size);
	  check.V();
  }

}	
