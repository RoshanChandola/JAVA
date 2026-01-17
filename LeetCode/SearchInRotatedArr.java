//question link: https://leetcode.com/problems/search-in-rotated-sorted-array/ question id: 33
public class SearchInRotatedArr {
    public static  int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the start half is sorted
            if (nums[start] <= nums[mid]) {
                // Target is in the start half
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else { // Target is in the end half
                    start = mid + 1;
                }
            } else { // end half is sorted
                // Target is in the end half
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else { // Target is in the start half
                    end = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }
    public static void main(String[] args) {
        int[] nums = {23,23,46,76,89,2,2,6,12,12,15,19};
        int target = 15;
        int result = search(nums, target);
        System.out.println("Target found at index: " + result);
    }
}
//dry run
// nums = [23,46,76,89,2,6,12,15,19], target = 15
// start = 0, end = 8
// mid = 4, nums[mid] = 2
// start half is sorted (23 to 89)
// target is in the end half, so start = mid + 1 = 5
// start = 5, end = 8
// mid = 6, nums[mid] = 12
// end half is sorted (12 to 19)
// target is in the end half, so start = mid + 1 = 7
// start = 7, end = 8
// mid = 7, nums[mid] = 15
// nums[mid] == target, return mid = 7
// Time Complexity: O(log n)
// Space Complexity: O(1)

