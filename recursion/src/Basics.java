import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basics {

    public static void main(String[] args) {
        Basics basics = new Basics();
        //basics.printSkip(5);
        //basics.printIncrement(5);
        //System.out.println(basics.giveFib(7));
        int[] arr1 = {0,1,2,3,4,5};
        int[] arr2 = {3,8,6,4,3,1};
        int[] arr3 = {3,8,8,4,8,1};
        int[] arr4 = {8,7,6,5,19,1};
        //System.out.println(basics.isArraySorted(arr2,0));
        //System.out.println(basics.getLastIndex(arr3,0,3));
        //System.out.println(basics.getAllIndex(arr3,0,99,new ArrayList<>()));
        basics.bubbleSort(arr4,0,arr4.length -1);
        System.out.print(Arrays.toString(arr4));

    }

    private boolean isArraySorted(int[] arr,int start) {
        if(start == arr.length -1)
            return true;

        if(arr[start] < arr[start +1]){
            return isArraySorted(arr,start +1);
        }else{
            return false;
        }


    }

    private void printIncrement(int num) {
        if(num == 0)
            return;
        printIncrement(num -1);
        System.out.println(num);
    }

    private void printDecrement(int num) {
        if(num == 0)
            return;
        System.out.println(num);
        printDecrement(num -1);
    }
    private void printBoth(int num) {
        if(num == 0)
            return;
        System.out.println(num);
        printBoth(num -1);
        System.out.println(num);
    }

    private void printSkip(int num) {
        if(num == 0)
            return;
        if(num %2 == 1){
            System.out.println(num);
        }
        printSkip(num -1);
        if(num % 2 == 0){
            System.out.println(num);
        }


    }

    private int giveFib(int num){
        if(num == 1 || num ==2){
            return 1;
        }
        int last = giveFib(num -1);
        int secondLast = giveFib(num -2);
        return last + secondLast;
    }

    private int getFirstIndex(int[] arr,int start,int element){
        if(start == arr.length -1 && arr[arr.length - 1] != element){
            return -1;
        }
        if(arr[start] == element){
            return start;
        }else {
            return getFirstIndex(arr,start +1,element);
        }

    }

    private int getLastIndex(int[] arr,int start,int element){
        if(start == arr.length){
            return -1;
        }
        int index = getLastIndex(arr,start +1,element);
        if(index == -1){
            if(arr[start] == element){
                return start;
            }else{
                return -1;
            }
        }else{
            return index;
        }

    }

    private List getAllIndex(int[] arr, int start, int element, List<Integer> list){
        if(start == arr.length){
            return list;
        }
        if(arr[start] == element){
            list.add(start);
        }

        return getAllIndex(arr,start+1,element,list);
    }

    public void bubbleSort(int[] arr,int start,int end){
        if(end == 0){
            return;
        }
        if(start == end){
            bubbleSort(arr,0,end-1);
            return;
        }
        if(arr[start] > arr[start + 1]){
            int temp = arr[start];
            arr[start] = arr[start + 1];
            arr[start + 1] = temp;
        }
        bubbleSort(arr,start+1,end);
    }


}
