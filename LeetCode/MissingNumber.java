//leetcode/MissingNumber.java : url=https://leetcode.com/problems/missing-number/id =268
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}
//using cyclic sort
// class MissingNumberCyclicSort {
//     public int missingNumber(int[] nums) {
//         int i = 0;
//         int n = nums.length;
//         while (i < n) {
//             if (nums[i] < n && nums[i] != nums[nums[i]]) {
//                 swap(nums, i, nums[i]);
//             } else {
//                 i++;
//             }
//         }
//         for (i = 0; i < n; i++) {
//             if (nums[i] != i) {
//                 return i;
//             }
//         }
//         return n;
//     }

//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }