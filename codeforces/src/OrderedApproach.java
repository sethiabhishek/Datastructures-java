import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderedApproach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();
        while(tests > 0){
            int  numbers = sc.nextInt();
            List<Integer> solution = new ArrayList<>(numbers/2);

            List<Integer> complete = new ArrayList<>(numbers);
            for(int i= 0;i< numbers;i++){
                complete.add(sc.nextInt());
            }
            int left = 0;
            int right = numbers -1;
            for(int i = 0; i< numbers; i++){
                if(i%2 == 0 && left <= numbers/2 - 1){
                    solution.add(complete.get(left));
                    left ++;
                }else{
                    solution.add(complete.get(right));
                    right --;
                }
            }

            for(int x: solution){
                System.out.print(x + " ");
            }
            System.out.println();
            tests--;
        }
    }

}
