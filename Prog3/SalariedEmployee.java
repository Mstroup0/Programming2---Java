import java.util.*;
import java.text.DecimalFormat;
import java.io.*;
import java.io.Serializable;

public class SalariedEmployee extends Employee implements Serializable{

//Variables

 public double wageS;
 public DecimalFormat dec = new DecimalFormat("#######.##");//converts amounts into to have two decimal places

//Constructor
public SalariedEmployee(String input, double inputW){
   name = input;
   wageS= inputW;
   wage = (wageS/52)/40;
 }

//Getter
//for the wage
 public double getWage(){
  return wageS;
 }
 //for the name
 public String getName() {
	 return name;
 }
//Setter
//for the wage
 public void setWage(double input){
  wageS = input;

 }
 //for the name
public void setName(String nam) {
	name = nam;
}
//computes either the yearly or weekly pay for the employee.
 public double computePay(int hours){
  return ((1/52)*wageS);

 }

//Converts all of the information into a string
 public String toString(){
  return name + "\t $" + dec.format(wageS)+ "/year";

 }


}
