// leetcode 503. Next Greater Element II link: https://leetcode.com/problems/next-greater-element-ii/
import java.util.Stack;

public class NGE2 {
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        Stack<Integer> st = new Stack<>();

         for(int i = 2*n-1; i >= 0; i--)
        {
            int curr = nums[i%n];

            while(!st.isEmpty() && st.peek() <= curr )
            {
                st.pop();
            }
            result[i%n] = st.isEmpty() ? -1 : st.peek();
            st.push(curr);
        }
       
       
        return result;
    }
    public static void main(String []args)
    {
        int nums[]  = {1,2,1};
        int result[] = solution(nums);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
