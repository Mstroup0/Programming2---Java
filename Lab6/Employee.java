import java.util.*;


public class Employee extends Person {
	private double salary;
	private	Date employedDate;

	public Employee(String lName, String fName, Date birthDate, double sal, Date employDate ){
		super(lName, fName, birthDate);
		this.salary= sal;
		this.employedDate = employDate;

	}
// Geter and setter for salary

	public double getSalary(){
		return salary;
	}

	public void setSalary(double amount){
		this.salary = amount ; 

	}

// Getter and setter for date
	public Date getEmployedDate(){
		return employedDate;
	}

	public void setEmployedDate(Date employDate){
		this.employedDate = employDate;
	}
	


// to string
	public String toString(){
		return ( "Name = " + getLastName()+ "," + getFirstName() + "\n" + 
			"Salary = " + salary + "\n" + 
			"Date of Birth = " + getBirthDate() + "\n" +
			"Hired = " + employedDate);

	}

}
