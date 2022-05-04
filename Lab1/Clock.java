//Clock class
//Created by Mackenzie Stroup
//08/30/2019
 
public class Clock{

	final static int hoursInDay = 23, minInHours = 59,secInMin = 59;

//Variables
	private int hours, min, sec;

//Input constructor
	public Clock(int inHours, int inMin, int inSec)
	{
		this.hours = inHours;
		this.min = inMin;
		this.sec = inSec;
	}

//Defualt constructor
	public void clock()
	{
		this.hours = 0;
		this.min = 0;
		this.sec = 0;
	}

//reset all to 0	
	private void reset()
	{
		this.hours = 0;
		this.min = 0;
		this.sec = 0;
	}

//reset to parameters
	public void  overrideReset(int inHours, int inMin, int inSec)
	{
		this.hours = inHours;
		this.min = inMin;
		this.sec = inSec;
	}
//Advances the time by 1 second
	public void advance()
	{
		if(sec<59)
		{
			sec ++; 
		}
		else if(sec == 59)
		{
		 	if(min < 59)
			{
				min ++;
			}
			else if(min == 59)
			{
			 	if(hours < 23)
				{
					hours ++;
				}
				else if(hours == 23)
				{
					reset();
				}
			}
		}
	}


// Takes the informationa dn writes it to a string
	public String toString()
	{
		return hours + ":" + min + ":" + sec ; 
	}

}
