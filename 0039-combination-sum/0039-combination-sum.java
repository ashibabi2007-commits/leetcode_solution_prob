class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    public void backtrack(int[] candidates,int remain,int start,List<Integer> path,List<List<Integer>> result){
        if(remain==0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>remain){
                break;
            }
            path.add(candidates[i]);
            backtrack(candidates,remain-candidates[i],i,path,result);
            path.remove(path.size()-1);
        }
    }
}