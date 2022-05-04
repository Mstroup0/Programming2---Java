
public class mySums{


public static void main(String[] arg){

	System.out.println(iterativeSum(4));
	System.out.println(recurSum(4));

}

public static double iterativeSum(int n){
	if(n ==1 ){
		return 3.0;
	}
	else{
		double x =0;
		for ( int k  =1; k <= n; k ++){
			x = (Math.pow(2.0, n)) +1;
		}
		return 2* x;
	}

}
public static double recurSum(int n) {

	if(n==1){
		return 3.0;
	}
	else{
		return recurSum(n-1)+ Math.pow(2.0, n) + 1.0;
	}


}
}
