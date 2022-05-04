// Immports
import java.util.*;
import java.io.*;



// Main method
public class Main{
	private static int numbooks =0 ;
	
	public static void main(String[] args) throws InterruptedException {
		
		//Classes/ Variables
		 ArrayList<LibraryBook> books = new ArrayList<LibraryBook>(50);
		String key; 
		int numBooks; 
	
		//file input	
		File curDir = new File(".");
		String[] fileNames = curDir.list();
		ArrayList<String> data = new ArrayList<String>();

		//Find Files with 
		for(String s : fileNames)
		{
			if(s.endsWith(".dat")){
				data.add(s);
			}
		}
		
		//Adding files to array

		for(int i =0; i < data.size(); i++){
			numBooks = inputBook(data.get(i), books);
		}
		
		//Menu
		menu(books);	

	}
//Clear Screen
	private static void clearScreen(){
		System.out.println("\u001b[H\u001b[2J");
	}
//Sort (Fixed and working do not mess with)
	private static void sort(ArrayList<LibraryBook> books){
		int i, last;
		int  max = 0;
		LibraryBook temp;

		for(last = books.size()-1; last >= 0; last--){
			max =0;
			for(i =0; i <=  last; i++){
				if(books.get(i).compareTo(books.get(max))> 0){
					max = i;
				}
			}
			if( max != i ){
				temp = books.get(last);
				books.set(last, books.get(max));
				books.set(max, temp);
			}
		}



	}		

	
//Find (Complete)
	private static void find(ArrayList<LibraryBook> books, String key){
		//Vriables and Classes
		int i = 0;
		int location =-1;
		boolean found = false; 
	

  		while((!found)&&( i < books.size() )){
			if((books.get(i).getTitle().compareToIgnoreCase(key))==0){
				found = true;
				location = i;
			}
			i ++;
		}

		if(found){
			System.out.println("--------------------------------------------------------------");	
			System.out.println("Book was Found");
			System.out.println("--------------------------------------------------------------");	
			printRecord(books, location);
		}
		else{
			System.out.println("--------------------------------------------------------------");	
			System.out.println("Book was not Found");	
			System.out.println("--------------------------------------------------------------");	
		}
	}

//menu Display (Complete)
	private static void menuDis(){
		System.out.println("--------------------------------------------------------------");	
		System.out.println("		THE GREAT BOOKS SEARCH PROGRAM");	
		System.out.println("--------------------------------------------------------------");	
		System.out.println("1) Display all book records");	
		System.out.println("2) Search for a book by Title");	
		System.out.println("3) add new book to records");	
		System.out.println("4) Exit Search Program");	
		System.out.println("---------------------------------------------------------------");	
		System.out.print("Pleae Enter your Choice		");	

	}
//Menu 
	private static void menu(ArrayList<LibraryBook>books) throws InterruptedException{
		Scanner in = new Scanner(System.in);
		Scanner inString = new Scanner(System.in);
		int choice = 0;
		String choice2 ="";
		String key;
		int i =0;
		sort(books); 
		
		do {
			choice =0;
			try{
				System.out.println("\n A total of " + (books.size()) + " books have been inputed and sorted by title.");
				menuDis();
				choice = in.nextInt();
				switch(choice){
					case 1:	
						clearScreen();
						System.out.println("All the books in the Catalog\n");
						System.out.print("----------------------------------------------------------\n");
						try{
							while(i< books.size()){
							
							printRecord(books, i);
							i++;
							if(choice2.compareToIgnoreCase("M") ==0){
								break;
							}
							
							else if(choice2.compareToIgnoreCase("") == 0){
								continue;	
							
							}
							System.out.print("----------------------------------------------------------\n");
							System.out.println("Hit enter to Continue or Input M to return to main menu");											System.out.print("----------------------------------------------------------\n");
							choice2 = in.next();

							}
						}	
						catch(NumberFormatException e){
							System.err.println("Error: not an Integer");
						}
						catch(InputMismatchException e){
							System.out.println("Try again");
							in = new Scanner(System.in);  
						}	
					case 2:		
						clearScreen();
						System.out.println("Finding a book in the Catalog\n");						
						System.out.print("----------------------------------------------------------\n");
						System.out.println("Input the Title of the book you wish to search for\n");
						System.out.print("----------------------------------------------------------\n");
						try{
							key = inString.nextLine();
							find(books, key);
						}	
						catch(InputMismatchException e){
							System.out.println("Try again");
							inString = new Scanner(System.in);  
						}	
						//Return to man menu
						System.out.print("----------------------------------------------------------\n");
						System.out.println("Input 0 to return to main menu");					
						System.out.print("----------------------------------------------------------\n");
						try{
							choice = in.nextInt();
							if(choice == 0){
								break;
							}
						}	
						catch(NumberFormatException e){
							System.err.println("Error: not an Integer");
						}
						catch(InputMismatchException e){
							System.out.println("Try again");
							in = new Scanner(System.in);  
						}	
					//Adds new book
					case 3:
						clearScreen();
						System.out.println("Input your own book into the Catalog.\n");
						System.out.print("----------------------------------------------------------\n");
						addBook(books);
						printRecord(books, (books.size()-1));
						sort(books);						
						System.out.print("----------------------------------------------------------\n");
						System.out.println("Hit Enter to return to main menu");					
						System.out.print("----------------------------------------------------------\n");
						try{
							choice2 = in.next();
							if(choice == 0){
								break;
							}
						}	
						catch(NumberFormatException e){
							System.err.println("Error: not an Integer");
						}
						catch(InputMismatchException e){
							System.out.println("Try again");
							in = new Scanner(System.in);  
						}	
				}
				clearScreen();
			}
			catch(NumberFormatException e){
				System.err.println("Error: not an Integer");
			}	
			catch(InputMismatchException e){
				System.out.println("Try again");
				in = new Scanner(System.in);  
			}	
		}while(choice != 4); // when 4 is choosen it  exits the program
		

		
	}

//Print (Complete)
	public static void printRecord(ArrayList<LibraryBook> books, int location){
		System.out.println("Record #:" + (location + 1) + ": \n");	
		System.out.print("----------------------------------------------------------\n");
		System.out.println("Title: 	"+ books.get(location).getTitle());
		System.out.println("Author:	"+ books.get(location).getAuthor());
		System.out.println("Copyright:	"+ books.get(location).getCopyright());
		System.out.println("Price:	"+ books.get(location).getPrice());
		System.out.println("Genre:	"+ books.get(location).getGenre()+ "\n");
		System.out.print("----------------------------------------------------------\n");
	}
// Print All records (Complete)
	public static void printAll(ArrayList<LibraryBook> books){
		for(int i = 0; i < books.size(); i++){
			printRecord(books, i);
		}

	}

//Input (Complete)
	public static int inputBook(String inputFile, ArrayList<LibraryBook> books){
		int numbooks = 0;
		try{

			Scanner in = new Scanner(new File(inputFile));
			while(in.hasNext()){
				Scanner lsc = new Scanner(in.nextLine()).useDelimiter(";");
				String title = lsc.next();
				String name = lsc.next();
				int copyright = lsc.nextInt();
				double price = lsc.nextDouble();
				String genre = lsc.next();
	
				books.add(new LibraryBook(title, name, copyright, price, genre));
				numbooks ++;

			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		return numbooks;
	}

//Add Book to record
	public static void addBook(ArrayList<LibraryBook> books){
		//Classes
		Scanner inString = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		Scanner indoub = new Scanner(System.in);
		
		// Varibles
		String title;
		String auth;
		int copyright;
		double price;
		String genre;

		//asking for inputs
		System.out.println("Input the title");
		title = inString.nextLine();
	
		System.out.println("Input the author");
		auth = inString.nextLine();

		System.out.println("Input the copyright year");
		copyright = in.nextInt();

		System.out.println("Input the price");
		price = indoub.nextDouble();
		
		System.out.println("Input the genre");
		genre = inString.next();

		//adding to array and library
		books.add(new LibraryBook(title, auth, copyright, price, genre));
		numbooks ++;		
		
	}



}
