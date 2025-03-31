package hashTable;

import java.util.*;

public class Temp {
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        int k = 2;


        int[] answers = topKFrequent(nums, k);
        System.out.println(Arrays.toString(answers));

        /*int[] ints = topKPriority(nums, k);
        System.out.println("ints = " + Arrays.toString(ints));*/
    }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
            //num , freq
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Map < Integer, List<Integer>> reverseMap = new HashMap<>();
                // freq, num [List 로 추가]

        for (int num : map.keySet()) {
            Integer frequency = map.get(num);

            if (!reverseMap.containsKey(frequency)) {
                reverseMap.put(frequency, new ArrayList<Integer>());
            }
            reverseMap.get(frequency).add(num);
        }

        int[] ints = new int[k];
        int index = 0;
        for (int fre = nums.length; fre > 0 && index <k; fre--) {
            if (reverseMap.containsKey(fre)) {
                for (int num : reverseMap.get(fre)) {
                    ints[index] = num;
                    index++;
                }
            }
        }

        return ints;
    }

    //  int[] nums = {1, 1, 1, 2, 2, 3, 4};
    //  int k = 2;
    public static int[] topKPriority(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //num , freq
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for (int elem : map.keySet()) {
            pq.add(new int[]{elem, map.get(elem)});
        }
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = pq.poll()[0];
        }
        return ints;
    }
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> used = new HashMap<>();
        int left = 0, right = 0, maxLength =0;
        for (char c : s.toCharArray()) {

            // abc |a|
            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            used.put(c, right);
            right++;
        }
        return maxLength;
    }
                                            //aA    aaabaac
    public static int numJewelsInStones(String J, String S) {

        int cnt = 0;
        Set<Character> set = new HashSet<>();
        for (char a : J.toCharArray()) {
            set.add(a);
        }
        for (char a : S.toCharArray()) {
            if (set.contains(a)) {
                cnt++;
            }
        }
        return cnt;
    }
}
