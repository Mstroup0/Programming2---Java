
import java.util.*;

public class TestEmployee{

	public static void main(String[] args){

		Date birth = new Date(1980, 3,8);
		Date employ = new Date();
		double sal =40000.0;
		
		Employee brown = new Employee("Brown" , "Morris", birth, sal, employ);

		System.out.println(brown.toString());


}

}
