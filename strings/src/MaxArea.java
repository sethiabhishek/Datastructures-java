import java.util.Scanner;

public class MaxArea {
        public static void main (String args[]) {
            //Scanner sc = new Scanner(System.in);
            int points = 9;
            int[] arr = {1,8, 6, 2, 5, 4, 8, 3, 7};
            System.out.println(arr);
            int first = 0;
            int last = arr.length - 1;
            int maxArea = 0;
            while(first < last){
                int width = last - first;
                int height = Math.min(arr[first],arr[last]);
                int area = width * height;
                System.out.println(area);
                if(area > maxArea){
                    System.out.println("area greater than max area reassigning");
                    maxArea = area;
                }
                if(arr[first] < arr[last]){
                    first++;
                }else{
                    last--;
                }
            }
            System.out.println(maxArea);
        }

}
