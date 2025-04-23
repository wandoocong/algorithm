package alogorithm_part2.binary_Search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int num1[] = {4, 9, 5};
        int num2[] = {9, 4, 9, 8, 4, 6};

        /*int[] intersection = intersection(num1, num2);
        System.out.println("Arrays.toString(intersection) = " + Arrays.toString(intersection));*/
        int[] intersectionTwoP = intersectionTwoPointer(num1, num2);
        System.out.println("Arrays.toString(intersectionTwoP) = " + Arrays.toString(intersectionTwoP));
    }

    public static int[] intersection(int num1[], int num2[]){
        Set<Integer> result = new HashSet<>();
        //num2 정렬
        Arrays.sort(num2);

        for (int n1 : num1) {
            //BS 로 num2에서 num1 에 있는 요소로 매핑
            //num2 에 n1 이 있으면 인덱스 반환
            int i2 = Arrays.binarySearch(num2, n1);
            if (i2 >= 0) {
                result.add(n1);
            }
        }
        Integer[] array = result.toArray(new Integer[0]);
        int[] answer = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            answer[i] = array[i];
        }
        return answer;
    }

    public static int[] intersectionTwoPointer(int num1[], int num2[]){
        Set<Integer> result = new HashSet<>();
        Arrays.sort(num1);
        Arrays.sort(num2);

        int i = 0;
        int j = 0;

        while (i < num1.length && j < num2.length) {
            if (num1[i] > num2[j]) {
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            }else {
                result.add(num1[i]);
                i++;
                j++;
            }
        }

        Integer[] array = result.toArray(new Integer[0]);
        int[] answer = new int[array.length];
        for (int k = 0; k < array.length; k++) {
            answer[k] = array[k];
        }
        return answer;
        
    }

}
