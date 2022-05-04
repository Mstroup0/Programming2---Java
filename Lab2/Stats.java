import java.util.*;

public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;

        	numItems = fillUp (List);

        	System.out.println("\n\10\7" + " The range of your " +
                                   numItems + " items is :  " + 
				   range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + 
                                   numItems + " items is  :  " +
				   mean (List, numItems));
	}

// filler up method
// fills the array with user input until count == 100 or zero is inputed.  
	public static int fillUp( int[] list)
	{
		System.out.println("Please input your numbers, press zero to end");
		Scanner in = new Scanner(System.in);
		int temp= 0, count=0;
		while(count != 100) // runs until count == 100
		{
			temp= in.nextInt();
			if( temp ==0) // breaks from the loop if 0 is inputed
			{
				break;
			}
			list[count] = temp; 
			count ++; // increasing the count
		}
				
		return count; 
	}
// finds the range of values 
	public static int  range(int []list, int numItems)
	{
		int max, min, diff; 
		max = -999999;
		min = 999999;
		for(int i =0; i<numItems; i++)
		{
			if(max<list[i]) // compares
			{
				max= list[i];
			}
			if(min>list[i])
			{
				min =  list[i];
			}
		}
		
		
		
	
		return max-min;
	}

// Finds the mean of all the numbers. 
	public static int mean(int[] list, int numItems)
	{
		double  mean =0; 

		for(int i =0;i<list.length ;i++)
		{
			mean  +=  list[i];
		}
		
		mean/= numItems;		

		return mean;
	}




}
