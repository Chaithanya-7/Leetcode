class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n=numRows;
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int row =1;row<=n;row++){
            long ans=1;
            List<Integer> ansRow = new ArrayList<>();

            ansRow.add(1);

            for(int col=1;col<row;col++){
                ans = ans*(row-col);
                ans = ans/col;
                ansRow.add((int) ans);
            }
            pascalTriangle.add(ansRow);
        }
        return pascalTriangle;
    }
}