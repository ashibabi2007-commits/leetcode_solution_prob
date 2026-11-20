class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int total=0;
        int target=tickets[k];
        for(int i=0;i<tickets.length;i++){
            if(i<=k){
                total+=Math.min(tickets[i],target);
            }
            else{
                total+=Math.min(tickets[i],target-1);
            }
        }
        return total;
    }
}