package algorithm_part1.graph.graphPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfaPhoneNumber {
    public static void main(String[] args) {
        Map<Character, List<Character>> dic = new HashMap<>();
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a','b','c'));
        dic.put('3', List.of('d','e','f'));
        dic.put('4', List.of('g','h','i'));
        dic.put('5', List.of('j','k','l'));
        dic.put('6', List.of('m','n','o'));
        dic.put('7', List.of('p','q','r'));
        dic.put('8', List.of('s','t','u'));
        dic.put('9', List.of('w','x','y', 'z'));

        List<String> answers = new ArrayList<>();
        dfs(answers, dic, "24", 0, new StringBuilder());
        System.out.println("answers = " + answers);
    }

    private static void dfs(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {

        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }
                            // 2->abc, 4->ghi
        for (char c : dic.get(digits.charAt(index))) {
            dfs(result, dic, digits, index + 1, new StringBuilder(path).append(c));
        }

    }

}
