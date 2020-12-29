import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of kadane's algorithm
 */

public class MaxSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{10,-10,-5,18,1,-2};
        int curr_sum = arr[0];
        int global_sum = arr[0];
        List subarray = new ArrayList();
        subarray.add(arr[0]);
        boolean isAdded = false;
        for(int i=1;i<arr.length;i++){
            isAdded = false;
            int temp = curr_sum + arr[i];
            if(temp > arr[i]){
                curr_sum = temp;
            }else{
                curr_sum = arr[i];
                subarray.clear();
                isAdded = true;
                subarray.add(arr[i]);
            }
            if(curr_sum > global_sum){
                if(!isAdded){
                    subarray.add(arr[i]);
                }
                global_sum = curr_sum;
            }

        }
        System.out.print("max sub sum is :"+global_sum+ " and max array is:"+subarray);
    }


}
