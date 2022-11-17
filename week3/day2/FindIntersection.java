package week3.day2; //Assignment 2

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {
public static void main(String[] args) {
	int[] a = {3,2,11,4,6,7};	
	int[] b = {1,2,8,4,9,7};
	List<Integer>lst = new ArrayList<Integer>();
	for (int i = 0; i < a.length; i++) {
		lst.add(a[i]);
	} System.out.println("a : "+lst);
	
	List<Integer>pst = new ArrayList<Integer>();
	for (int i = 0; i < b.length; i++) {
		pst.add(b[i]);
	} System.out.println("b : "+pst);
	System.out.println("Intersected numbers in a & b : ");
	for (int i = 0; i < lst.size(); i++) {
	for (int j = 0; j < pst.size(); j++) {
   if (lst.get(i) == pst.get(j)) {
	   System.out.println(lst.get(i));
} 	
		}
	}
}
}


//* a) Declare An array for {3,2,11,4,6,7};	 
//* b) Declare another array for {1,2,8,4,9,7};
//* c) Declare for loop iterator from 0 to array length
//* d) Declare a nested for another array from 0 to array length
//* e) Compare Both the arrays using a condition statement
//
//*  f) Print the first array (shoud match item in both arrays)
