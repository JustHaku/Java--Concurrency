import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Looper extends Thread{
    
    Random rand = new Random();

    
    /*You can decide whether you wish to implement locks
     	method or code block - I would advise you try
        both out to see for yourself */
        
    List<Integer> listA = new ArrayList<Integer>();
    List<Integer> listB = new ArrayList<Integer>();

 
      
    public void listOne() throws InterruptedException {

            
                listA.add(rand.nextInt(100));
         
            
    }
    
    public void listTwo() throws InterruptedException {
            
          
                listB.add(rand.nextInt(100));
          
            
    }

   	   
    public void run(){

	readList();

  
    }		    
  
    public synchronized void readList() {
        for(int i=0; i<500; i++) {

	try{

            listOne();
            listTwo();

	}
	catch(Exception e){
	
	System.out.println("Thread exception");
	
        }
    }
}
}

