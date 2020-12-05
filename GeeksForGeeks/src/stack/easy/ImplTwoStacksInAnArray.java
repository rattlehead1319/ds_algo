package stack.easy;

class TwoStack
{

    int size;
    int top1,top2;
    int arr[] = new int[100];

    TwoStack()
    {
        size = 100;
        top1 = -1;
        top2 = size;
    }
}

public class ImplTwoStacksInAnArray {
    void push1(int x, TwoStack sq)
    {
        if (sq.top1 == sq.top2) {
            return;
        }
        sq.arr[++sq.top1] = x;
    }

    /* The method push to push element into the stack 2*/
    void push2(int x, TwoStack sq)
    {
        if (sq.top1 == sq.top2) {
            return;
        }
        sq.arr[--sq.top2] = x;
    }

    /* The method pop to pop element from the stack 1 */
    //Return the popped element
    int pop1(TwoStack sq)
    {
        if (sq.top1 == -1) {
            return -1;
        }
        int x = sq.arr[sq.top1--];
        return x;
    }

    /* The method pop to pop element from the stack 2 */
    //Return the popper element
    int pop2(TwoStack sq)
    {
        if (sq.top2 == sq.size) {
            return -1;
        }
        int x = sq.arr[sq.top2++];
        return x;
    }
}
