public class DuplicationTest {

    public static void main(String[] args) {
        String s = "abcde";
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i) - 'a']  == 1){
                System.out.print("duplicate chars");
            }else{
                freq[s.charAt(i) - 'a']++;
        }
     }
    }
}
