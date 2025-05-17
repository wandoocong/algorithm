import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestSampleCode_String_Char {
    public static void main(String[] args) {
        // StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder a1 = new StringBuilder(stringBuilder).append('a');
        a1.append('b');
        System.out.println("StringBuilder test = " + a1);
        System.out.println("####################################");

        // 문자열 배열 출력
        char[] a = {'1', '2', '3', 'e', 'c', 'a', 'r'};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("####################################");

        // 문자열 바로 char 로
        String S = "aAAbbbb";
        Map<Character, Integer> freqs = new HashMap<>();
        for (char s : S.toCharArray()) {
//            if(freqs.containsKey(s))
//                freqs.put(s, freqs.get(s) + 1);
//            else
//                freqs.put(s, 1);
            freqs.put(s, freqs.getOrDefault(s, 0) + 1);
        }
        System.out.println("####################################");
    }


}
