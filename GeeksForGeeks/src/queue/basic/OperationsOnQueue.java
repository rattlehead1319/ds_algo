package queue.basic;

public class OperationsOnQueue {
    int cap = 100000;
    int[] arr = new int[cap];
    int frnt, rear, size = 0;

    void enqueue(int x){
        if (size == cap) {
            return;
        }
        rear = getRear() + 1;
        arr[rear] = x;
        size++;
    }
    void dequeue(){
        if (size == 0) {
            return;
        }
        frnt = (frnt + 1)%cap;
        size--;
    }
    int front(){
        return arr[frnt];
    }
    String find(int x){
        for (int i = frnt; i <= rear; i++) {
            if (arr[i] == x) {
                return "Yes";
            }
        }
        return "No";
    }
    int getRear () {
        return (frnt + size - 1)%cap;
    }
}
