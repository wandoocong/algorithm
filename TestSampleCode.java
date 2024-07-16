import java.util.*;

public class TestSampleCode {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println("list = " + list);

        List<Character> chrlist = List.of('a', 'b', 'c');
        System.out.println("a = " + chrlist);


        int[] nums = {1, 2, 4};
        ArrayList<int[]> ints = new ArrayList<>(Arrays.asList(nums));
        System.out.println("ints = " + ints);


        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        System.out.println("stack.getFirst() = " + stack.getFirst());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
    }
}
