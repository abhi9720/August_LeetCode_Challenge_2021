https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3837/

Discussion : https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans  =  new ArrayList<>();
        List<Integer> temp =  new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,ans,temp,0);
        
        return ans;
        
    }
    
    private void helper(int nums[], List<List<Integer>> ans , List<Integer> temp , int index ){
            
       ans.add(new ArrayList(temp));
        for(int start  =  index ;start<nums.length;start++ ){ // all subarray starting from index start
            if(start>index && nums[start]==nums[start-1]) continue;
            temp.add(nums[start]);
            helper(nums,ans,temp,start+1);
            temp.remove(temp.size()-1);            
        }
     
        
        
        
        
    }
    
}