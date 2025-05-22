package algorithm_part2.divideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 3, 2, 2};

        int i = majorityElement(nums);
        System.out.println("i = " + i);

    }

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() > (nums.length / 2)) {
                return list.get(i).getKey();
            }
        }
        return -1;
    }
}
