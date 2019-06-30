import java.util.*;
public class semaphore {

	private int count = 0;

	public semaphore(int init_val){
		
	count = init_val; // Should check its >= 0
	
	}

	public synchronized void hold(){
		
	count = count - 1;
	
		if (count < 0) {

			try{	
			
				wait(); // Go on per-object queue
			
			}

			catch(Exception e){

				System.out.println("Throws exception");

			 }
		}
	}

	public synchronized void release(){
		
	count = count + 1;
	if (count <= 0) notify(); // Free a waiting thread
	
	}

}

