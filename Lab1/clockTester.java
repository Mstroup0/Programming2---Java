//Clock tester class
// created by Mackenzie Stroup
//08/30/2019

import java.util.*;

public class clockTester{
	
	//the string asking for the input
	final static String Prompt = "\n\n Enter time, in the format hours, minutes, and seconds";

	public static void main (String[] args)
	{
		//asks from the inputs
		System.out.println(Prompt);		
		
		//the inputs
		Scanner in = new Scanner (System.in);
		int hours = in.nextInt();
		int min = in.nextInt();
		int sec = in.nextInt();

		//
		Clock dvr = new Clock(hours, min, sec);
		
		//Displays the in the inputs	
		System.out.println("\nHours: "+ hours);
		System.out.println("Minutes: "+ min);
		System.out.println("Seconds: "+ sec);
		
		//set the time
		dvr.overrideReset( hours, min, sec);
		
		//Displays the current time
		System.out.println("\nThe time is now " + dvr.toString());
		
		//Advancing the time
		System.out.println("\nAdvancing the time.");
		dvr.advance();
		System.out.println("The time is now " + dvr.toString()); 
		
		

	}
}
