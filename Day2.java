problem : https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3836/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map  =  new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            
            
            if(map.containsKey(target -  nums[i] ) && (i!=map.get(target-nums[i])) ) {
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[]{-1,-1};
    }
}