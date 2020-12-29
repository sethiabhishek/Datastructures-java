public class MinPathSum {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,1},{4,5,1},{4,2,1}};
        int minPath = findMinPath(arr);
        int minPathRecursive = findRecursiveWay(0,0,arr);
        System.out.println(minPath);
        System.out.println(minPathRecursive);
    }

    private static int findRecursiveWay(int i, int j, int[][] arr) {
        if(i == arr.length -1 && j == arr[0].length -1)
            return arr[i][j];
        if(i > arr.length -1 || j > arr[0].length -1)
            return Integer.MAX_VALUE;
        int right = findRecursiveWay(i,j+1,arr);
        int  down = findRecursiveWay(i+1,j,arr);
        return arr[i][j] + Math.min( right,down);
    }

    private static int findMinPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][] dp= new int[arr.length][arr[0].length];
        dp[m-1][n-1] = arr[m-1][n-1];
        //populate the values in the last column
        for(int i= m-2; i>=0;i--){
            dp[i][n-1] = arr[i][n-1] + dp[i+1][n-1];
        }

        //populating for the last row
        for(int i=n-2;i>=0;i--){
            dp[m-1][i] = arr[m-1][i] + dp[m-1][i+1];

        }

        //populating for rest of the cells
        for(int i = m-2;i>=0 ;i--){
            for(int j = n-2;j>=0;j--){
                dp[i][j] = arr[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
