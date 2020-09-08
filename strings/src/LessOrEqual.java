/**
 * You are given a sequence of integers of length 𝑛 and integer number 𝑘. You should print any integer number 𝑥 in
 * the range of [1;109] (i.e. 1≤𝑥≤109) such that exactly 𝑘 elements of given sequence are less than or equal to 𝑥.
 *
 * Note that the sequence can contain equal elements.
 *
 * If there is no such 𝑥, print "-1" (without quotes).
 *
 * Input
 * The first line of the input contains integer numbers 𝑛 and 𝑘 (1≤𝑛≤2⋅105, 0≤𝑘≤𝑛).
 * The second line of the input contains 𝑛 integer numbers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤109) — the sequence itself.
 *
 * Output
 * Print any integer number 𝑥 from range [1;109] such that exactly 𝑘 elements of given sequence is less or equal to 𝑥.
 *
 * If there is no such 𝑥, print "-1" (without quotes).
 *
 * Examples
 * inputCopy
 * 7 4
 * 3 7 5 1 10 3 20
 * outputCopy
 * 6
 * inputCopy
 * 7 2
 * 3 7 5 1 10 3 20
 * outputCopy
 * -1
 * Note
 * In the first example 5 is also a valid answer because the elements with indices [1,3,4,6] is less than or equal to 5
 * and obviously less than or equal to 6.
 *
 * In the second example you cannot choose any number that only 2 elements of the given sequence will be less than
 * or equal to this number because 3 elements of the given sequence will be also less than or equal to this number.
 */

public class LessOrEqual {

}
