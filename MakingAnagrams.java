package src;

import java.util.Scanner;

public class MakingAnagrams {

    private static int findNumInstances(String str, char c) {
        int i;
        int count = 0;
        for(i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c)
                count++;
        }
        return count;
    }
    
    private static boolean exists(char[] list, char c) {
        int i;
        for(i = 0; i < list.length; i++) {
            if(list[i] == c)
                return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        scanner.close();
        
        
        int i;
        String short_string = "", longer_string = "";
        if(a.length() == b.length()) {
        	short_string = a;
        	longer_string = b;
        } else if(a.length() > b.length()) {
        	short_string = b;
        	longer_string = a;
        } else {
        	short_string = a;
        	longer_string = b;
        }
        int num_deletions = 0;
        int current_insert = 0;
        char[] used = new char[longer_string.length() + short_string.length()];
        for(i = 0; i < longer_string.length(); i++) {
            char curr = longer_string.charAt(i);
            if(exists(used, curr))
                continue;
            used[current_insert] = curr;
            current_insert++;
            int num_shorter = findNumInstances(short_string, curr);
            int num_longer = findNumInstances(longer_string, curr);
            // The case that both letters exist and are equal in counts.
            if(num_shorter != num_longer)    
                num_deletions += Math.abs(num_shorter - num_longer);    
        }
        for(i = 0; i < short_string.length(); i++) {
        	char curr = short_string.charAt(i);
        	if(exists(used, curr))
        		continue;
        	used[current_insert] = curr;
        	current_insert++;
        	int num_shorter = findNumInstances(short_string, curr);
        	int num_longer = findNumInstances(longer_string, curr);
        	if(num_shorter != num_longer)
        		num_deletions += Math.abs(num_shorter - num_longer);
        	
        }
        
        System.out.println(num_deletions);
    }
}
