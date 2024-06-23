package priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {

        int[][] a = {{3,  3},
                     {6, -1},
                     {-2, 4}};
        int k = 2;

        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] answers = kClosestPointsToOrigin.kClosest(a, k);

        System.out.println("answers = " + Arrays.deepToString(answers));
    }

    static class Points {
        double distance;
        int[] point;

        public Points(double distance, int[] point) {
            this.point = point;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Points> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.distance));

        // 예를들어 이차원배열은 일차원 배열로 구성되어있다.
        // [6,-1] 같은 값이 point[0] = 6, point[1] = -1 
        // 위같은 식으로 들어간다. 
        for (int[] point : points) {
            double distance = Math.sqrt((long) point[0] * point[0] + (long) point[1] * point[1]);
            pq.add(new Points(distance, point));
            // point = [3, 3]
            // point = [6, -1]
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            // 이런 표현식이 조금 헷갈리네
            result[i] = pq.poll().point;
            System.out.println("result = " + Arrays.toString(result[i]));
        }
        return result;
    }
}