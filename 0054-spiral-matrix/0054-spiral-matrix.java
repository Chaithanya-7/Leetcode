class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        //rows 
        int n = matrix.length;
        //columns starts from 0
        int m = matrix[0].length;

        int top=0,left=0;
        int bottom = n-1,right = m-1;

        //traversing in spiral spiralOrder
        while(top <= bottom && left<=right){
            //right --> left to right
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);//i is constant here
            }
            top++;
            //top to bottom 
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);//right is constant here
            }
            right--;
            //right to left
            if(top <= bottom){//it ensures if there was one row left will not be printed
                for(int i = right;i>=left;i--){
                    ans.add(matrix[bottom][i]);//bottom is constant
                }
                bottom--;
            }
            //bottom to left
            if(left <= right){//when theres no top means in last spiral there was no top 
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);//left is constant
                }
                left++; //++ because it moves next spiral to print like 20-->21 next to it so left++.
            }
        }
        return ans;
    }
}