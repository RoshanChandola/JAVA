//brute force approach
public class RotateArray {
    public int [] rotatearray(int[]nums, int k)
    {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than n
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5}; 
        int k = 2;
        int[] rotatedArray = r.rotatearray(nums, k); // output: [4, 5, 1, 2, 3]
        System.out.print("Rotated Array: ");
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }
}
