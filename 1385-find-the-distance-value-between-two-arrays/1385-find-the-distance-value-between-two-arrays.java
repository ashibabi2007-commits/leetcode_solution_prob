import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        Arrays.sort(arr2);
        
        for (int a : arr1) {
            int i = Arrays.binarySearch(arr2, a);
            // If exact match isn't found, binarySearch returns (-(insertion point) - 1)
            i = i < 0 ? -i - 1 : i;
            
            // Check if both the successor (if exists) and predecessor (if exists) are > d away
            boolean validNext = (i == arr2.length || arr2[i] - a > d);
            boolean validPrev = (i == 0 || a - arr2[i - 1] > d);
            
            if (validNext && validPrev) {
                ans++;
            }
        }
        
        return ans;
    }
}