package Basics;

class Solution{
    
    // Function to check if given number n is a power of two.
    public static void isPowerofTwo(long n){
        
        // Your code here
        
        
        int k = 1;
        while(n>2)
        {
        	n = n/2;
        	k++;
        	
            
        }
        System.out.println(k);
        
        
    }
    
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int n = 8;
        s.isPowerofTwo(n);
    }
    
}