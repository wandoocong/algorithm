package algorithm_part1.str;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strArr = {"eat", "tea", "tan", "ate", "ant", "cat"};

        System.out.println(groupAnagrams(strArr));
    }

    public static List<List<String>> groupAnagrams(String[] strings) {

        // 단어를 sorting 한 값을 Key 로
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strings) {
            // 단어를 쪼개서 문자 배열에 넣기
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = String.valueOf(chars);

            // 최초 put 에서만
            // String, List<String> 해당 형태 만들어주기
            if ( !results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }
            results.get(key).add(s);
        }
        return new ArrayList<>(results.values());
    }
}
