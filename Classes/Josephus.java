import java.util.*;
public class Josephus
{
  public static void main(String[] args)
  {
    int[] info = new int[2];
    Node trailer = null;   //  Used to traverse circle

    getInput (info);
    trailer = buildCircle (info[0], trailer);
    trailer = josephus (info[1], trailer);
  }

  public static void getInput(int[] info)
  {
    Scanner in = new Scanner(System.in);
    System.out.println("^^^^^^^^^^  THE JOSEPHUS PROBLEM ^^^^^^^^^^");
    System.out.print("Please Enter the Number of People (N) : ");
    info[0] = in.nextInt();
    System.out.print("Please Enter the Number of Passes (M) : ");
    info[1] = in.nextInt();
    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
  }

  public static Node buildCircle (int people, Node trailer)
  {
    Node temp = new Node(new Integer(1));
    Node ldata = temp;

    for (int i = 2; i <= people; i++)
    {
      temp.setNext(new Node(new Integer(i)));
      temp = temp.getNext();
    }

    temp.setNext(ldata);  // Make list circular
    trailer  = temp;      // Record location of last person
    return trailer;
  }

  public static Node josephus (int passes, Node trailer)
  {
    Node potato;  // Assume potato starts at person 1
    System.out.print("\tOrder of Elimination :  ");

    while (trailer !=  trailer.getNext())
    {
       for (int i = 1; i <= passes; i++)   // Pass the hot potato
         trailer  = trailer.getNext();

       System.out.print(trailer.getNext().getItem() + " ");
       potato = trailer.getNext();
       trailer.setNext(potato.getNext());
    }
    System.out.println(trailer.getItem());
    return trailer;
  }
}

