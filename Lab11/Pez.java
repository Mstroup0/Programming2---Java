

public class Pez{

 public static void main(String[] arg)throws CloneNotSupportedException{
	Stack pez = new Stack();
	addPez(pez);
	print(pez);
	removeGreen(pez);
	print(pez);
  }

 public static void addPez( Stack add){
 	add.push(new String("yellow"));
 	add.push(new String("red"));
 	add.push(new String("green"));
 	add.push(new String("green"));
 	add.push(new String("yellow"));
 	add.push(new String("yellow"));
 	add.push(new String("red"));
 	add.push(new String("green"));


 }

 public static void removeGreen(Stack cycle) throws CloneNotSupportedException{
	Stack temp = new Stack();
	String in = "green";
	while(!cycle.isEmpty()){
		if(((String)cycle.top()).compareTo((String)in)!= 0){
			temp.push((String)cycle.top());

		}
		cycle.pop();	
			
	}
	 while(! temp.isEmpty()){
		cycle.push((String)temp.top());
		temp.pop();
	}	
 }

 public static void print (Stack s) throws CloneNotSupportedException
  {
        Stack tempStack = (Stack) (s.clone());
        if (! tempStack.isEmpty())
                System.out.println("Stack:  ");

        while (! tempStack.isEmpty())
       {
               System.out.println(tempStack.top());
               tempStack.pop();
        }
  }


 }


