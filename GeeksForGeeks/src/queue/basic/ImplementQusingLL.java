package queue.basic;

class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}

public class ImplementQusingLL {
    QueueNode front, rear;

    // This function should add an item at
    // rear
    void push(int a)
    {
        QueueNode n = new QueueNode(a);
        if (rear == null) {
            rear = n;
            front = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }

    // This function should remove front
    // item from queue and should return
    // the removed item.
    int pop()
    {
        if (front == null) {
            return -1;
        }
        QueueNode temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp.data;
    }
}
