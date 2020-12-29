import sun.applet.resources.MsgAppletViewer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a numerical string and a map consisting of codes from a-z used for them
 * find num of ways to decode the string
 */
public class DecodeStrings {
    public static void main(String[] args) {
        char c = 97;
        int val = 1;
        Map<String,String> m = new HashMap<>();
        for(char i=0;i<26;i++){
            m.put(String.valueOf(val++),String.valueOf(c++));
         }
        System.out.print(m);
        String  stringToDecode = "1123";
        int num  = decode(stringToDecode,0);
        System.out.println(num);

    }

    private static int decode(String stringToDecode, int index) {
        if(index >= stringToDecode.length() -1){
            return 1;
        }
        if(stringToDecode.charAt(index) == '0'){
            return 0;
        }
        if(stringToDecode.length() == 0){
            return 1;
        }
        char c = stringToDecode.charAt(index);
        int ways1 = decode(stringToDecode,index +1);
        int twice = Integer.valueOf(stringToDecode.substring(index,index + 2));
        int ways2 = 0;
        if(twice < 26){
            ways2 = decode(stringToDecode,index +2);

        }
        return ways1 + ways2;
    }
}
