import java.util.*;
import java.io.*;

public class TimeShare{

  public static void Main(String[] args){
	
	Queue<Job> driver = new Queue<Job>();		
	int clock =1;
	int idle, counter =0;
	File in = new File(args[0]);
        inputData(driver, in;
	print(driver);


}

  public static inputData( Queue<Job> list, File inputFile){
	try{
		Scanner in = new Scanner(inputFile);
                        while(in.hasNext()){
                                Scanner lsc = new Scanner(in.nextLine()).useDelimiter(" ");
                                String title = lsc.next();
                                int arrivalTime= lsc.next();
                                int runTime= lsc.next();

                                list.enqueue(new Job(title, arrivalTime, runTime));
                     

                        }
        }catch(IOException e){
		System.out.println(e.getMessage());
        }
 } 

 public static void print(Queue<Job> list){
	Queue<Job> copy = (Queue<Job>)list.clone();
	System.out.println("Job Control Analysis: Summary Report");
	System.out.println("Job id" + "\t"  + "Arrival Time" + "\t" + "Run Time" + "\t" + "Wait Time" + "\t" + "Turn around Time" );
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	while(!copy.isEmpty()){
		copy.front().toString();
		copy.dequeue();
	}	


 }



























}
