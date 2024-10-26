import str.ReverseString;

import java.util.*;

public class TestSampleCode {

    public static void main(String[] args) {

        // 문자열 배열 출력
        char[] a = {'1', '2', '3', 'e', 'c', 'a', 'r'};
        System.out.println("a = " + Arrays.toString(a));

        // List
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println("list = " + list);

        List<Character> chrlist = List.of('a', 'b', 'c');
        System.out.println("a = " + chrlist);

        int[] nums = {1, 2, 4};
        ArrayList<int[]> ints = new ArrayList<>(Arrays.asList(nums));
        System.out.println("ints = " + ints);

        // Stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        System.out.println("stack.getFirst() = " + stack.getFirst());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());

        // Comparator
        List<String> str = new ArrayList<>();
        str.add("ab");
        str.add("cd");
        System.out.println("str = " + str);
        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("str = " + str);

        List<String> letterList = new ArrayList<>();
        letterList.add("asd");
        letterList.add("zxc");
        Object[] letterObj = letterList.toArray(new String[0]);
        System.out.println("letterArr = " + Arrays.toString(letterObj));
    }
}
