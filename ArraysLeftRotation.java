package src;

import java.lang.Math;

public class ArraysLeftRotation {
	public static void main(String args[]) {
		 
		int n = 5;
		int k = 4;
		
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++)
			a[i] = i;
		int i;
	    int[] temp = new int[k];
	    for(i = 0; i < k; i++)
	        temp[i] = a[i];
	    for(i = 0; i < k; i++)
	    	System.out.print(temp[i] + " ");
	    System.out.println();
	    for(i = k; i < n; i++)
	        a[i - k] = a[i];
	    int count = 0;
	    for(i = n - k; i < n; i++) {
	    	a[i] = temp[count]; 
	    	count++;
	    }
	        
	    for(i = 0; i < n; i++)
	        System.out.println(a[i] + " ");
	}
}
