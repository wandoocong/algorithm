package algorithm_part1.hashTable;

import java.util.HashMap;
import java.util.Map;

public class FuckingPussy {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        FuckingPussy fuckingPussy = new FuckingPussy();
        String solution = fuckingPussy.solution(participant, completion);
        System.out.println("solution = " + solution);
    }

    public String solution(String [] particapant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : particapant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String c : completion) {
            int left = map.get(c);

            if (left == 1) {
                map.remove(c);
            } else {
                map.put(c, left - 1);
            }
        }

        return map.entrySet().iterator().next().getKey();
    }
}
