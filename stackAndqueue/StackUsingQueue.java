package stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {

        StackUsingQueue stackUsingQueue = new StackUsingQueue();

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    public static class MyStack{
        // 큐 구현
        Queue<Integer> queue = new LinkedList<>();

        public void push(int x) {
            queue.add(x);
            for (int i = 1; i<queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            //크기 비교해서 비어있는지 확인
            return queue.size() == 0;
        }
    }
}

