
import java.util.*;
import java.io.*;


public class main{

 public static void main(String[] arg){
 ArrayList<Employee> emp = new ArrayList<Employee> (50);
	inputMenu(emp);
 }


public static void MenuLayout(){
  clearScreen();
  Line(40, '-');
  System.out.print("Commands: n - New employee" + "\n\t" + "c - Compute paychecks" +"\n\t" + "r - Raise wages" +"\n\t"+ "p - print Records" +"\n\t"+ "d - download data" +"\n\t"+ "u - upload data" + "\n\t" + "q - Quit \n");
  Line(40, '-');
  System.out.println(" Enter command:" );

 }

 public static void inputMenu(ArrayList<Employee> emp) {
    Scanner input = new Scanner(System.in);
	char in = 'A';
   do{
	MenuLayout();
	in = input.next().charAt(0);	
	if(in =='n')
		addEmp(emp);

	else if(in == 'c')
		computePay(emp);

	else if(in=='r' )
		raiseWage(emp);

	else if (in =='p')
		print(emp);

	else if(in =='d')
		objectIn(emp);

 	else if(in =='u')
		objectOut(emp);
 	else if((in !='q' ||in !='n' || in != 'c' || in != 'r' ||in != 'p' || in != 'd'|| in != 'u') && in != 'q' ){
 		System.out.println("Comand was not recongized please try again");
 	}
   }  while(in!='q');

 }
 
 public static void addEmp(ArrayList<Employee>emp){
	double wage=0;
	String name;
	char type;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the name of the employee");
	name = in.nextLine();

	System.out.println("hourly(h) or salaried(s)");
	type = in.next().charAt(0);
	
	
	   if(type == 'h'){
		System.out.println("enter hourly wage:");
		wage =in.nextDouble();
	   }
	   else if(type =='s' ){
   	   	System.out.println("enter salary");
		wage= in.nextDouble();
 	   }
	else if(type != 'h' || type != 's'){
     		System.out.println("input was not h or s; please try again");
     	}
	setArray(emp, type, wage, name);
	

 }


 public static void computePay(ArrayList<Employee> emp){
    Scanner in = new Scanner(System.in);
    int hours;
    for(int i =0; i< emp.size(); i++) {
	 System.out.println("Enter the number of hours worked by " +emp.get(i).getName() +" :");
	 hours = in.nextInt();	
	System.out.println("Pay:" + toDollars(emp.get(i).computePay(hours)));
    }
 }

 public static void raiseWage(ArrayList<Employee> emp){		
    Scanner in = new Scanner(System.in);
    double perce =0;	
    System.out.println("Enter percentage increase: ");
    perce = in.nextDouble();
    for(int i =0; i< emp.size(); i++)
		emp.get(i).raise(perce);
    print(emp);
 }


 public static void print(ArrayList<Employee> emp){
    String display;
     for(int i =0; i< emp.size(); i++){
	System.out.println(emp.get(i).toString());
    }

 }


 public static void setArray(ArrayList<Employee> emp,  char type, double wage, String name) {
  if  (type == 'h'){
     emp.add(new EmployeeH(name, wage));
  }
  else if(type =='s'){
   emp.add(new EmployeeSal(name, wage));
  }
  
 }

 public static void objectOut( ArrayList<Employee> emp){
   String filename = "object.out";
   try{
     FileOutputStream fileout = new FileOutputStream(filename);
     ObjectOutputStream out = new ObjectOutputStream(fileout);
     for(int i =0; i< emp.size(); i++)
         out.writeObject(emp.get(i));
     out.close();
   }
   catch(IOException e){
     System.out.println(e.getMessage());
   } 

 }

 public static void objectIn(ArrayList<Employee> emp){
  String FileName = "Employees.dat";
  try{
    FileInputStream FileIn = new FileInputStream(FileName);
    ObjectInputStream in = new ObjectInputStream(FileIn);
    in.readObject();
    in.close();

  }
  catch(IOException e){
    System.out.println(e.getMessage());
  }
  catch(ClassNotFoundException e){
    System.out.println(e.getMessage());
  }
  for (int i =0; i <emp.size(); i++) {
    System.out.println(emp.get(i));
  }

 }
  
 public static void clearScreen(){
  System.out.println("\u001b[H\u001b[2J");

 }

 public static void Line(int n, char ch){
  for(int i = 1; i <=n; i++)
    System.out.print(ch);
  System.out.println();
 }

 public static String pad(String str, int n){
  if(str.length()> n)
   return str.substring(0,n);
  while(str.length() < n)
    str+= " ";
  return str;
 }

 public static String toDollars(double amount){
  long roundedAmount = Math.round(amount *100);
  long dollars = roundedAmount / 100;
  long cents = roundedAmount *100;
  if (cents <= 0)
    return dollars + ".0" + cents;
  else
    return dollars + "." + cents;

 }



}
