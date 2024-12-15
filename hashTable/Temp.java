package hashTable;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        /*String j = "aA";
        String s = "aAAbbbb";

        int i = numberJewels(j, s);
        System.out.println("i = " + i);*/

        /*String str = "abcabcbbc";
        int i = lengthOfLongestSubstring(str);
        System.out.println("i = " + i);*/

        int[] nums = {1, 1, 1, 2, 2, 3, 4,4,4,4};
        int k = 2;

        int[] ints = topKPriority(nums, k);
        System.out.println("ints = " + Arrays.toString(ints));


    }

    public static int[] topKPriority(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /*if(o2[1] > o1[1]) {
                    return 1;
                }else if(o1[1] > o2[1]) {
                    return -1;
                }else {
                    return 0;
                }*/
                return o2[1] - o1[1];
            }
        });
        for (int a : map.keySet()) {
            queue.add(new int[]{a, map.get(a)});
        }

        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
            //num , freq
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Map < Integer, List<Integer>> reverseMap = new HashMap<>();
                // freq, num
        for (int a : map.keySet()) {
            Integer frequency = map.get(a);

            List<Integer> orDefault = reverseMap.getOrDefault(frequency, new ArrayList<>());
            orDefault.add(a);

            reverseMap.put(frequency, orDefault);
        }

        int[] ints = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0 && index <k; i--) {
            if (reverseMap.containsKey(i)) {
                for (int num : reverseMap.get(i)) {
                    ints[index] = num;
                    index++;
                }
            }
        }

        return ints;
    }
    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int MaxLen = 0;
        Map<Character, Integer> used = new HashMap<>();

        for (Character c : s.toCharArray()) {

            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                MaxLen = Math.max(MaxLen, right - left + 1);
            }

            used.put(c, right);
            right++;
        }

        return MaxLen;
    }
    public static int numberJewels(String J, String S) {
        Map<Character, Integer> freq = new HashMap<>();
        for (Character c : J.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        System.out.println("freq.values() = " + freq.values());
        int ans =0;
        for (Character c : S.toCharArray()) {
            if (freq.containsKey(c)) {
                ans += 1;
            }
        }

        return ans;
    }
}
