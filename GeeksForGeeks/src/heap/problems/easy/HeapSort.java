package heap.problems.easy;

public class HeapSort {
    //This building of heap takes O(n) time
    //Maximum nodes at any height -> ceil(n/2^(h+1))
    //Total time -> lognEh=1 (ceil(n/2^(h+1)) * O(h)
    //which is O(n) .. revisit to understand how
    void buildHeap(int arr[], int n)
    {
        for (int i = (n-2)/2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;
        if (left < n && arr[left] > arr[i]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int [] arr = new int[]{4, 1, 3, 9, 7};
        hs.buildHeap(arr, 5);

        for (int i=4; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            hs.heapify(arr, i, 0);
        }

        for (int i =0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
