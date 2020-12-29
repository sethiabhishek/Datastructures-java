import java.util.ArrayList;
import java.util.Scanner;

/**
 * simple use case of how to use frequency array to find out the missing number
 */
public class MissingNumber {

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int elements = sc.nextInt();
        int[] arr = new int[elements];
        for(int i=0;i<elements;i++){
            arr[i] = sc.nextInt();
        }
        int[] freq = new int[elements+1];
        for(int i=0;i<elements;i++){
            freq[arr[i]]++;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<elements + 1;i++){
            if(freq[i] == 0){
                arrayList.add(i);
            }
        }
        System.out.println(arrayList);

    }
}
