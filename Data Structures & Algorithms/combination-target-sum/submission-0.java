class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtracking(0,target, 0, current);
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
        for(int pointer = index; pointer < nums.length; pointer++){
            current.add(nums[pointer]);
            backtracking(pointer, target, sum + nums[pointer], current);
            current.remove(current.size() - 1);
        }
    }
}
