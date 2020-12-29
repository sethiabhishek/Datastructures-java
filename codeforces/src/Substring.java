import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Substring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while(tests >0){
            int length = sc.nextInt();
            List<Integer> list = new ArrayList<>(length);
            String input = sc.next();
            for(char c : input.toCharArray()) {
                list.add(Integer.valueOf(c));

            }
            if(list.size() < 4){
                System.out.print("No");
            }
            boolean condition = list.get(0) == 2 && list.get(1) == 0 && list.get(length -2) == 2 && list.get(length -1) == 0;
            List<Integer> right = list.subList(length -4,length);
            String str = right.stream().map(s -> String.valueOf(s)).collect(Collectors.joining());
            boolean condition2 = str.equalsIgnoreCase("2020");

            boolean condition3 = list.get(0) == 2  && list.get(1) !=0 && list.get(length -3) == 0 && list.get(length -2) == 2 && list.get(length -1) == 0;

            if(list.size() >= 4){
                right = list.subList(0,4);
            }else{
                right = new ArrayList<>(4);
            }

            str  = right.stream().map(s -> String.valueOf(s)).collect(Collectors.joining());
            boolean condition4 = str.equalsIgnoreCase("2020");

            right = list.subList(0,3);
            str  = right.stream().map(s -> String.valueOf(s)).collect(Collectors.joining());
            boolean condition5 = str.equalsIgnoreCase("202") && list.get(length -1) == 0;

            if(condition2 || condition || condition3 || condition4 || condition5)
                System.out.print("Yes");
            else
                System.out.print("NO");

            tests --;
        }
    }
}
