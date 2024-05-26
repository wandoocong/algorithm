package str;

import java.util.*;

public class RecorderLogFiles {

    public static void main(String[] args) {

        String[] strings = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art can"};

        //" " 으로 나눈것중 0번째 배열
        //System.out.println(str.split(" ")[0].charAt(0));

        //" " 을 통해 두개로 나누기
        //String[] s1x = str.split(" ", 2);

        // 구현하기
        String[] answers = recordLogFiles(strings);
        System.out.println("answers = " + Arrays.toString(answers));

    }

    public static String [] recordLogFiles(String [] logs){

        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        // 문자는 문자 List 에 넣기
        // 숫자는 숫자 List 에 넣기
        for(String log : logs) {
            //식별자를 제외한 값이 숫자인지 문자인지 확인
            if(Character.isDigit(log.split(" ")[1].charAt(0))){
                digitList.add(log);
            }else{
                letterList.add(log);
            }
        }

        Collections.sort(letterList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                //식별자와 아닌값으로 2등분
                String[] s1x = o1.split(" ", 2);
                String[] s2x = o2.split(" ", 2);

                // 식별자가 아닌 값으로 문자열 비교
                int compare = s1x[1].compareTo(s2x[1]);
                if (compare == 0) {
                    //문자열 값이 같으면 식별자로 비교
                    return s1x[0].compareTo(s2x[0]);
                } else {
                    return compare;
                }
            }
        });

        //문자 sorting 된값에 정수 List 붙이기
        letterList.addAll(digitList);

        // List 값을 String 배열로 반환
        return letterList.toArray(new String[0]);
    }



}
