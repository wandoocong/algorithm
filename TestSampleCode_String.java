import java.util.Arrays;

public class TestSampleCode_String {
    public static void main(String[] args) {
        // StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder a1 = new StringBuilder(stringBuilder).append('a');
        a1.append('b');

        System.out.println("StringBuilder test = " + a1);


        // 문자열 배열 출력
        char[] a = {'1', '2', '3', 'e', 'c', 'a', 'r'};
        System.out.println("a = " + Arrays.toString(a));

        System.out.println("####################################");

    }


}
