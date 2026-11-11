class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Option 1: Buy only single items
        long a = (long) need1 * cost1 + (long) need2 * cost2;
        
        // Option 2: Buy only bundle items (Type 3)
        long b = (long) Math.max(need1, need2) * costBoth;
        
        // Option 3: Buy minimum overlapping requirements using bundles, and remainder with singles
        int mn = Math.min(need1, need2);
        long c = (long) mn * costBoth + (long) (need1 - mn) * cost1 + (long) (need2 - mn) * cost2;
        
        return Math.min(a, Math.min(b, c));
    }
}
