
import java.util.*;

public class LibraryCat extends LibraryBook{

	public LibraryCat (String title, String author, int copyright, double price, String ngenre ){
		
		super(title, author, copyright, price, ngenre);	
		
	}

	public String toString(){
		return "Title:" + + "\n"
			"Author:" + + "\n" 
			"Copyright" + + "\n"
			"Price: $" + + "\n"
			"Genre: " + + "\n"; 
		
	}
	
	



} 
