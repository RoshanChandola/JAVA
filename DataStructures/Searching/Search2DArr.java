public class Search2DArr {
    static int[] searchMatrix(int[][]arr, int target)
    {
        if(arr.length==0){
            return new int[]{-1, -1};
        }
        for(int i=0;i<arr.length;i++){{
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==target){
                    return new int[]{i, j};
                }
            }
        }}
        return new int[]{-1, -1};
    }
   
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 3;
        int[] found = searchMatrix(matrix, target);
        System.out.println("Target found at: [" + found[0] + ", " + found[1] + "]");
    }
}

