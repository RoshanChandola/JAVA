//question link: https://leetcode.com/problems/find-duplicates-in-an-array/ id: 442
import java.util.*;
class Findduplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index=Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,4};
        Findduplicates fd = new Findduplicates();   
        List<Integer> result = fd.findDuplicates(nums);
        System.out.println("Duplicates in the array: " + result);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
//dry run
// Input: nums = [4,3,2,3,4]
// Output: [3]
// Explanation: 3 is the only number that appears twice in the array.
// Initially, ans = []
// i = 0: index = |4| - 1 = 3; nums[3] = 3 (not negative), so set nums[3] = -nums[3] => nums = [4,3,2,-3]
// i = 1: index = |3| - 1 = 2; nums[2] = 2 (not negative), so set nums[2] = -nums[2] => nums = [4,3,-2,-3]
// i = 2: index = | -2| - 1 = 1; nums[1] = 3 (not negative), so set nums[1] = -nums[1] => nums = [4,-3,-2,-3]
// i = 3: index = | -3| - 1 = 2; nums[2] = -2 (negative), so add 2 + 1 = 3 to ans => ans = [3]
// i = 4: index = |4|-1=3; nums[3]= -3(negative), so add 3+1=4 to ans => ans=[3,4]
// Final ans = [3,4]

