package week1.day2;

import java.util.Arrays;
public class MissingElementInArray {
	public static void main(String[] args) {
	int[] arr = {1,2,3,4,7,6,8};
	int l,n,sum=0,missingnumber;
	Arrays.sort(arr);
    l = arr.length + 1;  // 7+1 +8
    n = l * (l+1)/2 ;    //36
    for (int i = 0; i < arr.length; i++) {
	sum = sum + arr[i];	 
	}
    missingnumber = n-sum;
	System.out.println("Missing number is: " +missingnumber);
	}
	}
		
	
			

