import java.io.*;
import java.util.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Leader obj = new Leader();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    
		    //appending result to a String
		    for(int i=0; i<res.size(); i++){
		        str.append(res.get(i)+" ");
		    }
		    
		    //printing the String
		    System.out.println(str);
		}
		
	}
}
// } Driver Code Ends


class Leader{
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
		int max=arr[arr.length-1];
		list.add(max);
		
		for(int i=arr.length-2;i>=0;i--) {
			if(max<=arr[i]) {
				max=arr[i];
				list.add(max);
			}
		}
		int i=0,j=list.size()-1;
		
		while(i<=j) {
			int temp=list.get(i);
			list.set(i, list.get(j));
			list.set(j,temp);
			i++;j--;
		}
		return list;
    }
}
