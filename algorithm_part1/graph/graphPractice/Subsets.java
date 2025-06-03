package algorithm_part1.graph.graphPractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        List<List<Integer>> answers = new ArrayList<>();
        int[] nums = {1, 2, 4};
        dfs(answers, nums, 0, new ArrayDeque<>());

        System.out.println("answers = " + answers);
    }

    private static void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {
        results.add(new ArrayList<>(path));
        for (int i=index; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(results, nums, i + 1, path);
            
            path.removeLast();
        }
    }


}
