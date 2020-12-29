import static jdk.nashorn.internal.objects.Global.print;

/**
 * print 53124 on console
 */
public class PDISkip {
    public static void main(String[] args) {
        int n = 5;
        printSkip(n);
    }

    private static void printSkip(int n) {
        if(n < 0)
            return;
        System.out.println(n);
        printSkip(n-2);
        if(n == 5)
            return;
        System.out.println(n+1);
    }
}
