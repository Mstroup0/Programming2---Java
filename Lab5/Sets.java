
import java.util.*;

public class Sets
{
	private static final int BOUND = 8;
	public static void main(String[] args)
	{
		BitSet set1 = new BitSet(BOUND);
		BitSet set2 = new BitSet(BOUND);
		
		for (int i = 1;  i < BOUND;  i *= 2)
			set1.set(i);

		for (int i = BOUND-1;  i > 0;  i /= 2)
			set2.set(i);
	
		System.out.print("set1 = \n");
		print(set1);
		System.out.print("set2 = \n");
		print(set2);

		System.out.print("\ninverse of set1 = \n");
		print(inverse(set1));
		System.out.print("inverse of set2 = \n");
		print(inverse(set2));

	}
	
	public static void print(BitSet key){
	
	for(int i = 0; i< BOUND; i++){
		if(key.get(i)){
			System.out.println(1);

		}
		else{
			System.out.println(0);
		}

	}

	}

	public static BitSet  inverse(BitSet key){
		for(int i =0;i < BOUND; i++){
			if(key.get(i)){
				key.clear(i);
			}
			else{
				key.set(i);
			}

		}
		
	

	return key;
	}

}
