package str;

import java.security.cert.CertPath;
import java.util.*;

public class Temp {

    int left, maxLen;

    public static void main(String[] args) {
        String str = "dcbabcdd";
        String answer = "";

        Temp temp = new Temp();

        answer = temp.longest(str);
        System.out.println("answer = " + answer);
    }

    public String longest(String s) {
        int len = s.length();

        if(len<2) return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindro(s, i, i + 1);
            extendPalindro(s, i, i + 2);
        }

        return s.substring(left, left + maxLen);
    }
    public void extendPalindro(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            left = i + 1;
            maxLen = j - i - 1;
        }

    }
}
