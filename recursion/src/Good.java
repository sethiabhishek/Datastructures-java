import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Good {

    public static void main(String[] args) throws Exception {
        //List<String> allSubList = getBoardPath(10);
        int[][] arr = new int[4][4];
        //List paths = printMazePaths(0,0,arr);
       //printPermutations("abc","");
       //printSubsequences("abc","");
        boolean[][] board = new boolean[4][4];
       System.out.println(countNQueens(board,0));
        printNQueens(board,0);
    }

    /**
     * Get all subsequences of a string
     * @param str
     * @return
     */
    private static List<String> getAllSubSequences(String str) {
        if(str.length() == 0){
            List<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }
        String first = str.substring(0,1);
        List<String> subSequenceList = getAllSubSequences(str.substring(1));
        List<String> toReturn = new ArrayList<>();
        for(String s : subSequenceList){
            toReturn.add(s);
            toReturn.add(first+s);
        }
        return toReturn;
    }

    /**
     * Get all permutations of a string
     * @param str
     * @return
     */
    private static List<String> getPermutations(String str) {
        if(str.length() == 0){
            List<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }
        String first = str.substring(0,1);
        String rest =  str.substring(1);
        List<String> restP = getPermutations(rest);
        List<String> toReturn = new ArrayList<>();
        for(String s :restP){
            for(int i = 0;i<=s.length();i++){
                String rrs = s.substring(0,i) + first + s.substring(i);
                toReturn.add(rrs);
            }
        }

        return toReturn;
    }

    /**
     * Given a number to reach on a board game and a dice,
     * find all the combinations to reach there
     * @param num
     * @return
     */
    private static List<String> getBoardPath(int num) {
        if(num == 0){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> possiblePaths = new ArrayList<>();
        for(int i =1; i<=6;i++){
            int difference = num -i;

            if(difference >= 0 ){
                List<String> rcPaths = getBoardPath(num -i);
                for(String path: rcPaths){
                    String pathFound = i + path;
                    possiblePaths.add(pathFound);
                }
            }

        }
        return possiblePaths;

    }

    /**
     * code to find number of maze paths
     * @param row
     * @param col
     * @return
     */
    private static int numPath(int row,int col,int[][] arr){
        if(row == arr.length-1 && col == arr[0].length -1){
            return 1;
        }
        if(row > arr.length-1 || col > arr[0].length-1){
            return 0;
        }
        int hpaths = numPath(row,col+1,arr);
        int vpaths = numPath(row + 1,col,arr);
        return hpaths + vpaths;
    }

    /**
     * Print all the paths to reach the end point in the maze
     * @param row
     * @param col
     * @param arr
     * @return
     */

    private static List<String> printMazePaths(int row, int col, int[][] arr){
        if(row == arr.length-1 && col == arr[0].length -1){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if(row > arr.length-1 || col > arr[0].length-1){
            return new ArrayList<>();
        }

        List<String> hpaths = printMazePaths(row,col+1,arr);
        List<String>  finalHPaths = hpaths.stream().map(p -> {
            return "H" + p;
        }).collect(Collectors.toList());

        List<String> vpaths = printMazePaths(row+1,col,arr);
        List<String>  finalVPaths = vpaths.stream().map(p -> {
            return "V" + p;
        }).collect(Collectors.toList());

        finalHPaths.addAll(finalVPaths);
        return finalHPaths;
    }

    /**
     * print permutation of a string without using arraylist
     */
    private static void printPermutations(String str,String result) {
        if(str.length() == 0){
            System.out.println(result);
            return;
        }
        String first = str.substring(0,1);
        String ros = str.substring(1);
        for(int i = 0;i<=result.length();i++){
            String newResult = result.substring(0,i) + first + result.substring(i);
            printPermutations(ros,newResult);
        }
    }

    /**
     * Print subsequences without using arraylist and use recursion
     * @param str
     * @param result
     */
    private static void printSubsequences(String str,String result) {
        if(str.length() == 0){
            System.out.println(result);
            return;
        }

        String first = str.substring(0,1);
        String ros = str.substring(1);
        printSubsequences(ros,result);
        printSubsequences(ros,result + first);

    }

    /**
     * count number of ways to keep n queens on nxn board
     * @param arr
     * @param row
     * @return
     */
    private static int  countNQueens(boolean[][] arr, int row) {
        int count = 0;
        if(row == arr.length){
            return 1;
        }
        for(int col = 0;col <= arr.length -1 ; col ++){
            if(isSafe(arr,row,col)){
                arr[row][col] = true;
                count  = count + countNQueens(arr,row+ 1);
                arr[row][col] = false;
            }
        }

        return count;

    }

    private static boolean isSafe(boolean[][] arr, int row, int col) {
        for(int r= 0; r < row ; r ++){
            if(arr[r][col]){
                return false;
            }
        }


        for(int r = row -1,c = col -1 ;r >= 0 && c >= 0;r --,c --){
            if(arr[r][c]){
                return  false;
            }
        }


        for(int r = row -1,c = col+1 ;r >= 0 && c <=arr[0].length-1;r--,c ++){
            if(arr[r][c]){
                return false;
            }
        }

        return true;

    }

    /**
     * Print n queens board configurations
     * @param arr
     * @param row
     */
    private static void  printNQueens(boolean[][] arr, int row) {

        if(row == arr.length){
            System.out.println("--------------------------");
            display(arr);
            System.out.println("--------------------------");
            return ;
        }
        for(int col = 0;col <= arr.length -1 ; col ++){
            if(isSafe(arr,row,col)){
                arr[row][col] = true;
                printNQueens(arr,row+ 1);
                arr[row][col] = false;
            }
        }

    }

    private static void display(boolean[][] arr) {
        for(int r=0;r<arr.length;r++){
            for(int c = 0;c< arr[0].length;c++){
                if(arr[r][c]){
                    System.out.print( "Q" + " ");
                }else{
                    System.out.print( "B" + " ");
                }

            }
            System.out.println();
        }
    }
}
