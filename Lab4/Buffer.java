import java.util.*;

public class Buffer							//Provides data and operations onto the fixed-length buffer
  {     									
	private LinkedList<Object> buf_list;		
	private int elements;							//Number of elements currently on the queue
	private int buf_size;							//Maximum number of elements allowed on queue
	private semaphore lock = new semaphore(1);					//Binary semaphore used to lock multiple threads from changing variables in critical section at once
	private semaphore bufferEmpty = new semaphore(0);			// 0 Semaphore used to check if the buffer is empty
	private semaphore bufferFull;								// Semaphore used to check when the buffer is full according to the buffer size inputted

	public Buffer(int n)						//Queue creation, with n indicating the maximum capacity
	{
		buf_list = new LinkedList<Object>();
		elements = 0;
		buf_size = n;
		bufferFull = new semaphore(buf_size);  					
	}

	public void finalSummation()				
	{							

		int sum = buf_list.size(); 				//Calculates the total sum of element value within the buffer

		System.out.println("--------------------------");
		System.out.println("Buffer has " + sum + " elements remaining"); 			//Displays the total sum of element value within the buffer
		System.out.println("--------------------------");
	}

	
	//Method used to add elements to the linked list, takes in parameters of the size of number to add and the user id
	
	public void addToList(int i, int id){
	
		if(elements == buf_size){
			
			System.out.println("Buffer full - user waiting");					//Used to print that the buffer is full if the elements within the buffer become equal to the buffer size
			
		}
		
		bufferFull.hold();														//Locks this semaphore if the buffer is full	
		lock.hold();															//Locks this method if a thread is in the critical section
		
		buf_list.add(i);
		elements++;
		System.out.println("User " + id + " adds element " + elements  + " / " + buf_size);			//Displays which user added the element to the buffer
		
		
		lock.release();															//unlocks this method if a thread leaves the critical section
		bufferEmpty.release();													//unlocks semaphore to show that the buffer has elements	
		
	}
	
	public void removeFromList(int id){
		
		if(elements == 0){
			
			System.out.println("Buffer empty - webserver waiting");				//Used to print that the buffer is empty if the elements in the buffer reach 0
			
		}
		bufferEmpty.hold();														//Locks this semaphore if the buffer is empty
		lock.hold();															//Locks this method if a thread is in the critical section
		
		buf_list.remove(elements - 1);
		System.out.println("Webserver " + id + " removed element " + elements  + " / " + buf_size );			//Displays which webserver removes an element
		elements--;
		
		lock.release();															//unlocks this method if a thread leaves the critical section
		bufferFull.release();													//unlocks this semaphore if the buffer has no elements
		
		
		
	}

	public int getBufSize(){												//useful getters 
		
		return buf_size;
		
	}
	
	public int getElements(){
		
		return elements;
		
	}
	
}	  
