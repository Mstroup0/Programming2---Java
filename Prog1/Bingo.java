
//
//

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Bingo{

//main method
	public static void main(String[] args) throws FileNotFoundException 
	{

		int dim = 5;
		int[][] card = new int[dim][dim];
		String name = "bingo.in";

		fillCard(card, dim, name);	
		printCard(card);
		playGame(dim, card);
		printCard(card);

	}
	
//Methods	
// Fill card
	public static void fillCard(int[][] card, int size,  String name ) throws FileNotFoundException 
	{

		File input = new File(name);
		Scanner in = new Scanner(input);
	
	 	while(in.hasNextInt()){
		for(int i=0; i < size; i++){
			for(int j=0; j< size; j++){
				card[i][j] =  in.nextInt();	
			
			}
		}
		}
	
	}

//print card
	public static void printCard(int[][] card)
	{	
		System.out.println("Your bingo card:\n");
		System.out.println("B   I   N   G   O");
		System.out.println("------------------");

 		for(int i =0; i <card.length; i++){
			for(int j=0; j<card[i].length; j++){
				if(card[i][j] == 0){
					System.out.print("|X|");
				}
				else{
					System.out.print("|" + card[i][j] + "|");
				}
			}
			System.out.println("\n-------------------");
		}
		System.out.println();
	
	}
// Pick a Random number

	public static int pickNumber()
	{
		int ran =0;
		double rand =0 ;
 
		rand = (Math.random()* 75 + 1);
		ran = Math.round((float)rand);

		
		return ran;
	}



//Play game
	public static void playGame(int size, int[][] card)
	{
		int ran;
		int count = 0;
		int win =0;
		int k =1;
		BitSet bit = new BitSet(76);		
		for(int i =0; win ==0; i++)
		{	
			ran = pickNumber();
			if(bit.get(ran)){

				ran = pickNumber();
			}
			else{	
				bit.set(ran);
				check(card, size, ran);
				win = checkForWin( size, card);

			}
		}
		System.out.println("Bingo numbers pick");
		for(int j = 1; j <77; j++){
			if(bit.get(j)){
				System.out.print(" " + j);
				count++;
		
			}

		}

		System.out.println("\n");
		System.out.println("The total numbers pick is " +  count);
		winType(win);
		
			
	}
	
// Check for win
	public static int checkForWin(int size, int[][] card)
	{
		int sum =0;
		int win =0; 
		//Check for a Horizontal win
		for(int col =0; col < size; col++){	
			for(int i = 0; i< size; i++){
				sum += card[i][col];
			}
			if(sum == 0)
			{
				win = 1;
				break;	
			}	
			sum =0;
		}

		//Check for a Vertical win
		for(int rw = 0; rw < size; rw++){		
			for(int j =0; j< size; j++)
			{
				sum += card[rw][j]; 
			}
			
			if(sum ==0)
			{
				win = 2;
				break;
			}
			sum =0;
		}
		
		//Check for a Diagonal from left corner
		for(int k =0; k < size; k++){
			sum += card[k][k];
		}
		if(sum == 0){
			win =3;
		}
		sum =0;

		// Check for diagonal from right corner
		for(int l = 0; l < size; l++){
			for(int g =4; g >= 0; g--){ 
			sum += card[l][g];
			}
		}
		if (sum == 0){
			win = 4;
		}

		return win; 
	}
// Type of win
	public static void winType(int win){
		switch(win){
		case 1: 
			System.out.println("The win type is Horizontal Win");
			break;
		case 2:
			System.out.println("The win type is Vertical");
			break;
		case 3:
			System.out.println("The win type is Diagonal from the left corner.");	
			break;
		case 4:
			System.out.println("The win type is Diagonal from the right corner.");
		}

	}
//Sorts for the same number
	public static void check(int[][] card, int size, int num)
	{
		for(int i = 0; i< size; i++){
			for(int j =0; j < size; j++){
				if (card[i][j] == num){
					card[i][j] = 0;
					break;
				}
			}

		}

	}


}

