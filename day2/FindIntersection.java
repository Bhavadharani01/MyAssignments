package week1.day2;

public class FindIntersection {
public static void main(String[] args) {
	int[] numA = {3,2,11,4,6,7};
	int[] numB = {1,2,8,4,9,7};	
	for(int i = 0; i < numA.length; i++) {		
	for(int j = 0; j < numB.length; j++) { 	
		if (numA[i] == numB[j]) {
			System.out.println(numA[i]);
			}
	}
	}
	
	//if (numA[i] == numB[j]) {
		//System.out.println("First Array: " + numA[i]);
	//}
}
}

//	 * d) Declare a nested for another array from 0 to array length
//	 * e) Compare Both the arrays using a condition statement 
//	 *  f) Print the first array (shoud match item in both arrays)	 
//*
	
	//Arrays.sort(numA);
	//int length = numA.length; //will assign the local variable ctrl+2 +l
    //System.out.println(length);
	//System.out.println(numA[length-1]);
//
//}