package week1.day2;

public class Palindrome {
	public static void main(String[] args) {
		int a, temp, rn=0, num= 34343;
		temp=num;
		for (int i = 1; 0 < num; --i) {
			a=num%10;
			rn=(rn*10)+a;
			num=num/10;	
		}
		if (temp == rn) {
			System.out.println(temp + " is a palindrome");
		} else {
           System.out.println(temp + " is not a palindrome");
		}
	}

}
