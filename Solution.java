import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static int N;
    static int[] building;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            N = sc.nextInt();
            building = new int[N];
            for (int i = 0; i < N; i++) {
                building[i] = sc.nextInt();
            }

            for (int i = 2; i <N-2 ; i++) {

                int right = Math.max(building[i + 1], building[i + 2]);
                int left = Math.max(building[i - 1], building[i - 2]);

                if (building[i] <= left || building[i] <= right) {
                    continue;
                }

                int max = Math.max(right, left);
                sum += building[i]-max;
            }

            System.out.println("#" + test_case + " " + sum);
        }

    }

}
