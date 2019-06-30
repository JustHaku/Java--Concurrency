ort java.util.*;
public class semaphore {

	private int count = 0;

	public semaphore(int init_val)
	{
	count = init_val; // Should check it’s >= 0
	}

	public synchronized void P()
	{
	count = count - 1;
	if (count < 0) 

	     try{		
		wait(); // Go on per-object queue
		}

             catch(Exception e){

	        System.out.println("oops");

	     }
	}

	public synchronized void V()
	{
	count = count + 1;
	if (count <= 0) notify(); // Free a waiting thread
	}

}

