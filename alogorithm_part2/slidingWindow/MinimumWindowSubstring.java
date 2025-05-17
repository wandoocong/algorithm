package alogorithm_part2.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String str = "ABDOBECODEBANC";
        str = "ABDBANC";
        String t = "ABC";
        System.out.println("minWindow = " + minWindowHard(str, t));

    }

    public static String minWindow(String s, String t) {
        for (int windowSize = t.length(); windowSize < s.length() + 1; windowSize++) {

            for (int left = 0; left < s.length() - windowSize + 1; left++) {
                String sSubStr = s.substring(left, left + windowSize);
                if (contains(sSubStr, t)) {
                    return sSubStr;
                }
            }
        }
        return "";
    }

    public static boolean contains(String sSubStr, String t) {
        StringBuilder sb = new StringBuilder(sSubStr);
        for (char tElem : t.toCharArray()) {
            // sb 에서 tElem 이 위치한 index 값을 알려준다.
            if (sb.indexOf(String.valueOf(tElem)) != -1) {
                //해당 위치에 있는 char 삭제해준다.
                sb.deleteCharAt(sb.indexOf(String.valueOf(tElem)));
            } else {
                //하나라도 false 면 fail
                return false;
            }
        }
        return true;
    }

    public static String minWindowHard(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int missing = t.length();
        int left = 0, right = 0, start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            right++;
            if (need.containsKey(c) && need.get(c) > 0) {
                missing--;
            }

            // 사용되는 문자의 개수는 각각 최종적으로 개수가 0 이 될것
            need.put(c, need.getOrDefault(c, 0) - 1);

            if (missing == 0) {
                //음수라면 불필요한 문자일것
                //left 한칸이동(+1) 시키고, 사용한 것도 개수 +1 해주기
                //0인것 만나면 STOP, 더이상 left 한칸이동(+1) 할수 없음
                while (left < right && need.get(s.charAt(left)) < 0) {
                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                }

                //최소값 계산
                if (minLen > right - left) {
                    minLen = right - left;
                    start = left;
                    end = right;
                }
                System.out.println("minLen = " + minLen);

                //마지막에 빠진 값은 다시 채워야하는 값이므로 전체 카운터 증가, left 한칸이동, 문자 개수 증가
                need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                missing++;
                left++;
            }
        }
        return s.substring(start, end);
    }

}
