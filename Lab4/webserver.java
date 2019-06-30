import java.util.*;

class webserver implements Runnable{

	private int id;
	private int total_elements;
	private static Buffer buf;								//Stores user inputted buffer
	
    public webserver(int i, int el, Buffer b){
    	
    	id = i; 
    	total_elements = el; 								//stores user input in variables
    	buf = b;
    	
    }
  
    //runs the remove method on user inputted buffer
    
    public void remove_elements(int id){

		buf.removeFromList(id);							

	}

	public synchronized void run(){
			
		//runs remove code if the total elements to be removed arent 0
		
		while(total_elements != 0){
			
			total_elements--;
			remove_elements(id);
			
			
		}
					
	}  
	
	//useful getter
	
	public int getWebServerId(){
		
		return id;
		
	}
		
}