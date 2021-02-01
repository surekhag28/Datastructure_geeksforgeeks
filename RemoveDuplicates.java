//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String S) {
        StringBuilder out = new StringBuilder();
		S=S.toLowerCase();
		for(int i=0;i<S.length();i++) {
			String ch =  S.substring(i,i+1);
			if(out.indexOf(ch)<0)
				out.append(ch);
		}
		return out.toString();
    }
}
