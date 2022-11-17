package week3.day1; //Assignment 2

public class Palindrome {
//	* a) Declare A String value as"madam"
public static void main(String[] args) {
	String a = "madam"; //01234
	String rev = "";
	char[] a1 = a.toCharArray();
	for (int i = a1.length - 1; i >=0 ; i--) {
		rev = rev + a1[i];
	} 
	System.out.println("a : "+ a);
	System.out.println("rev : " +rev);
	if (a.equals(rev)) {
		System.out.println("a & rev are palindrome");
	}
} 

//* b) Declare another String rev value as ""
//* c) Iterate over the String in reverse order
//* d) Add the char into rev
//* e) Compare the original String with the reversed String, if it is same then print palinDrome 
//
//* Hint: Use .equals or .equalsIgnoreCase when you compare a String 

}
