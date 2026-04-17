class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(max, product);

            if (product == 0) {
                product = 1;
            }
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);

            if (product == 0) {
                product = 1;
            }
        }

        return max;
    }
}
class MaximumSubArrayP {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2, 4};
        int result = solution.maxProduct(nums);
        System.out.println(result); // Output: 6
    }
}

// how this is working lets break it down  : first we are initializing max to the smallest possible integer value and product to 1. Then we iterate through the array from left to right, multiplying each element with the product variable. We update max with the maximum value between max and product. If product becomes zero, we reset it to 1 because a zero would break the product chain.
// After the first loop, we reset product to 1 and iterate through the array from right to left, performing the same operations. This is necessary because a negative number can turn a small product into a large one if it is multiplied by another negative number. Finally, we return the maximum product found.

/*class Solution {
    public int maxProduct(int[] nums) {
        int maxp = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            int  max = 1;
            for(int j = i; j < nums.length; j++)
            {
                max = nums[j] * max;
                maxp = Math.max(maxp , max);
            }
            
        }
        return maxp;
    }
} */

    //another one 