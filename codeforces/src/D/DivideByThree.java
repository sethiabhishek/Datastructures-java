package D;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Polycarp likes to play with numbers. He takes some integer number 𝑥, writes it down on the board,
 * and then performs with it 𝑛−1 operations of the two kinds:
 *
 * divide the number 𝑥 by 3 (𝑥 must be divisible by 3);
 * multiply the number 𝑥 by 2.
 * After each operation, Polycarp writes down the result on the board and replaces 𝑥 by the result.
 * So there will be 𝑛 numbers on the board after all.
 *
 * You are given a sequence of length 𝑛 — the numbers that Polycarp wrote down.
 * This sequence is given in arbitrary order, i.e. the order of the sequence can mismatch the
 * order of the numbers written on the board.
 *
 * Your problem is to rearrange (reorder) elements of this sequence in such a way that it
 * can match possible Polycarp's game in the order of the numbers written on the board. I.e.
 * each next number will be exactly two times of the previous number or exactly one third of previous number.
 *
 * It is guaranteed that the answer exists.
 *
 * Input
 * The first line of the input contatins an integer number 𝑛 (2≤𝑛≤100) — the number of the elements
 * in the sequence. The second line of the input contains 𝑛 integer numbers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤3⋅1018) — rearranged
 * (reordered) sequence that Polycarp can wrote down on the board.
 *
 * Output
 * Print 𝑛 integer numbers — rearranged (reordered) input sequence that can be the sequence that
 * Polycarp could write down on the board.
 *
 * It is guaranteed that the answer exists.
 *
 * inputCopy
 * 6
 * 4 8 6 3 12 9
 * outputCopy
 * 9 3 6 12 4 8
 */

public class DivideByThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int items = sc.nextInt();
        List<BigInteger> input = new ArrayList<>();
        for(int i=0;i<items;i++){
            input.add(new BigInteger(sc.next()));
        }
        List<BigInteger> cloned = new ArrayList<>();
        for(BigInteger i:input){
            cloned.add(i);
        }
        BigInteger lastElemet = input.stream().filter(x -> {
            BigInteger twice = x.multiply(BigInteger.valueOf(2));
            BigInteger oneThird = x.divide(BigInteger.valueOf(3));
            boolean isOtherPresent = !cloned.contains(twice) && !cloned.contains(oneThird);
            return isOtherPresent;
        }).findFirst().get();

        cloned.set(items -1,lastElemet);
        int count = items -1;
        while(count > 0){
            boolean isHalfPResent = input.contains(lastElemet.divide(BigInteger.valueOf(2)));
            boolean isTriplePresent = input.contains(lastElemet.multiply(BigInteger.valueOf(3)));
            if(isHalfPResent){
                lastElemet = lastElemet.divide(BigInteger.valueOf(2));

            }else{
                lastElemet = lastElemet.multiply(BigInteger.valueOf(3));

            }
            cloned.set(count -1,lastElemet);

            count--;
        }

        for(BigInteger i:cloned){
            System.out.print(i + " ");
        }


    }
}
