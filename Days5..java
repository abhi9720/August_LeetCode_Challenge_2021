problem : https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3870/

Approch 1: Simply return true or calculate even index and odd index element sum if odd index element sum!=even index element sum then always alex will

class Solution {
    public boolean stoneGame(int[] piles) {
        
        int even  =0,n = piles.length;
        int odd = 0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                even  +=  piles[i];                
            }
            else{
                odd  +=  piles[i];
            }            
        }
     
        return even!=odd;
        
    }
}


Approch 2: Using Dynamic programming 
tips:  when chance come to do your best and when result comes from opponent always expect wrost , 


/* Discussion 
        
                  (i,j)
        alex    /       \    alex 1st
             (i+1,j)      (i,j-1) 
        lee  /     \     /        \     // second lee 
            /       \    (i+1,j-1) \
        (i+2,j)      \              \           // 3rd lee 
                   (i+1,j-1)         (i,j-2)
                            
    
alex  = max(piles[i] + [(i+2,j),(i+1,j-1)] , piles[j] +  [(i+1,j-1) , (i+1,j-2)] )
                     here we have to answer only true and false 
                     simply take or operation 
                     
*/

class Solution {
    public boolean stoneGame(int[] piles) {
        
        // return true
        // or return(odd index num sum) != (even index num sum)
        
        //simply return true 
        // either alex can pick always even index piles or
        // odd index piles     
       // all possible subarray
        // dp[i][j] -  means is alex with if array is from i to j index 
        boolean dp[][] =  new boolean[piles.length][piles.length];
       for(int gap=0;gap<piles.length;gap++){
           for(int i=0,j=gap;j<piles.length;i++,j++){
               if(gap==0 || gap==1 ) dp[i][j] =  true;
               else{
                   // either go for     
                   dp[i][j] =  dp[i+2][j] || dp[i+1][j-1] || dp[i][j-2];                 
               }               
           }
       }
        return dp[0][piles.length-1];
       
    }
}

