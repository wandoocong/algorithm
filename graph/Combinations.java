package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {

        List<List<Integer>> results = new ArrayList<>();
        int n = 5, k = 3;
//        dfs(results, new LinkedList<>(), n, 1, k);
        dfsWanSoo(results, new LinkedList<>(), n, 1, k);
        System.out.println("results = " + results);
        
        /*
        List<Integer> test = new ArrayList<>();
        test.add(7);
        test.add(5);
        test.remove(5);
        test.remove(Integer.valueOf(5));
        */
    }


    private static void dfs(List<List<Integer>> results, LinkedList<Integer> elements, int n, int start, int k) {
        if (k == 0) {
            List<Integer> result = new ArrayList<>();
            for (int e : elements) {
               result.add(e);
            }
            results.add(result);
            return;
        }

        for (int i = start; i <= n; i++) {
            elements.add(i);

            dfs(results, elements, n, i + 1, k - 1);

//            elements.remove(Integer.valueOf(i));
            elements.removeLast();
        }
    }
    private static void dfsWanSoo(List<List<Integer>> results, List<Integer> elements, int n, int start, int k) {
        if (k == 0) {
            /*
            @@@@@@@@@@@@ 주의 할점 @@@@@@@@@@@@@@@@@@@@
            results.add(elements);
            로 하면
            아래 elements.remove()할때 값 지워짐
            ??????????????????????????????????????????????
            */
            List<Integer> result = new ArrayList<>();
            for (int e : elements) {
                result.add(e);
            }
            results.add(result);
            return;
        }
        for (int i = start; i <= n; i++) {
            elements.add(i);
            dfsWanSoo(results, elements, n, i+1, k - 1);
            elements.remove(Integer.valueOf(i));
        }
    }
}
