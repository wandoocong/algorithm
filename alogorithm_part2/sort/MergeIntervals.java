package alogorithm_part2.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

        int[][] arr = {{1, 3}, {8, 11}, {2, 6}, {15, 18}};

        int[][] merge = merge(arr);
        System.out.println("merge = " + Arrays.toString(merge[0]));
        System.out.println("merge = " + Arrays.toString(merge[1]));
        System.out.println("merge = " + Arrays.toString(merge[2]));
    }

    public static int[][] merge(int[][] intervals) {

        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] i : intervals) {
            if (!merged.isEmpty() && i[0] <= merged.get(merged.size() - 1)[1]) {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], i[1]);
            } else {
                merged.add(i);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
