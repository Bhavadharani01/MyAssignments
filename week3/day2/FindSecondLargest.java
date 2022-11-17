package week3.day2; //Assingment 3

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {
	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7};
	
		List<Integer>lst = new ArrayList<Integer>();
		for (int i = 0; i < data.length; i++) {
			lst.add(data[i]);
		}
		
		//Arrays.sort(data);
		Collections.sort(lst);
		
		System.out.println("Sorted data: "+lst);
	    System.out.println("2nd last element in sorted data: " + lst.get(4));
		
	}
}

/*
Pseudo Code:
1) Arrange the array in ascending order
2) Pick the 2nd element from the last and print it
*/	 