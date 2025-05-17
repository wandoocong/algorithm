import java.util.*;

public class TestSampleCode {

    public static void main(String[] args) {

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




        // Stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack.getFirst() = " + stack.getFirst()); //3
        System.out.println("stack.getLast() = " + stack.getLast()); //1
        System.out.println("stack.peekLast() = " + stack.peekLast()); //1
        System.out.println("stack.pop() = " + stack.pop()); //3
        System.out.println("####################################");




        // Comparator
        List<String> str = new ArrayList<>();
        str.add("ab");
        str.add("cd");
        System.out.println("before comparator= " + str);
        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("after comparator= " + str);

        List<String> letterList = new ArrayList<>();
        letterList.add("asd");
        letterList.add("zxc");
        letterList.add("FFA");
        Object[] letterObj = letterList.toArray(new String[0]);
        System.out.println("letterArr = " + Arrays.toString(letterObj));

        int[][] arr2D={{1,3},{8,11},{2,6},{15,18}};
        Arrays.sort(arr2D,Comparator.comparingInt(a->a[0]));
        System.out.println("arr2D = " + Arrays.toString(arr2D[1]));
        System.out.println("####################################");

    }
}
