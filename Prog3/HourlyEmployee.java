import java.util.*;
import java.io.*;
import java.io.Serializable;
import java.text.DecimalFormat;

public class HourlyEmployee extends Employee implements Serializable{
//Variables
 public DecimalFormat dec = new DecimalFormat("#######.##");

//Constructor
 public HourlyEmployee(String input, double inputW){
   name = input;
   wage = inputW;
 }


//computes either the yearly or weekly pay for the employee.
 public double computePay(int hours){
  int overtime =0;
  double overtimePay =0;
  //if it is over 40 it 
  if(hours > 40){
    overtime = hours - 40;
    overtimePay = (1.5*(wage)) *overtime;
    return (40 *wage) + overtimePay;


  }
  else{
   return hours * wage;
  }
 }

//Converts all of the information into a string
 public String toString(){
   return name + "\t $" + dec.format(wage) + "/hour";
 }



}
