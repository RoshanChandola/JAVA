// https://leetcode.com/problems/find-in-mountain-array/description/ question number:1095
public class SearchMountain {
 public static int findInMountainArray(int target, int[] mountainArr) {
        int peak= findPeak(mountainArr);
        int firsttry= orderAgnosticBS(mountainArr,target,0,peak);
        if(firsttry!=-1)
        {
            return firsttry;
        }
        return orderAgnosticBS(mountainArr,target,peak+1,mountainArr.length-1);
    }
    static int findPeak(int arr[])
    {
        int start=0;
        int end= arr.length-1;
        while(start<end)
        {
            int mid= start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
            {
                end=mid;
            }
            else
            {
                start=mid+1;
            }
        }
        return start;
    }
    static int orderAgnosticBS(int arr[],int target,int start,int end)
    {
        boolean isAsc= arr[start]<arr[end];
        while(start<=end)
        {
            int mid= start+(end-start)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            if(isAsc)
            {
                if(target<arr[mid])
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            else
            {
                if(target>arr[mid])
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
        }
        return -1;
    }   
}
