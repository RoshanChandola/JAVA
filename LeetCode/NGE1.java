// leetcode question 496: Next Greater Element1 link: https://leetcode.com/problems/next-greater-element-i/

import java.util.HashMap;
import java.util.Stack;

public class NGE1{
    public static int[] solution(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = nums1.length;
        int result[] = new int[n];  

        for(int i = 0; i < n; i++)
        {
            map.put(nums1[i],i);
            result[i]= -1;

        }

        for(int i = nums2.length-1; i >= 0; i--)
        {
            int curr = nums2[i];

            while(!st.isEmpty() && st.peek() <= curr )
            {
                st.pop();
            }
            if(map.containsKey(curr))
            {
                result[map.get(curr)] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(curr);
        }
         

        return result;
    }
    public static void main(String []args)
    {
        int nums1[]  = {4,1,2};
        int nums2[] = {1,3,4,2};
        int result[] = solution(nums1, nums2);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
