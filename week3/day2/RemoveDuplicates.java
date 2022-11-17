package week3.day2;//Assignment 1

public class RemoveDuplicates {
	public static void main(String[] args) {
		
	String a = "We learn java basics as part of java sessions in java week1";
	int count = 0;
	String[] split = a.split(" ");
	
	//List<String>lst = new ArrayList<String>();
//	for (int i = 0; i < a.length(); i++) {
//		lst.add(split[i]);
//	}
	//System.out.println(split[1]);
	for (int i = 0; i < split.length; i++) {
		if (split[i].equals("java")) {
			 count = count +1;
		}
	}System.out.println("Duplicate count: "+count);
	if (count>1) {
		String remove = a.replace("java", "");
		System.out.println("String without duplicates: " + remove ); //
	}
}
}
//* a) Use the declared String text as input
//String text = "We learn java basics as part of java sessions in java week1";		
//* b) 
//* c) Split the String into array and iterate over it 
//* d) Initialize another loop to check whether the word is there in the array
//* e) if it is available then increase and count by 1. 
//* f) if the count > 1 then replace the word as "" 
//* g) Displaying the String without duplicate words