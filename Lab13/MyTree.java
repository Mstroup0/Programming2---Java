import java.util.*;


public class MyTree{

	public static void main(String[] arg){

		BinarySearchTree t = new BinarySearchTree();

		t.insert(new KeyedItem("M"));
		t.insert(new KeyedItem("J"));
		t.insert(new KeyedItem("D"));
		t.insert(new KeyedItem("F"));
		t.insert(new KeyedItem("L"));
		t.insert(new KeyedItem("W"));
		t.insert(new KeyedItem("S"));
		t.insert(new KeyedItem("Z"));
		t.insert(new KeyedItem("T"));
	
		t.inorder();
		t.preorder();

		BinarySearchTree copy = new BinarySearchTree();
		
		copy.insert(new KeyedItem("M"));
		copy.insert(new KeyedItem("J"));
		copy.insert(new KeyedItem("D"));
		copy.insert(new KeyedItem("F"));
		copy.insert(new KeyedItem("L"));
		copy.insert(new KeyedItem("W"));
		copy.insert(new KeyedItem("S"));
		copy.insert(new KeyedItem("Z"));
		copy.insert(new KeyedItem("T"));

		
		if(t.duplicateCheck(copy))
			System.out.println("They're duplicates");
		else
			System.out.println("They're not duplicates");


		t.delete("M");
		t.preorder();


	}






}
