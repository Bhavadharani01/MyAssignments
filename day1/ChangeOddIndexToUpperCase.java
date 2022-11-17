package week3.day1; //Assignment1

public class ChangeOddIndexToUpperCase {
public static void main(String[] args) {
	String test = "changeme";
	char[] test1 = test.toCharArray();
	for (int i = 1; i < test1.length; i=i+2) { //3579   i<8
		  test1[i] = Character.toUpperCase(test1[i]);
	}
	System.out.println(test1);
} 	 
//	 * b) Traverse through each character (using loop) 
//	 * c)find the odd index within the loop (use mod operator)	 
//	 * d)within the loop, change the character to uppercase, if the index is odd else don't change
}
