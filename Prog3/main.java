//This is the main method for the project.
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;


public class main{
//Varibles
 public static  DecimalFormat dec = new DecimalFormat("#######.##");
//
 public static void main(String[] arg){
    //Variables
    ArrayList<Employee> emp = new ArrayList<Employee> (50);
	inputMenu(emp);
 }
//basic layout of the menu
 public static void MenuLayout(){
  clearScreen();
  Line(40, '-');
  System.out.print("Commands: n - New employee" + "\n\t" + "c - Compute paychecks" +"\n\t" + "r - Raise wages" +"\n\t"+ "p - print Records" +"\n\t"+ "d - download data" +"\n\t"+ "u - upload data" + "\n\t" + "q - Quit \n");
  Line(40, '-');
  System.out.println(" Enter command:" );

 }

//user input Takes the menu outline and adds the element of user inputs.
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
 	else if((in !='n' || in != 'c' || in != 'r' ||in != 'p' || in != 'd'|| in != 'u' )&& in != 'q'){ //Catches any value that is not n,c,r,p,d,u
 		System.out.println("Comand was not recongized please try again");
 	}
   }  while(in!='q');

 }


// Add new employee
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

//compute the pays
 public static void computePay(ArrayList<Employee> emp){
    Scanner in = new Scanner(System.in);
    int hours;
    double pay =0;
    for(int i =0; i< emp.size(); i++) {
	 System.out.println("Enter the number of hours worked by " +emp.get(i).getName() +" :");
	 hours = in.nextInt();
	 pay =emp.get(i).computePay(hours);
	 if (pay==0)
	 {
		 System.out.println("Pay: $" +  dec.format((emp.get(i).getWage()/52)));
	 }
	 else {
		 System.out.println("Pay: $" + dec.format(pay));
	 }
	 }
 }

//method to raise the wages
 public static void raiseWage(ArrayList<Employee> emp){
    Scanner in = new Scanner(System.in);
    double perce =0;
    double raise=0;
    System.out.println("Enter percentage increase: ");
    perce = in.nextDouble();
    for(int i =0; i< emp.size(); i++) {
		raise = emp.get(i).getWage() + (emp.get(i).getWage() * (perce/100));
        emp.get(i).setWage(raise);

    }
    print(emp);

 }

//Method to print the array
 public static void print(ArrayList<Employee> emp){
    String display;
     for(int i =0; i< emp.size(); i++){
	System.out.println(emp.get(i).toString());
    }

 }


// Sets inputs to specific classes.
 public static void setArray(ArrayList<Employee> emp,  char type, double wage, String name) {
  if  (type == 'h'){
     emp.add(new HourlyEmployee(name, wage));
  }
  else if(type =='s'){
   emp.add(new SalariedEmployee(name, wage));
  }

 }

//Adds to file
 public static void objectOut( ArrayList<Employee> emp){
   String filename = "MyEmployees.dat";
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
// brings in data from the file
 public static void objectIn(ArrayList<Employee> emp){
  String FileName = "MyEmployees.dat";
  try{
    FileInputStream FileIn = new FileInputStream(FileName);
    ObjectInputStream in = new ObjectInputStream(FileIn);
    for(int i = 0; i < emp.size(); i++ )
     emp.add((Employee)in.readObject());
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

//CLears the screen
 public static void clearScreen(){
  System.out.println("\u001b[H\u001b[2J");

 }

// creates lines and prints them
 public static void Line(int n, char ch){
  for(int i = 1; i <=n; i++)
    System.out.print(ch);
  System.out.println();
 }




 }
