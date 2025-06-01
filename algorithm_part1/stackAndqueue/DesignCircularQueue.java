package algorithm_part1.stackAndqueue;

public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(4);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(2);
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
    }

    public static class MyCircularQueue{
        int[] q;
        int front =0, rear =-1, len = 0;

        public MyCircularQueue(int k) {
            this.q = new int[k];
        }

        public boolean enQueue(int value) {
            if (!this.isFull()) {
                rear = (rear + 1) % q.length;
                q[rear] = value;
                len++;
                return true;
            }else{
                return false;
            }
        }

        public int deQueue() {
            if (!this.isEmpty()) {
                int temp = q[front];
                front = (front +1) % q.length;
                len--;
                return temp;
            }else{
                return -1;
            }
        }

        public int Front() {
            return (this.isEmpty()) ? -1 : q[this.front];
        }
        public int Rear() {
            return (this.isEmpty()) ? -1 : q[this.rear];
        }

        public boolean isEmpty() {
            return len == 0;
        }
        public boolean isFull() {
            return len == q.length;
        }
    }
}
