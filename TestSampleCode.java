import str.ReverseString;

import java.util.*;

public class TestSampleCode {

    public static void main(String[] args) {

        // StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder a1 = new StringBuilder(stringBuilder).append('a');
        System.out.println("StringBuilder test = " + a1);

        // 해쉬맵 && Iterator
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Kim");
        map.put(2, "wan");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, String> next = it.next();
            int key = next.getKey();
            System.out.println("key = " + key);
            String value = next.getValue();
            System.out.println("value = " + value);
        }
        System.out.println("####################################");

        // 문자열 배열 출력
        char[] a = {'1', '2', '3', 'e', 'c', 'a', 'r'};
        System.out.println("a = " + Arrays.toString(a));

        System.out.println("####################################");

        // List
        List<Integer> list = Arrays.asList(1, 2, 3);
        ArrayList<Integer> testCopyList = new ArrayList<>(list);
        System.out.println("testCopyList = " + testCopyList);
        System.out.println("list = " + list);

        List<Character> chrlist = List.of('a', 'b', 'c');
        List<String> strlist = List.of("aba", "ASzzz");

        System.out.println("a = " + chrlist);

        int[] nums = {1, 2, 4};
        ArrayList<int[]> ints = new ArrayList<>(Arrays.asList(nums));
        System.out.println("ints = " + ints);

        System.out.println("####################################");

        // Stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack.getFirst() = " + stack.getFirst()); //3
        System.out.println("stack.getLast() = " + stack.getLast()); //1
        System.out.println("stack.pop() = " + stack.pop()); //3

        System.out.println("####################################");

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
