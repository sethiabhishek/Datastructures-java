/**
 * check the first occurence of the number if not present return -1
 */
public class FirstOccurence {
    public static void main(String[] args) {
        int[] arr = new int[]{6,8,1,1,8,3,4};
        int occurence = firstOccurence(arr,0,8);
        System.out.print(occurence);
    }

    private static int firstOccurence(int[] arr, int i, int number) {
        if(i > arr.length -1)
            return -1;
        if(arr[i] == number)
            return i;
        return firstOccurence(arr,i+1,number);
    }
}
