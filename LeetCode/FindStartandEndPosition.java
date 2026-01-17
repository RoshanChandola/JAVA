public class FindStartandEndPosition {
    public int[] searchRange(int[] nums, int target) {
        
        int ans[]={-1,-1};
        int first=search(nums,target,true);
        int last=search(nums,target,false);
        ans[0]=first;
        ans[1]=last;
        return ans;
    }
    public int search(int []nums, int target,boolean findfirst)
    {
        int ans=-1;
        int start=0;
        int end= nums.length-1;
         while(start<=end)
        {   
            int mid= start+(end-start)/2;
            if(nums[mid]==target)
            {
                ans=mid;

                    if(findfirst)
                    {
                        end=mid-1;
                    }
                    else
                    {
                        start=mid+1;
                    }
                
            }
            else if(target>nums[mid])
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        FindStartandEndPosition fs = new FindStartandEndPosition();
        int nums[] = {5,7,7,8,8,8,8,8,10};
        int target = 8;
        int result[] = fs.searchRange(nums, target);
        System.out.println("Start and End positions: [" + result[0] + ", " + result[1] + "]");
    }
} 
    

