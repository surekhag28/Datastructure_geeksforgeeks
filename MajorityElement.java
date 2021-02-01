
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Majority().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Majority
{
    static int majorityElement(int a[], int size)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<a.length;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        
        for(int key:map.keySet()) {
        	if(map.get(key)>size/2)
        		return key;
        }
        return -1;
    }
}
