class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int current=0;
        int diff=0;
        int total=0;
        for(int i=0;i<gas.length;i++){
            diff=gas[i]-cost[i]; 
            total+=diff;
            current+=diff;
            if(current<0){
                start=i+1;
                current=0;
            }
        }
        return total>=0?start:-1;
    }
}