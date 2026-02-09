class CyclicSort {
    public static void main(String[] args) {
        CyclicSort cs = new CyclicSort();
        int nums[] = {2,2,1,4};
        cs.cyclicSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}