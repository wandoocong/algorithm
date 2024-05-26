package str;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
//        char[] a = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        char[] a = {'1', '2', '3', 'e', 'c', 'a', 'r'};

        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(a);

        System.out.println("a = " + Arrays.toString(a));


    }

    public void reverseString(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }

    }
}
