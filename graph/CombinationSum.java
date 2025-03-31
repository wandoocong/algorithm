package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5, 8};
        int target = 8;

        List<List<Integer>> results = new ArrayList<>();
        dfs(results, candidates, target, 0, new ArrayDeque<>());
        System.out.println("results = " + results);
    }

    private static void dfs(List<List<Integer>> results, int[] candidates, int target, int index, Deque<Integer> path) {
        if (target<0) return;

        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        //여기서 i를 index 부터 넣는것이 조합 문제 풀이에서 중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for (int i = index; i < candidates.length; i++) {

            path.add(candidates[i]);
            dfs(results, candidates, target - candidates[i], i, path);
            //path.remove((candidates[i]));
            path.removeLast();

        }
    }
}
