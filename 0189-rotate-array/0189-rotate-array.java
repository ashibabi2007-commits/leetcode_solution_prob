class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        back(nums,0,n-1);
        back(nums,0,k-1);
        back(nums,k,n-1);
    }
    public void back(int[] nums,int left,int right){
        while(left<right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        left++;
        right--;
        }
    }
}