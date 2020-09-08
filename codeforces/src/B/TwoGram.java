package B;

import java.util.*;

/**
 * Two-gram is an ordered pair (i.e. string of length two) of capital Latin letters. For example, "AZ", "AA", "ZA" — three distinct two-grams.
 *
 * You are given a string 𝑠 consisting of 𝑛 capital Latin letters. Your task is to find any two-gram contained in the given string as a substring (i.e. two consecutive characters of the string) maximal number of times. For example, for string 𝑠 = "BBAABBBA" the answer is two-gram "BB", which contained in 𝑠 three times. In other words, find any most frequent two-gram.
 *
 * Note that occurrences of the two-gram can overlap with each other.
 *
 * Input
 * The first line of the input contains integer number 𝑛 (2≤𝑛≤100) — the length of string 𝑠.
 * The second line of the input contains the string 𝑠 consisting of 𝑛 capital Latin letters.
 *
 * Output
 * Print the only line containing exactly two capital Latin letters —
 * any two-gram contained in the given string 𝑠 as a substring (i.e. two consecutive characters of the string) maximal number of times.
 *
 * Examples
 * inputCopy
 * 7
 * ABACABA
 * outputCopy
 * AB
 * inputCopy
 * 5
 * ZZZAA
 * outputCopy
 * ZZ
 * Note
 * In the first example "BA" is also valid answer.
 *
 * In the second example the only two-gram "ZZ" can be printed because it contained in the string "ZZZAA" two times.
 */

public class TwoGram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String s = sc.next();
        List<String> twoGrams = findAllBigrams(s,new ArrayList<>());
        int majorityCount = 0;
        String majElement = "";
        int maxCount = 0;
        String maxElement = "";
        Collections.sort(twoGrams);
        for(String str:twoGrams){
            if(majElement.isEmpty() || majElement.equalsIgnoreCase(str)){
                majorityCount++;

            }else{
                majorityCount  = 1;
            }
            majElement = str;
            if(majorityCount > maxCount){
                maxElement = majElement;
                maxCount = majorityCount;
            }
        }
        System.out.println(maxElement);

    }

    private static List<String> findAllBigrams(String s, ArrayList<String> strings) {
        if(s.isEmpty() || s.length() ==1){
            return strings;
        }else if(s.length() == 2){
            strings.add(s);
            return strings;
        }
        String subString = s.substring(0,2);
        String rest = s.substring(1);
        findAllBigrams(rest, strings);
        strings.add(subString);
        return strings;

    }

}
