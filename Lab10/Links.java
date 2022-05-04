
public class Links
{
	public static void main(String[] args)
	{
          	Node pos1 = null;
    		Node pos2 = null;
    		pos1 = new Node(new Integer(13));
   		pos1.setNext(new Node(new Integer(15), null));
    		pos2 = new Node(new Integer(11), null);
		pos2.setNext(pos1);
		printList(pos2);
		System.out.print(count(pos2));
		findMax(pos2);
	}

	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
	
	}
	}
	
	private static int count(Node head){
		
		if (head == null){
			return 0;
		}
		else{
		 	return count(head.getNext()) +1;
		}
	}

	private static void findMax(Node head){
		Node prev, curr, max = null;
				
		for( curr = head.getNext(); curr != null   ;  curr.getNext()){
			prev = head;
			if (((Comparable)prev.getItem()).compareTo((Comparable)curr.getItem()) > 0)
			{
				max = curr;
	
				System.out.println(max.getItem());
			}
			prev = curr;
		}
	}




}
