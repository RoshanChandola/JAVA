public class binarySearchLoop {
    static void binarySearch(int []nums, int start, int end, int target)
    {
        while(start <= end)
        {
            int mid = start + (end-start) / 2;
            if(nums[mid] == target)
            {
                System.out.println("Element found at index: "+mid);
                return;     
            }   
            else if(target < nums[mid])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        System.out.println("Element not found");
    }
    public static void main(String[] args) {
        int []nums = {-10,20,30,40,50};
        int target = 20;
        int start = 0;
        int end = nums.length - 1;
        binarySearch(nums,start,end,target);
    }
}
