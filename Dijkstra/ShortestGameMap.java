package Dijkstra;

import java.util.*;

public class ShortestGameMap {

    public static void main(String[] args) {
        ShortestGameMap shortestGameMap = new ShortestGameMap();

        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int solution = shortestGameMap.solution(maps);
        System.out.println("solution = " + solution);
    }

    static class Position {
        final int y;
        final int x;
        final int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
    Queue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

    public void findPath(int y, int x, int distance, int[][] maps) {
        if (y >= 0 && y < maps.length && x >= 0 && x < maps[0].length && maps[y][x] != 0) {
            maps[y][x] = 0;
            pq.add(new Position(y, x, distance + 1));
        }
    }

    public int solution(int [][] maps) {

        // 출발지 좌표 입력, 해당 초기 거리 입력
        pq.add(new Position(0, 0, 1));

        Map<Integer, Position> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Position cur = pq.poll();

            if (!dist.containsKey(cur.y * 1000 + cur.x)) {

                //각 좌표별 Key Value 넣기
                dist.put(cur.y * 1000 + cur.x, cur);

                findPath(cur.y, cur.x+1, cur.distance, maps);
                findPath(cur.y, cur.x-1, cur.distance, maps);
                findPath(cur.y+1, cur.x, cur.distance, maps);
                findPath(cur.y-1, cur.x, cur.distance, maps);
            }

        }
        if (dist.containsKey(((maps.length - 1) * 1000) + (maps[0].length - 1))) {
            return dist.get(((maps.length - 1) * 1000) + (maps[0].length - 1)).distance;
        }
        return -1;
    }
}
