package algorithm_part1.hashTable;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        int k = 2;
        int[] ints = topKFrequentByPriori(nums, k);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    public static int[] topKFrequentByHash(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        //1 ->3
        //2 ->2
        //3 ->2
        //4 ->1
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 빈도수를 key 로 list 저장 map
        Map<Integer, List<Integer>> buckets = new HashMap<>();

                            // 1 2 3 4
        for (Integer temp : map.keySet()) {
            //빈도수
            Integer i = map.get(temp);
            if (!buckets.containsKey(i)) {
                buckets.put(i, new ArrayList<>());
            }
            buckets.get(i).add(temp);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = nums.length; i >=0 && index <k ; i--) {
            if (buckets.containsKey(i)) {
                for ( int temp :buckets.get(i)){
                    result[index] = temp;
                    index++;
                }
            }
        }
        return result;
    }


    public static int[] topKFrequentByPriori(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for ( int temp : map.keySet()){
            pq.add(new int[]{temp, map.get(temp)});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
