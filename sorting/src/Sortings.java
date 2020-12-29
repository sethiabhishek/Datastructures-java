public class Sortings {

    public static void main(String[] args) {

        int[] arr = {55,40,39,52,1,9,3,19};
        Sortings sortings = new Sortings();
        sortings.display(arr);
        sortings.insertionSort(arr);
        sortings.display(arr);
    }

    /**
     * code for insertion sort make note here counter tells how many elements
     * are already sorted
     * @param arr
     */
    private void insertionSort(int[] arr) {
        int counter = 1;
        while(counter <= arr.length -1){
            int val = arr[counter];
            int j = counter - 1;
            while(j >= 0 && arr[j] > val){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
            counter ++;
        }

    }

    /**
     * selection sort, opposite of bubble sort, counter tells these many elements are at
     * their correct position, it puts min value first
     * @param arr
     */
    private void selectionSort(int[] arr) {
        int counter = 0;
        while(counter < arr.length -1){
            int val = arr[counter];
            int min = counter;
            int j = counter + 1;
            while(j <= arr.length -1){
                if(arr[j] < arr[min]){
                    min = j;
                }
                j++;
            }
            int temp = arr[min];
            arr[min] = val;
            arr[counter] = temp;
            counter ++;
        }
    }

    private void display(int[] arr) {
        for(int n:arr){
            System.out.print(n + "  ");
        }
        System.out.println();
    }

    /**
     * bubble sort, counter tells these many elements at proper location, value with greatest value is kept first
     * @param arr
     */
    public void bubbleSort(int[] arr){
        for(int counter = 0;counter < arr.length - 1 ; counter++){
            for(int j = 0 ; j <  arr.length - 1 - counter; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]  = temp;
                }
            }
        }

    }
}
