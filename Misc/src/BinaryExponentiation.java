public class BinaryExponentiation {

    public static void main(String[] args) {
        int n = 3;
        int x = 5;
        int res = 1;
        while(n>0){
            if(n % 2 !=0){
                res = res * x;
            }
            x = x * x;
            n /= 2;

        }
        System.out.print(res);

    }
}
