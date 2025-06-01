package algorithm_part1.stackAndqueue;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String str = "dbacdcbc";

        System.out.println(removeDuplicateLetters(str));
    }

    public static String removeDuplicateLetters(String s) {
        // 문자 개수 담아 두기
        Map<Character, Integer> counter = new HashMap<>();
        //이미 처리한 문자여 여부 확인 하기 위한 변수 선언
        Map<Character, Boolean> seen = new HashMap<>();
        //문제 풀이에 사용할 스택 선언
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c,0) + 1);
        }

        for (char c : s.toCharArray()) {
            //현재 처리한 문자는 카운터 -1 처리
            counter.put(c, counter.get(c) - 1);

            //이미 처리한 문자는 건너뛰기
            if (seen.get(c) != null && seen.get(c) == true) {
                continue;
            }
            // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙어야 할 문자라면 스택에서 제거하고
            // 처리하지 않은것으로 표시

            // -> 개수가 1개 이상이고, 현재 문자보다 뒤에 붙어야할 문자이면
            // stack 에서 제거후 처리안한 표시 하기
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0)
                seen.put(stack.pop(), false);

            // 현재 문자를 stack 에 삽입
            stack.push(c);
            // 현재 문자를 처리한 걸로 선언
            seen.put(c, true);
        }

        //스택에 있는 문자를 큐 순서대로 추출하여 리턴
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
