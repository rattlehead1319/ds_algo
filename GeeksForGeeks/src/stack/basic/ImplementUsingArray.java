package stack.basic;

public class ImplementUsingArray {
    int top;
    int arr[] = new int[1000];

    ImplementUsingArray()
    {
        top = -1;
    }

    /* The method push to push element
        into the stack */
    void push(int a)
    {
        if (top == 999) {
            return;
        }
        arr[++top] = a;
    }

    /* The method pop which return
      the element poped out of the stack*/
    int pop()
    {
        if (top == -1) {
            return -1;
        }
        int a = arr[top--];
        return a;
    }
}
