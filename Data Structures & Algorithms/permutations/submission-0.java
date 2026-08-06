class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[]nums;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        used = new boolean[nums.length];
        backtracking(current);
        return result;
    }

    public void backtracking(List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int pointer = 0; pointer < nums.length; pointer++){
            if(used[pointer]){
                continue;
            }
            current.add(nums[pointer]);
            used[pointer] = true;
            backtracking(current);
            current.remove(current.size() - 1);
            used[pointer] = false;
        }
    }
}
