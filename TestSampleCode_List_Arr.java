import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSampleCode_List_Arr {
    public static void main(String[] args) {
        // List
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(5);
        intList.add(15);
        Integer[] array = intList.toArray(new Integer[0]);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("####################################");

        // list 복사해서 새로 생성
        // 아래 생성방식들로 만든 list 에는 add 로 값 추가 불가능
        // 1. asList 로 생성
        List<Integer> list = Arrays.asList(1, 2, 3);

        ArrayList<Integer> testCopyList = new ArrayList<>(list);
        System.out.println("testCopyList = " + testCopyList);
        System.out.println("list = " + list);

        // 2. List.of 로 생성
        List<Character> chrlist = List.of('a', 'b', 'c');
        System.out.println("chrlist = " + chrlist);

        List<String> strlist = List.of("aba", "ASzzz");
        System.out.println("####################################");
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        int[] nums = {1, 2, 4};
        ArrayList<int[]> ints = new ArrayList<>(Arrays.asList(nums));
        System.out.println("ints = " + ints.get(0)[0]);

        System.out.println("####################################");

    }


}
