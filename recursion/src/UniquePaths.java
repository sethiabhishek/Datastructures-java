public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] arr = new int[m][n];
        int uniquePaths = findUniquePaths(arr,0,0);
        int paths  = uniquePaths(arr);
        System.out.println(paths);
    }

    private static int uniquePaths(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        //for last column
        for(int i=0;i<=m-2;i++){
            dp[i][n-1] = 1;
        }

        //for last row
        for(int i=0;i<=n-2;i++){
            dp[m-1][i] = 1;
        }
        //for other parts of the grid
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }

        return dp[0][0];
    }

    private static int findUniquePaths(int[][] arr, int i, int j) {
        if(i > arr.length -1 || j > arr[0].length -1)
            return 0;
        if(i == arr.length -1 && j == arr[0].length -1)
            return 1;
        int path1 = findUniquePaths(arr,i+1,j);
        int path2 = findUniquePaths(arr,i,j+1);
        return path1 + path2;
    }
}
