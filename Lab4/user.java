import java.util.*;

public class user implements Runnable{	
	
	private int id;
	private int num_elements;
	private static Buffer buf ;				//Stores user inputted buffer
	int x = 0;								//Used as a counter for run method
	
	public user(int i, int el, Buffer b){
		
		id = i;
		num_elements = el; 									//stores user input in variables
		buf = b;
		
	}

	//runs the add method on user inputted buffer
	
	public void add_elements(int i){

		buf.addToList(i,id);							

	}

	public void run(){

		//runs add code if x hasnt reached the number of elements to be added
		
		while(x < num_elements){
		
			add_elements(x);
			x++;

			
		}
			
	}
	
	//useful getter
	
	public int getUserId(){
		
		return id;
		
	}
	
}   