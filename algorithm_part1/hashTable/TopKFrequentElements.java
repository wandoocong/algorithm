package algorithm_part1.hashTable;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        int k = 2;

        int[] answers = topKFrequent(nums, k);
        System.out.println(Arrays.toString(answers));

        int[] ints = topKPriority(nums, k);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<>();
                        // 1, 2, 3, 4
        for (int elem : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(elem);
            List<Integer> elems = buckets.getOrDefault(frequency, new ArrayList<>());
            elems.add(elem);

            // 빈도수를 key
            // List 형식의 elements 를 Value
            buckets.put(frequency, elems);
        }

        int[] result = new int[k];
        int index = 0;

        for (int frequency = nums.length; frequency >= 0 && index <k; frequency--) {
            if (buckets.get(frequency) != null) {
                for (int elem : buckets.get(frequency)) {
                    result[index] = elem;
                    index++;
                }
            }
        }

        return result;
    }

    public static int[] topKPriority(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        //빈도순으로 정렬되는 우선순위 큐 선언
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int elem : frequencyMap.keySet()) {
                            // 배열인데
                            // element 값과 빈도수를 일차원 배열에 저장후 add
            pq.add(new int[]{elem, frequencyMap.get(elem)});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }


}
