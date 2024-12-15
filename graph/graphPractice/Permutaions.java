package graph.graphPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutaions {

    public static void main(String[] args) {

        List<Integer> lst = Arrays.asList(1,2,4);
        //List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 4));
        System.out.println("lst = " + lst);

        List<List<Integer>> as = new ArrayList<>();
        dfsWanSoo(as, new ArrayList<>(), lst);
        System.out.println("results = " + as);
    }

    private static void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
        // elemetns 에 있는 값들이 null 이 되었을때
        if (elements.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            for (int p : prevElements) {
                result.add(p);
            }
            results.add(result);
        }
                         //1,2,4
        for (Integer e : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            dfs(results, prevElements, nextElements);
            prevElements.remove(e);
        }
    }

    private static void dfsWanSoo(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {

        // 주의!!
        // 그냥 이렇게 하면 안됨, prevElements 값이 바뀌면서 results 값도 영향을 받음
        /*if (elements.isEmpty()) {
            results.add(prevElements);
            return;
        }*/

        // 새로 만들어서 해야함
        if (elements.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>(prevElements);
            results.add(temp);
            return;
        }

                         //1, 2, 4
        for (Integer e : elements) {
            ArrayList<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            dfsWanSoo(results, prevElements, nextElements);
                        // remove 로 특정 요소를 지우려면, 인자값이 Integer 이어야 한다.
                        // 만약 단순 int 값이면 Integer.valueOf 로 변경 필요
            prevElements.remove(e);
        }

    }


}
