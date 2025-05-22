package algorithm_part1.str;


public class LongestPalindromeSubstring {

    int left = 0;
    int maxLen = 0;

    public static void main(String[] args) {

        String str = "dcbabcdd";
        String answer = "";

        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();

        answer = longestPalindromeSubstring.longestPalindrome(str);
        System.out.println("answer = " + answer);

    }

    public String longestPalindrome(String s) {

        int len = s.length();
        if(len < 2) return s;

        for (int i = 0; i < len - 1; i++) {

            extendPalindrome(s, i, i + 1); // 2칸 짜리
            extendPalindrome(s, i, i + 2); // 3칸 짜리
        }
        return s.substring(left, left + maxLen);
    }

    public void extendPalindrome(String s, int start, int end) {

        while ((start >= 0 && end < s.length() - 1) && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        if (maxLen < end - start - 1) {
            left = start + 1;
            maxLen = end - start - 1;
        }
    }


}
