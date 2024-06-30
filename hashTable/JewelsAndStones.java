package hashTable;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();

        int answer = jewelsAndStones.numJewelsInStones("aA", "aAAbbbb");
        System.out.println("answer = " + answer);

    }

    public int numJewelsInStones (String J, String S) {
        int count = 0;
        Map<Character, Integer> freqs = new HashMap<>();

        //돌 개수 계산
        for (char s : S.toCharArray()) {
//            if(freqs.containsKey(s))
//                freqs.put(s, freqs.get(s) + 1);
//            else
//                freqs.put(s, 1);
            freqs.put(s, freqs.getOrDefault(s, 0) + 1);
        }

        for (char j : J.toCharArray()) {
            if (freqs.containsKey(j)) {
                count += freqs.get(j);
            }
        }

        return count;
    }
}
