class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtracking(0, current);
        return result;
    }

    public void backtracking(int index, List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int i = index ; i < nums.length; i++){
            current.add(nums[i]);
            backtracking(i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
