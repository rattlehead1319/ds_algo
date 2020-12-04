package queue.basic;

public class ImplementQusingArray {
    class MyQueue {

        int front, rear;
        int arr[] = new int[100005];

        int size = 0;

        MyQueue()
        {
            front=0;
            rear=0;
        }

        /* The method push to push element
           into the queue */
        void push(int x)
        {
            if (size == 100005) {
                return;
            }
            rear = getRear() + 1;
            arr[rear] = x;
            size++;
        }

        /* The method pop which return the
           element poped out of the queue*/
        int pop()
        {
            if (size == 0) {
                return -1;
            }
            int x = arr[front];
            front = (front + 1) % 100005;
            size--;
            return x;
        }

        int getRear() {
            return (front + size - 1) % 100005;
        }
    }
}
