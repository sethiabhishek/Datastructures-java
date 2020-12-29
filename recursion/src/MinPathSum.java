import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,1},{4,5,1},{4,2,1}};
        int minPath = findMinimum(0,0,arr);
        System.out.print(minPath);
    }

    private static int findMinimum(int i, int j, int[][] arr) {
        if( i >2 || j > 2){
            return Integer.MAX_VALUE;
        }
        if(i ==2 && j ==2){
            return arr[i][j];
        }
        int pathVal = arr[i][j];
        int right = findMinimum(i,j+1,arr);
        int down = findMinimum(i+1,j,arr);

        return pathVal + Math.min(right,down);

    }
}
