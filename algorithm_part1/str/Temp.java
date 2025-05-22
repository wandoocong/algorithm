package algorithm_part1.str;

import java.util.*;

public class Temp {

    public static void main(String[] args) {
        String str = "dcbabcdd";
        String answer = "";

        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();

        answer = longestPalindromeSubstring.longestPalindrome(str);
        System.out.println("answer = " + answer);
    }

    int maxLen = 0;
    int left = 0;
    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(left, left + maxLen);
    }

    public void extendPalindrome(String s, int start, int end) {

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (maxLen < end - start -1) {
            maxLen = end - start - 1;
            left = start + 1;
        }
    }
    public static List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        ArrayList<List<String>> lists = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }

        return lists;
    }

    public static String mostCommonWord(String p, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String str : banned) {
            set.add(str);
        }

        Map<String, Integer> map = new HashMap<>();
        String[] s = p.replaceAll("\\W+", " ").toLowerCase().split(" ");
        for (String sz : s) {
            if (!set.contains(sz)) {
                map.put(sz, map.getOrDefault(sz, 0) + 1);
            }
        }

        Integer max = Collections.max(map.values());

        for (String sz : s) {
            if (map.get(sz) == max) {
                return sz;
            }
        }
        return null;
    }

    public static String [] recordLogFiles(String [] logs){

        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String str : logs) {
            if (Character.isDigit(str.split(" ")[1].charAt(0))) {
                digits.add(str);
            } else {
                letters.add(str);
            }
        }

        letters.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String[] a1 = a.split(" ", 2);
                String[] b1 = b.split(" ", 2);
                int compare = a1[1].compareTo(b1[1]);
                if (compare == 0) {
                    return a1[0].compareTo(b1[0]);
                } else {
                    return a1[1].compareTo(b1[1]);
                }
            }
        });
        /*letters.sort((a, b) -> {
            String[] a1 = a.split(" ", 2);
            String[] b1 = b.split(" ", 2);
            int compare = a1[1].compareTo(b1[1]);
            if (compare ==0) {
                return a1[0].compareTo(b1[0]);
            } else {
                return a1[1].compareTo(b1[1]);
            }
        });*/

        letters.addAll(digits);
        return letters.toArray(new String[0]);
    }
    public void reverseString(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean isPalindrome2(String s){
        int start = 0;
        int end = s.length() - 1;

        s = s.toLowerCase();
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String s){
        String lowerCase = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String string = new StringBuilder(lowerCase).reverse().toString();
        System.out.println("string = " + string);
        boolean equals = lowerCase.equals(string);
        return equals;
    }


}
