import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number
 * {1, 4, 20, 3, 10, 5}
 */

/**
 * Create prefix sum array
 * check sum -k in the hashtable if yes then increase the answer by the value corresponding to the key
 * make an entry in the hashtable by sum -> count+1
 *
 * check prefix sum algorithm for more information
 */
public class LongestSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 20, 3, 10, 5};

        int sum = 0;
        int k = 5;
        int ans = 0;
        Map<Integer,Tuple> m = new HashMap();
        Tuple t = new Tuple();
        t.getIndex().add(-1);
        t.setCount(1);

        m.put(0,t);
        for(int i =0 ;i <arr.length;i++){
            sum += arr[i];
            Tuple val = m.getOrDefault((sum - k),null);
            if(val != null){
                ans += val.getCount();
                printSubsequence(val.getIndex(),i,arr);
            }
            Tuple currentFreq = m.getOrDefault(sum,null);
            if(currentFreq != null){
                currentFreq.getIndex().add(i);
                currentFreq.setCount(currentFreq.getCount() + 1);
            }else{
                t = new Tuple();
                t.setCount(1);
                t.getIndex().add(i);
                m.put(sum ,t);
            }

        }
        System.out.println("number of subarray :- "+ans);

    }

    private static void printSubsequence(List<Integer> index,int endIndex,int[] arr) {
        for(int i:index){
            int start = 0;
            if( i > -1){
                 start = i+1;
            }
            for(int j= start;j<=endIndex;j++){
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
}

class Tuple{
    List<Integer> index = new ArrayList<>();
    int count;

    public List<Integer> getIndex() {
        return index;
    }

    public void setIndex(List<Integer> index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
