// 2219. Robot Collisions
// https://leetcode.com/problems/robot-collisions/
import java.util.*;
import java.util.Stack;
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Stack<Integer> stack = new Stack<>();

         Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));// idices array ko positions ke hisab se sort kar diya, taki hum robots ko unke positions ke hisab se process kar sakein.ex positions = [3,5,2,6] hai to indices array ko sort karne ke baad [2,0,1,3] ho jayega kyunki positions[2] < positions[0] < positions[1] < positions[3]
        //  Arrays.sort(indices,(i,j)->positions[i]-positions[j]);   // 

        List<Integer> result = new ArrayList<>();
        
        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }

}
class RobotCollison {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        
        List<Integer> survivedHealths = solution.survivedRobotsHealths(positions, healths, directions);
        System.out.println(survivedHealths); // Output: [9, 9]
    }
}

