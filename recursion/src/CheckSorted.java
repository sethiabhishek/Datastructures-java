/**
 * check whether array is sorted or not
 */
public class CheckSorted {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,7,9,10};
        boolean isSorted = checkSorted(arr,0);
        System.out.print(isSorted);
    }

    private static boolean checkSorted(int[] arr, int initial) {
        if(initial == arr.length -1)
            return true;
        if(arr[initial] > arr[initial + 1])
            return false;
        return checkSorted(arr,initial +1);
    }
}
