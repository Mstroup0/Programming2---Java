import java.util.*;


public class CheckingAccount extends Account{
	
// Instance Variables
	private int numChecks; 


// Constuctors
	public CheckingAccount(double initBalance){ 
		super(initBalance);
		numChecks =0;
	}

// Get methods
	public int getChecksWritten(){
		return numChecks;

	}
// write a check
	public void writeCheck(double checkAmount){
		withdraw(checkAmount);
		numChecks ++;	
	} 




}
