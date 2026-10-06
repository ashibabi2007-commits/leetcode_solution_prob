class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int complement=target-num;
            if (map.containsKey(complement)){
                return new int[]{ map.get(complement), i };
            }
            map.put(num,i);
        }
        return new int[]{};
    }
}