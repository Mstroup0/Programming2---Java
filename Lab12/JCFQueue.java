
import java.util.*;
@SuppressWarnings("unchecked")
public class JCFQueue
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		LinkedList queue1 = new LinkedList();
		LinkedList queue2 = new LinkedList();
		Object key = new Character('$');

        	queue1.addLast(new Character('b'));
        	queue1.addLast(new Character('$'));
        	queue1.addLast(new Character('E'));
        	queue1.addLast(new Character('$'));
        	queue2.addLast(new Character('b'));
        	queue2.addLast(new Character('$'));
        	queue2.addLast(new Character('E'));
        	queue2.addLast(new Character('b'));
		System.out.println("dup check = " +
                    identicalCheck(queue1, queue2));
		findAndReplace(queue1, key, new Character('*'));
		System.out.println("** After findAndReplace **");
		printQueue(queue1);
	}

	private static boolean identicalCheck(LinkedList queue1,
                                              LinkedList queue2)
                throws CloneNotSupportedException
	{
		LinkedList cop1 = (LinkedList)queue1.clone();
		LinkedList cop2 = (LinkedList)queue2.clone();
		int i =0;		
		
		if(cop1.size() != cop2.size()){
			return false;
		
		}
		else{
		while (cop1.size() != 0  && cop2.size()!= 0){
			if(((Character)cop1.get(1)).charValue() != ((Character)cop2.get(1)).charValue())
				i ++;

			cop1.removeFirst();
			cop2.removeFirst();
		}

		if (i==0)
			return true;

		else
			return false;


		}
	}

	private static void findAndReplace(LinkedList queue1, 
		Object key, Object newVal)
	{

		for(int i =0; i < queue1.size();i++){
			if(((Character)queue1.get(i)).charValue() == (Character)key.charValue()){
				queue1.set(1, (Character) newVal);
			}
		}	

	}

	private static void printQueue (LinkedList q)
		 throws CloneNotSupportedException
	{

			LinkedList cop = (LinkedList) q.clone();
			
			for(int i = 0; i< q.size();i++)
				System.out.print(cop.get(i)+ " ");

	}

}
