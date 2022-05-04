import java.util.*;
import java.io.*;
import java.text.DecimalFormat;


public  abstract class Employee implements Serializable{
//Varibles
 public String name;
 public double wage;
 public DecimalFormat dec = new DecimalFormat("#######.##"); // converts numbers into two decimals

//Get methods
//Name
 public String getName(){
   return name;
 }

//wage
 public double getWage(){
   return wage;
 }

//Set methods
//name
 public void setName(String input){
    name = input;
 }

//wage
 public void setWage(double inputw){
    wage = inputw;
 }

//A method that increase the wage (raise)
 public double raise(double percent){
   wage = wage + (wage *(percent/100));
   return wage;

 }

//abstract methods
 public abstract double computePay( int hours);


}
