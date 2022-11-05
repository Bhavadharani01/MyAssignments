package week1.day2;

public class CheckPositiveOrNegative {
		/*Pseudocode
		 * 1. Initialize a number, say, int number= 35; 
		 * 2. If a number is positive, print "The number is positive" 
		 * If a number is negative, print "The number is negative" 
		 * If it nether negative nor positive, print as
		 * "The number is neither positive nor negative"
		 */
	public static void main(String[] args) {
		int a = 35;
if (a > 0) {
	System.out.println(a + " is positive number");
}
else if (a < 0) {
	System.out.println(a + " is negative number");
} else {
System.out.println(a + " is either negative nor positive number");
}
	}
}
