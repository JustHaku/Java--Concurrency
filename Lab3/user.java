import java.util.*;
public class user implements Runnable
 {								
  private int id;
  private int num_elements;
  public static Buffer buf ;
		  
  public user(int i, int el, Buffer b)	        				//User arguments: User ID, number of elements to add, buffer object
		  {id = i; num_elements = el; buf = b;}
  
  public void add_elements(int i){
   
	 buf.addToList(i,id);							
												
  }
  
  public void run(){
	  
	  for(int x = 0; x < num_elements; x++){

		  add_elements(x);

	  }

  }

 }  
