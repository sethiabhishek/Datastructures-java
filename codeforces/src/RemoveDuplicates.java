import java.util.*;

/**
 * Petya has an array 𝑎 consisting of 𝑛 integers. He wants to remove duplicate (equal) elements.
 *
 * Petya wants to leave only the rightmost entry (occurrence) for each element of the array. The relative order of the remaining unique elements should not be changed.
 *
 * Input
 * The first line contains a single integer 𝑛 (1≤𝑛≤50) — the number of elements in Petya's array.
 *
 * The following line contains a sequence 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤1000) — the Petya's array.
 *
 * Output
 * In the first line print integer 𝑥 — the number of elements which will be left in Petya's array after he removed the duplicates.
 *
 * In the second line print 𝑥 integers separated with a space — Petya's array after he removed the duplicates. For each unique element only the rightmost entry should be left.
 *
 * Examples
 * inputCopy
 * 6
 * 1 5 5 1 6 1
 * outputCopy
 * 3
 * 5 6 1
 * inputCopy
 * 5
 * 2 4 2 4 4
 * outputCopy
 * 2
 * 2 4
 * inputCopy
 * 5
 * 6 6 6 6 6
 * outputCopy
 * 1
 * 6
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<length;i++){
            arr[i] = sc.nextInt();
        }
        for(int j= length -1;j>=0;j--){
            boolean isAddded = s.add(arr[j]);
            if(!isAddded){
                arr[j] = 0;
            }
        }

        List<Integer> l = new ArrayList<>();
        for(int i: arr){
            if(i > 0){
                l.add(i);
            }
        }

        System.out.println(l.size());
        l.forEach(x -> System.out.print(x + " "));

    }
}
