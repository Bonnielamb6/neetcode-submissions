class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        List<Integer> current = new ArrayList<>();
        backtracking(0,target,0,current);
        return result;
    }

    public void backtracking(int index, int target, int sum, List<Integer> current){
        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(sum > target){
            return;
        }
        for(int pointer = index ; pointer < candidates.length; pointer++){
            if(pointer > index && candidates[pointer] == candidates[pointer - 1])
                continue;
            current.add(candidates[pointer]);
            backtracking(pointer + 1, target, sum + candidates[pointer],current);
            current.remove(current.size() - 1);
        }
    }
}
