import java.util.*;
public class TestArrayList
{
    public static void main(String[] args)
    {
	ArrayList<String> myArrayList = new ArrayList<String>(10);
	
	myArrayList.add("Python");
	for(int i =0; i<4; i++)
		myArrayList.add("Java");
	
	for(int i =0; i<3;i++)
		myArrayList.add("C++"); 

	System.out.println("Intial Array List:");

	printArrayList(myArrayList);

	System.out.println("\nArray List after Java is removed");
	
	delete(myArrayList, "Java");

	printArrayList(myArrayList);
	

	System.out.println("\nThe count for the word Python is " + count( myArrayList, "Python"));


    }

    private static void printArrayList(ArrayList<String> myArrayList)
    {
	// Pre  : myArrayList has been initialized
	// Post : The elements of Vector v are printed to the screen on separate lines

	for(int i =0 ; i < myArrayList.size(); i++)
		System.out.println(myArrayList.get(i));


    }

    private static void delete(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	// Post : All copies of key are removed from myArrayList
	for(int i= 0; i < myArrayList.size(); i++)
		myArrayList.remove(key);


    }

    private static int count(ArrayList<String> myArrayList, Object key)
    {
	// Pre  : myArrayList has been initialized
	// Post : number of occurrences of key is computed and returned
	
	int count =0;

	for(int i =0; i < myArrayList.size(); i++){
		if(key.equals(myArrayList.get(i))){
			count++;
		}

	}

	return count;


    }
}
