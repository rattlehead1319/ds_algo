package heap.problems.easy;

public class BinaryHeapOperations {
    int[] harr;
    int capacity = 0;
    int heap_size = 0;
    BinaryHeapOperations(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    // You need to write code for below three functions
    int extractMin() {
        if (heap_size == 0) {
            return -1;
        }
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }
        swap(0, heap_size - 1);
        heap_size--;
        MinHeapify(0);
        return harr[heap_size];
    }

    void insertKey(int k) {
        if (heap_size == capacity) {
            return;
        }
        heap_size++;
        harr[heap_size - 1] = k;
        int index = heap_size - 1;
        while (index != 0 && harr[parent(index)] > harr[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    void deleteKey(int i) {
        if (i < 0 || i > heap_size - 1) {
            return;
        }
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    void swap(int i, int j) {
        int temp = harr[i];
        harr[i] = harr[j];
        harr[j] = temp;
    }

    // Decrease key operation, helps in deleting the element
    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
