class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int n=0;
        int total=0;
        for(int num:nums){
            n+=num;
            total+=map.getOrDefault(n-k,0);
            map.put(n,map.getOrDefault(n,0)+1);
        }
        return total;
    }
}