//question url: https://leetcode.com/problems/find-peak-element-ii/description/ question number:852
public class MountainPeek {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end= nums.length-1;
        while(start<end)
        {
            int mid= start+(end-start)/2;
            if(nums[mid]>nums[mid+1])
            {
                end=mid;// it might be the peak element but we need to see at left side also
            }
            else
            {
                start=mid+1;// becuase mid+1 is greater than mid thus mid cannot be peak
            }
        }
        return start;
    }
    public static void main(String[] args) {
        MountainPeek mp = new MountainPeek();
        int nums[] = {1,4,2,14,12,11,10,8,7,6,4};
        int peakIndex = mp.findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}
