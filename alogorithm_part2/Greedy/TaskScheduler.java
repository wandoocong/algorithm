package alogorithm_part2.Greedy;
/*
1. 자바의 기본 규칙
모든 메서드는 반드시 클래스 내부에 정의되어야 합니다.
        (Java는 클래스 외부에 독립적인 함수를 정의할 수 없습니다. C/C++과 달리 "함수"만 따로 둘 수 없습니다.)

    (1) 인스턴스 메서드로 구현 (public int leastInterval(char[] tasks, int n))
    (2) static 메서드로 구현 (public static int leastInterval(...))

*/

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'B', 'C', 'D'};
        int n = 2;

        int i = leastInterval(tasks, n);
        System.out.println("i = " + i);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqsMqp = new HashMap<>();
        int[] freqs = new int[26];
        for (char c : tasks)
            freqs[c - 'A']++;

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : freqs)
            if(a>0)
                pq.add(a);
        //Queue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 - a1);
        //Queue<Integer[]> pq2 = new PriorityQueue<>( (a1, a2) -> a1==a2 ? a2[0] - a1[0] : a1[1] - a2[1]);
        /*Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0]; // 첫 번째 값 내림차순
            } else {
                return a[1] - b[1]; // 두 번째 값 오름차순 (인덱스가 작은 게 먼저)
            }
        });*/
        int result = 0;

        while (true) {
            int interval = 0;
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                int poll = pq.poll();
                if (interval < n + 1) {
                    interval++;
                    result++;
                    if (poll > 1) {
                        list.add(poll - 1);
                    }
                } else {
                    list.add(poll);
                }
            }
            if (list.isEmpty()) {
                return result;
            }
            pq.addAll(list);
            // idle 계산해주기
            // n 개가 있으면 n + 1 을 추출해야, 최소값을 구할수 있다.
            // n+1 개를 못꺼내면 그만큼을 Idle 로 추가해줘야한다.
            // n 개 꺼내면 안됨 -> A B Idle A C Idle A D, 이렇게하면 정답이 8이됨.
            // n+1개 꺼내면 - > A B IDLE A C D A, 정답 7 나옴
            result += n + 1 - interval;
        }
    }
}
