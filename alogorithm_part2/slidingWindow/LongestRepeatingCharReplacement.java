package alogorithm_part2.slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        String s = "AAABBCD";
        int k = 2;

        int i = characterReplacement(s, k);
        System.out.println("i = " + i);
    }

    public static int characterReplacement(String s, int k) {
        int left = 0;
        Map<Character, Integer> counts = new HashMap<>();

        for (int right = 1; right <= s.length(); right++) {
            counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);

            int maxCommonChar = Collections.max(counts.values());

            if (right - left - maxCommonChar > k) {
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }
            //s.length 값이 right 와 동일
        return s.length() - left;
    }
}
