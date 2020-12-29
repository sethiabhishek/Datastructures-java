import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * You are given an array of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.
 *
 * Determine if there is a loop (or a cycle) in array. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements. Print 1 if cycle present else print 0.
 *
 * Input Format
 * First Line Contains single integer n Second line contains n space separated integers
 *
 * Constraints
 * 1<=n<=1e6
 * -1000<=Ai<=1000
 *
 * Output Format
 * single digit 1 or 0
 *
 * Sample Input
 * 5
 * 2 -1 1 2 2
 * Sample Output
 * 1
 */

public class RotatingArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for(int i=0 ;i <n ;i ++){
            arr[i] = sc.nextInt();
        }
        Node node = null;
        List<Node> nodesList = new ArrayList<>();
        int index = 0;
        for(Integer i: arr){
            node = new Node();
            node.setI(i);
            node.setIndex(index);
            index ++;
            nodesList.add(node);

        }

        for(Node nd:nodesList){
            int next = (nd.getIndex() + nd.i + arr.length)%arr.length;
            int nextNodeVal = nodesList.get(next).i;
            if(nd.i * nextNodeVal > 0 ){ // this is to make sure we are following only direction in the cycle
                System.out.println(nd);
                nd.setVisited(true);

                System.out.println("next node is:"+nodesList.get(next));
                if(nodesList.get(next).isVisited){
                    System.out.println(1);
                    break;
                }
            }

        }

    }

    static class Node{
        int i;
        boolean isVisited;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        int index;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", isVisited=" + isVisited +
                    ", index=" + index +
                    '}';
        }
    }
}
