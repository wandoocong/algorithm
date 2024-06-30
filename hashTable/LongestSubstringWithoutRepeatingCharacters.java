package hashTable;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "abcabcbbc";

        LongestSubstringWithoutRepeatingCharacters zz = new LongestSubstringWithoutRepeatingCharacters();

        int answer = zz.lengthOfLongestSubstring(str);
        System.out.println("answer = " + answer);

    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> used = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            used.put(c, right);
            right++;
        }

        return maxLength;
    }
}
