// https://leetcode.com/problems/first-missing-positive/description/id=41
//description: Given an unsorted integer array nums, return the smallest missing positive integer.
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            
            int correctIndex = nums[i] - 1;
            if (nums[i]>0 && nums [i]<=nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
            
         
        }

        for (int index = 0; index < nums.length; index++) 
        {
            if (nums[index] != index + 1) {
                return index+1;
            }
        }
        return nums.length+1;
    }
    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = {0,1,7,5,2,3};
        int result = s.firstMissingPositive(nums);
        System.out.println("First Missing Positive: " + result);
    }
}
