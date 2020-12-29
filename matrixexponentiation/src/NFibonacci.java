import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NFibonacci {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int toFind = 5;
        int num = retrievenFib(toFind);
    }

    private static int retrievenFib(int toFind) {
        Matrix fib = new Matrix(1,2);
        fib.initialize();
        fib.print();

        Matrix tMat = new Matrix(2,2);
        tMat.initialize();
        tMat.print();


        Matrix nPow = calculateExponentiation(tMat,toFind -1);

        return 0;

    }

    private static Matrix calculateExponentiation(Matrix tMat,int value) {
        if(value == 0){
            return tMat;
        }

        int

    }


}

class Matrix {
    private int cols;
    private int rows;
    private int[][] mat;

    public Matrix(int col, int row) {
        this.cols = col;
        this.rows = row;
    }

    public void initialize(){
        this.mat = new int[rows][cols];
        Scanner sc = new Scanner(System.in);
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                mat[i][j] = sc.nextInt();
            }
        }

    }

    public int[][] multiply(Matrix m){
        int[][] result = new int[rows][m.cols];
        for(int i =0;i< this.rows;i++){
            for(int j = 0 ; j<m.cols;j++){
                for(int k=0 ; k< this.cols ; k++){
                    result[i][j] += mat[i][k] * m.mat[k][j];
                }
            }
        }
        return result;
    }

    public void print(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println("");
        }
    }

}
