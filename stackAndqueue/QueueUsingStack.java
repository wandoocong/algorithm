package stackAndqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStack {

    public static void main(String[] args) {

        MyQue myQue = new MyQue();
        myQue.push(3);
        System.out.println(myQue.pop());
        myQue.push(2);
        System.out.println(myQue.pop());
    }

    public static class MyQue{

        Deque<Integer> input = new ArrayDeque<>();
        Deque<Integer> output = new ArrayDeque<>();

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if(output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }

    }
}
