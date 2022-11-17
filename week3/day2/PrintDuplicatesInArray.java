package week3.day2;//Assignment 5

import java.util.ArrayList;
import java.util.List;

public class PrintDuplicatesInArray {
public static void main(String[] args) {
	int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20}; //14,18,17
	int count = 0;
	List<Integer>lst = new ArrayList<Integer>();
	for (int i = 0; i < arr.length; i++) {
		lst.add(arr[i]);  
	}
	System.out.println("Lenght of array: "+lst.size());
	
	System.out.println("Matching Duplicate values: ");
	for (int i = 0; i < lst.size() - 1; i++) {
	for (int j = i+1; j < lst.size(); j++) {
		if (lst.get(i) == lst.get(j)) {
			count = count+1;
			System.out.println(lst.get(i));
		}
	}
	}System.out.println("Count of duplicates: "+count);
	// get the length of the array
	// declare an int variable named count// assign 0 to count 
	// iterate from 0 to the array length-1 (outer loop starts here)
	// iterate from i to the length of the array by adding 1 to it (inner loop starts here)	
	// compare both the loop variables & check they're equal
	// print the matching value
}
}
