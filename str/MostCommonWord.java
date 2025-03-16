package str;

import java.util.*;

public class MostCommonWord {

    public static void main(String[] args) {

        String str = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = {"hit"};
        
//        System.out.println(" ################### ");
//        System.out.println("replaceALL 테스트 = " + str.replaceAll("\\W+", " ") );
//        System.out.println(" ################### ");

        String answer = mostCommonWord(str, banned);
        System.out.println("answer = " + answer);

    }

    public static String mostCommonWord(String p, String[] banned) {

        // 금지항목 문자열 Array -> List 로 변환 후 Set 으로 변경 
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        
        // 각 단어 저장할 Map 만들기
        Map<String, Integer> counts = new HashMap<>(); 

        // 전처리 작업
        // 모든 단어 분리
                                   // \W+, 문자가 아닌 모든 연속적인 것
        String [] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String w : words) {
            if(!ban.contains(w)){
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }

//        System.out.println("counts.entrySet() = " + counts.entrySet());
        List<Map.Entry<String, Integer>> list = new ArrayList<>(counts.entrySet());

        return Collections.max(list, Map.Entry.comparingByValue()).getKey();
    }


}
