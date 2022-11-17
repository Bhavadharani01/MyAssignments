package week3.day2; //Assignment 4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElementInAnArray {
public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
        int sum = 0;
        int l,n ;
        Arrays.sort(arr);
        List<Integer>lst = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
			lst.add(arr[i]);
		}
        System.out.println(lst);
       l = lst.size() + 1;
       n = l * (l+1)/2;
       for (int i = 0; i < lst.size(); i++) {
		sum = sum + arr[i];
	}
    System.out.println("Missing number is: "+ (n - sum));   
}       
}//TreeSet<Integer>lst = new TreeSet<Integer>();