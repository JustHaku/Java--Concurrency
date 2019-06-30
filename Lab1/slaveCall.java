import java.util.*;
import java.lang.*;


public class slaveCall implements Runnable {
 /*Class slaveCall represents 4 different servers that perform some "dummy" computation (reflected by WHILE loops. You are not needed to alter anything within those methods */
  
  long startTime = System.currentTimeMillis();  
	
  public slaveCall()
  {
  }
  
  public void server1()	
  {
    long startTime = System.currentTimeMillis();
    while(false||(System.currentTimeMillis()-startTime)<1000)
    {
    // While loop is used to replica calculation time for the "server" here.
    }
    
    System.out.println("Server 1 calculation completed");
  }
  
  public void server2(){
    long startTime = System.currentTimeMillis();
     while(false||(System.currentTimeMillis()-startTime)<1000)
    {
    
    }
    System.out.println("Server 2 calculation completed");
  }
  
  public void server3(){
    long startTime = System.currentTimeMillis();
     while(false||(System.currentTimeMillis()-startTime)<1000)
    {

    }
    System.out.println("Server 3 calculation completed");
  }
  
  public void server4(){
    long startTime = System.currentTimeMillis();
     while(false||(System.currentTimeMillis()-startTime)<1000)
       {
    
       }
    System.out.println("Server 4 calculation completed");
  }
  

  public void run(){
		
    server1();	
       
  }

}


