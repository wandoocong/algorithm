package stackAndqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperature = {23, 24, 25, 21, 19, 22, 26, 23};

        DailyTemperature dailyTemperature = new DailyTemperature();
        System.out.println(Arrays.toString(dailyTemperature.dailyTemp(temperature)));
    }

    public int[] dailyTemp(int[] temperature) {
        // 결과 담을 배열 선언
        int[] result = new int[temperature.length];
        // 결과 처리를 위한 스택 선언
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperature.length; i++) {

            // 현재 온도가 스택에 있는 온도보다 높다면, 기존꺼 꺼서 결과 업데이트
            while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                int last = stack.pop();
                result[last] = i - last;
            }

            // 현재 인덱스를 스택에 삽입
            stack.push(i);
        }
        return result;
    }
}
