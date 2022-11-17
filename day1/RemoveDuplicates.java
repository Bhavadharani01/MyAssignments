package week3.day1; //Assignment 3

public class RemoveDuplicates {
	public static void main(String[] args) {
		String input = "We learn java basics as part of java sessions in java week1";//12
		int count = 0;
		String[] split = input.split(" ");
		//System.out.println(split[0]);
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals("java")  ) {
				count = count + 1;
			}
		}
		System.out.println("count of duplicate words: " + count);
		if (count>1) {
			String reverse = input.replace("java", "");
			System.out.println("Input without duplicate words: "+ reverse);
		}
		
	}
}
//String text = "We learn java basics as part of java sessions in java week1";		
//* b) Initialize an integer variable as count	  
//* c) Split the String into array and iterate over it 
//* d) Initialize another loop to check whether the word is there in the array
//* e) if it is available then increase and count by 1. 
//* f) if the count > 1 then replace the word as "" 
//
//* g) Displaying the String without duplicate words	

