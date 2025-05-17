package alogorithm_part2.Greedy;

import java.util.Arrays;
import java.util.List;

public class AssignCookie {
    public static void main(String[] args) {

        int[] kidsGreedIndex = {1, 2, 3, 4};
        int[] CookieSize = {1, 1};

        int contenetChildren = findContenetChildren(kidsGreedIndex, CookieSize);
        System.out.println("contenetChildren = " + contenetChildren);
    }

    // Key Point : 각각의 index 를 다르게 가져가서 비교하면 된다.
    public static int findContenetChildren(int[] k, int[] c) {
        Arrays.sort(k);
        Arrays.sort(c);

        int cnt = 0;
        int index = 0;
        for (int cookieIndex = 0; cookieIndex < c.length; cookieIndex++) {
            if(c[cookieIndex] >= k[index])
            {
                cnt++;
                index++;
            }
        }
        return cnt;
    }

    public static int findContenetChildrenBook(int[] k, int[] c) {
        Arrays.sort(k);
        Arrays.sort(c);

        int i = 0; //어린이
        int j = 0; //쿠키
        while (i < k.length && j < c.length) {
            if (c[j] >= k[i]) {
                i++;
            }
            j++;
        }
        return i;
    }

}
