package Dijkstra;

import java.util.*;

public class Temp {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        Temp temp = new Temp();
        int solution = temp.solution(maps);
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

    PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
    public void findPath(int y, int x, int distance, int[][] maps) {
        if (y >= 0 && y < maps.length && x >= 0 && x < maps[0].length && maps[y][x] != 0) {
            maps[y][x] = 0;
            pq.add(new Position(y, x, distance + 1));
        }
    }

    public int solution(int [][] maps) {

        pq.add(new Position(0, 0, 1));

        Map<Integer, Position> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Position poll = pq.poll();
            int x = poll.x;
            int y = poll.y;
            int distance = poll.distance;

            dist.put(y * 1000 + x, poll);

            findPath(y + 1, x, distance , maps);
            findPath(y - 1 , x, distance , maps);
            findPath(y , x+1, distance , maps);
            findPath(y , x-1, distance , maps);
        }
        return dist.get((maps.length-1)*1000 + (maps[0].length-1)).distance;
    }
}
