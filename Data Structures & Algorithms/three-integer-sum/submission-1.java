class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int left = 0 ; left < nums.length - 2; left++){
            if(left > 0 && nums[left] == nums[left -1]){
                continue;
            }
            int mid = left + 1;
            int right = nums.length - 1;
            while(mid < right){
                List<Integer> current = new ArrayList<>();
                int sum = nums[left] + nums[mid] + nums[right];
                if(sum == 0){
                    current.add(nums[left]);
                    current.add(nums[mid]);
                    current.add(nums[right]);
                    res.add(current);
                    mid++;
                    right--;
                    while(mid < right && nums[mid] == nums[mid - 1]){
                        mid++;
                    }
                    while(mid < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(sum > 0){
                    right--;
                }else{
                    mid++;
                }
            }
        }
        return res;
    }
}
