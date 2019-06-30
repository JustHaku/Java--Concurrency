import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class calculation {
	public static void main(String arg[]) throws Exception {

  	System.out.println("Commence execution of the two lists.");
        long start_time = System.currentTimeMillis();
           
  	Looper calc = new Looper();
        
	Thread Thread1 = new Thread(calc);
	Thread Thread2 = new Thread(calc);
    Thread Thread3 = new Thread(calc);

	Thread1.start();
	Thread2.start();
	Thread3.start();

	try{
	    
	    Thread1.join();
	    Thread2.join();
	    Thread3.join();
	}
	catch(Exception e){
	    
    	    System.out.println("Thread Exception");
	}

        long end_time = System.currentTimeMillis();

      
        System.out.println("Time to complete: " + (end_time - start_time));
        System.out.println("List1: " + calc.listA.size() + "; List2: " + calc.listB.size());        
	}
	
}

