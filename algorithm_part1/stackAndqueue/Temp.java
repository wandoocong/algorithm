package algorithm_part1.stackAndqueue;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] temperature = {23, 24, 25, 21, 19, 22, 26, 23};

        DailyTemperature dailyTemperature = new DailyTemperature();
        System.out.println(Arrays.toString(dailyTemperature.dailyTemp(temperature)));
    }

    public int[] dailyTemp(int[] temperature) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperature.length];

        for (int i = 0; i < temperature.length; i++) {

            while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }
        return result;
    }

    public static String removeDuplicateLetters(String s) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Boolean> checks = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : s.toCharArray()) {

            if (checks.get(c) != null && checks.get(c) == true) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > 1) {
                Character pop = stack.pop();
                checks.put(pop, false);

                map.put(pop, map.get(pop)-1);
            }
            stack.push(c); //d -- true

            checks.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static boolean isValid(String s) {

        Deque<String> stack = new ArrayDeque<>();

        Map<String, String> map = new HashMap<>();
        map.put("]", "[");
        map.put("}", "{");
        map.put(")", "(");

        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            //열림 이면 push
            if (!map.containsKey(s1)) {
                stack.push(s1);
            } else {
                //닫힘 이면 pop 해서 비교
                if (stack.isEmpty() || !map.get(s1).equals(stack.pop())) {
                    return false;
                }
            }
        }
        return true;
    }

}
