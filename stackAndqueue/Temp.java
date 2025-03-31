package stackAndqueue;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] temperature = {23, 24, 25, 21, 19, 22, 26, 23};

        System.out.println(Arrays.toString(dailyTemp(temperature)));
    }

    public static int[] dailyTemp(int[] temperature) {
        int[] result = new int[temperature.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperature.length; i++) {
            while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }
        return result;
    }
}
