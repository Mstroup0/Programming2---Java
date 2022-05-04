import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class TimeShare{
//Global variables
  public static int clock =0;
  public static int idle =0;
  public static int counter = 0;
  public static double numJob =0;

//main method
  public static void main(String[] args) throws CloneNotSupportedException{
    //Queue
	Queue input = new Queue();
	String inFile = args[0];
  //variable and input method
  numJob = inputData(input, inFile);
  // the proceess method
  proceess(input, numJob);


}

 public static double inputData( Queue list, String inputFile){
   double num =0;
  try{
		Scanner in = new Scanner(new File(inputFile));

                        while(in.hasNext()){
                                Scanner lsc = new Scanner(in.nextLine()).useDelimiter("\t");
                                String title = lsc.next();
                                String arrival = lsc.next();
                                String run = lsc.next();
                                int arrivalTime = Integer.valueOf(arrival);
                                int runTime = Integer.valueOf(run);

                                list.enqueue(new Job(title, arrivalTime, runTime));
                                num ++;
                              }

        }catch(IOException e){
		        System.out.println(e.getMessage());
        }
        return num;
 }

 public static void print(Queue list, double num) throws CloneNotSupportedException {
   //Variables
   String dec = "###.00";
   double avgWait, cpuUsage, cpuIdle, cpuPercent, sumWait;
   sumWait =0;
   //DEcimal Formating
   DecimalFormat form = new DecimalFormat("###.##");
   DecimalFormat form2 = new DecimalFormat(dec);
// Queues
  Queue copy = (Queue)list.clone();
  Queue copy2 = (Queue)list.clone();
  // Prints starts
	System.out.println("Job Control Analysis: Summary Report");
	System.out.println("Job id" + "\t"  + "Arrival Time" + "\t" + "Run Time" + "\t" + "Wait Time" + "\t" + "Turn around Time" );
	System.out.println("----------------------------------------------------------------------------------------------------------------");
//Prints all of the jobs
  while(!copy.isEmpty()){
		System.out.println(((Job)copy.front()).toString());
		copy.dequeue();
	}

  //Calculations
  //for the total wait time
  while(!copy2.isEmpty()){
		sumWait = sumWait + (((Job)copy2.front()).getWait());
		copy2.dequeue();
	}
  //finding the values
  avgWait = sumWait/num;
  cpuUsage = counter;
  cpuIdle = idle - sumWait;
  // if the cpu idle is - set it to zero
    if(cpuIdle < 0){
      cpuIdle =0;
      dec = "0.00";
    }
  cpuPercent = (cpuUsage / (cpuUsage + cpuIdle)) *100;

  //prints the Calculations
  System.out.println("Average Wait Time => " + form.format(avgWait));
  System.out.println("CPU usage => " + form2.format(cpuUsage));
  System.out.println("CPU idle => " + form2.format(cpuIdle));
  System.out.println("CPU usage (%) => " + form.format(cpuPercent) + "%");

}

 public static void proceess(Queue in, double num) throws CloneNotSupportedException {
   //variables
   int turn =0;
   int wait =0;
   double sumWait =0;
   //Queues
  Queue job = new Queue();
	Queue copy = (Queue)in.clone();
	Queue finish  =  new Queue();

  //Cycels through the queues until all the jobs are done
  while(!copy.isEmpty() || !job.isEmpty()){
		    if( !copy.isEmpty()){
            if((((Job)copy.front()).getArrival())== clock ){
              job.enqueue(copy.front());
			           copy.dequeue();
               }

		    }
       if(!job.isEmpty() &&((((Job)job.front()).getRTime()) == (clock - (((Job)job.front()).getArrival())))){
                turn = clock -(((Job)job.front()).getArrival());
                ((Job)job.front()).setTurn(turn);
                ((Job)job.front()).setStart((clock -(((Job)job.front()).getRTime()))+(((Job)job.front()).getWait()));
                counter += (((Job)job.front()).getRTime());
                finish.enqueue(job.front());
                job.dequeue();

            }
    if(!job.isEmpty() &&((((Job)job.front()).getArrival()) < clock) && ((((Job)job.front()).getTime())==-1)){
             ((Job)job.front()).setStart(clock);
             wait = clock - (((Job)job.front()).getArrival());
              ((Job)job.front()).setWait(wait);
                if(((Job)job.front()).getWait() == 1){
                  wait =0;
                  ((Job)job.front()).setWait(wait);
                }

          }

   clock ++;
  }

  idle = (clock - counter);
  print(finish, num);

}


}
