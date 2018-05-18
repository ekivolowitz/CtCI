
package src;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        String[] mn = scanner.nextLine().split(" ");

	        int m = Integer.parseInt(mn[0]);

	        int n = Integer.parseInt(mn[1]);

	        String[] magazine = new String[m];

	        String[] magazineItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        HashMap<String, Integer> mags = new HashMap<String, Integer>();
	        HashMap<String, Integer> ran = new HashMap<String, Integer>();
	        
	        for (int i = 0; i < m; i++) {
	            String magazineItem = magazineItems[i];
	            if(mags.containsKey(magazineItem)) {
	                int curr = mags.get(magazineItem);
	                mags.put(magazineItem, curr + 1);
	            } else {
	                mags.put(magazineItem, new Integer(1));
	            }
	        }

	        String[] ransom = new String[n];
	        
	        
	        String[] ransomItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            String ransomItem = ransomItems[i];
	            ransom[i] = ransomItem;
	            if(!ran.containsKey(ransom[i]))
	                ran.put(ransom[i], new Integer(0));
	        }
	        scanner.close();
	        
	        int i;
	        
	        for(i = 0; i < ransom.length; i++) {
	            if((!mags.containsKey(ransom[i]) || (ran.get(ransom[i]).equals(mags.get(ransom[i]))))) {
	                System.out.println("No");
	                return;
	            } else {
	                int current = ran.get(ransom[i]);
	                ran.put(ransom[i], new Integer(current + 1));
	            }
	        }       
	        System.out.println("Yes");
	    }
}
