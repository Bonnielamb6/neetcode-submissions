class Solution {
    int[] nums;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtracking(0,current);
        return result;
    }

    public void backtracking(int index, List<Integer> current){
        result.add(new ArrayList<>(current));
        for( int pointer = index; pointer < nums.length; pointer++){
            if(pointer > index && nums[pointer] == nums[pointer - 1]){
                continue;
            }
            current.add(nums[pointer]);
            backtracking(pointer + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
