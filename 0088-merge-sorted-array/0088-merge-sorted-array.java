class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr=new int[m+n];
        for (int i=0;i<m;i++){
            arr[i]=nums1[i];
        }
        for(int j=0;j<n;j++){
            arr[m+j]=nums2[j];
            
        }
        Arrays.sort(arr);
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }
}