package algorithm_part2.binary_Search;

import java.util.*;
public class ProgrammersImigration {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        long solution = solution(n, times);
        System.out.println("solution = " + solution);

    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        Arrays.sort(times);
        // 이렇게 형변형 하는이유 -> 만약 INT max 값인 21억이 들어왔는데, 그값의 * 사람수를 하는순간 overflow 된다.
        // 따라서 long 으로 형변형 하고 * n 처리해야함
        long right = (long)times[times.length-1] * n;
        // long right =(long) Arrays.stream(times).max().getAsInt() * n;

        // 소요시간
        long mid = right;

        while(left <= right){
            long calc =0;

            //소요시간을 각 심사위원별 시간으로 나누어서, 우리가 목표로 하는 인원수가 나오는지 확인
            //이진 탐색으로 해당인원수의 최 근접치를 찾아 가는것이 목표
            for(long time : times)
                calc += (mid/time);


            /*
            if (nums[mid] < target) {
                return binarySearchW(nums, target, mid + 1, right);
            } else if (nums[mid] > target) {
                return binarySearchW(nums, target, left, mid-1);
            }
            */

            // left 와 right 의 위치를 target 위치에 맞게 좁혀 나가는것,
            // 좁히는 방법은 right, left 값을 mid 를 이용해서 조정

            if(calc >= n){
                answer = mid;
                right = mid-1;
            }else {
                left = mid +1;
            }
            mid = left + (right-left)/2;
        }

        return answer;
    }
}
