Problem : https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3872/
vedio  : youtube pepcoding 

class Solution {
    public int minCut(String s) {
        // aaaaba
         int l =  s.length();
        //memoization
//          boolean dp[][]  =  new boolean[l][l]; // to know which part of string is palindrome 
//         for(int gap=0;gap<l;gap++){
//             for(int i=0,j=gap;j<l;j++,i++){
//                 if(gap==0) dp[i][j] =  true;
//                 else if(gap==1) dp[i][j] =  s.charAt(i)==s.charAt(j)?true:false;
//                 else{
//                     if(s.charAt(i)==s.charAt(j)){
//                         dp[i][j] =  dp[i+1][j-1] ;
//                     }
                    
//                 }
//             }
//         }
//         int st[] =  new int[l];
//         Arrays.fill(st,-1);
//         return recursive(s,0,dp,st);
        return dp(s);
    }
    
    private int dp(String s){
        int l =  s.length();
       
          boolean dp[][]  =  new boolean[l][l]; // to know which part of string is palindrome 
        for(int gap=0;gap<l;gap++){
            for(int i=0,j=gap;j<l;j++,i++){
                if(gap==0) dp[i][j] =  true;
                else if(gap==1) dp[i][j] =  s.charAt(i)==s.charAt(j)?true:false;
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] =  dp[i+1][j-1] ;
                    }
                    
                }
            }
        }
        int st[] =  new int[l];
        st[0] = 0;
        for(int i=1;i<l;i++){
            if(dp[0][i]) {
                st[i]  = 0;
                continue; }
            int min  =  Integer.MAX_VALUE;
            for(int j=i;j>=1;j--){
                
                if(dp[j][i]){
                    min  = Math.min(st[j-1],min);
                }
                
            }
            st[i] =  min+1;
        }
    
        return st[l-1];
        
    }
    
    
    private int recursive(String s, int start,boolean dp[][],int st[] ){
        if(start>=s.length()) return -1;
        if(s.length()==0) return 0;
        if(st[start]!=-1) return st[start];
        Integer overallMin =  null;
        for(int i =  start;i<s.length();i++){
            if(dp[start][i]){
                    int min  =  recursive(s,i+1,dp,st);
                if(overallMin==null || overallMin>min){
                    overallMin  =  min;
                }
            }
            
            
        }
        return st[start] = overallMin+1;
        
        
    }
   
    
}
