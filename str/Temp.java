package str;

import java.security.cert.CertPath;
import java.util.*;

public class Temp {



    public static void main(String[] args) {
        String str = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = {"hit"};

        String answer = mostCommonWord(str, banned);
        System.out.println("answer = " + answer);

    }

    public static String mostCommonWord(String p, String[] banned) {

        HashSet<String> asd = new HashSet<>(Arrays.asList(banned));

        HashMap<String, Integer> map = new HashMap<>();

        // \W
        String[] s = p.replaceAll("\\W+", " ").toLowerCase().split(" ");
        for (String str : s) {
            if(!asd.contains(str))
                map.put(str, map.getOrDefault(str, 0) + 1);
        }

        System.out.println("s = " + map.entrySet());
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        return Collections.max(list, Map.Entry.comparingByValue()).getKey();
    }


}
