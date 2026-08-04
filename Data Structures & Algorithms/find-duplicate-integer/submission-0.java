class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        int firstPointer = 0;
        int secondPointer = slow;
        while(firstPointer != secondPointer){
            firstPointer = nums[firstPointer];
            secondPointer = nums[secondPointer];
        }
        return firstPointer;
    }
}
