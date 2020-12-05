package stack.basic;

class StackNode
{
    int data;
    StackNode next;
    StackNode(int a)
    {
        data = a;
        next = null;
    }
}

public class ImplementStackUsingLL {
    StackNode top;

    void push(int a) {
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
    }
    int pop() {
        if (top == null) {
            return -1;
        }
        int x = top.data;
        top = top.next;
        return x;
    }
}
